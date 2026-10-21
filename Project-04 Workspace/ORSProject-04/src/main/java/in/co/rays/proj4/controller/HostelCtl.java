package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.HostelBean;
import in.co.rays.proj4.model.HostelModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HostelCtl")

public class HostelCtl extends BaseCtl<HostelBean, HostelModel> {

	@Override
	protected boolean validate(HttpServletRequest request) { 
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("hostelName"))) {
			request.setAttribute("hostelName", "Hostel Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("hostelType"))) {
			request.setAttribute("hostelType", "Hostel Type is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("contactNo"))) {
			request.setAttribute("contactNo", "Contact No is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("wardenName"))) {
			request.setAttribute("wardenName", "Warden Name is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", "Address is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected HostelBean populateBean(HttpServletRequest request) {

		HostelBean bean = new HostelBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setHostelName(DataUtility.getString(request.getParameter("hostelName")));
		bean.setHostelType(DataUtility.getString(request.getParameter("hostelType")));
		bean.setContactNo(DataUtility.getString(request.getParameter("contactNo")));

		bean.setWardenName(DataUtility.getString(request.getParameter("wardenName")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.HOSTEL_VIEW;
	}

	@Override
	protected HostelModel getModel() {
		return new HostelModel();
	}

}
