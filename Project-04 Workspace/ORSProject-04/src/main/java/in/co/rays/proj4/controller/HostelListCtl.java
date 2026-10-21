package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.HostelBean;
import in.co.rays.proj4.model.HostelModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ctl/HostelListCtl")

public class HostelListCtl extends BaseListCtl<HostelBean, HostelModel> {
	@Override
	protected HostelBean populateBean(HttpServletRequest request) {
		HostelBean bean = new HostelBean();
		bean.setHostelName(DataUtility.getString(request.getParameter("hostel_name")));
		bean.setWardenName(DataUtility.getString(request.getParameter("warden_name")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.HOSTEL_LIST_VIEW;
	}

	@Override
	protected HostelModel getModel() {
		return new HostelModel();

	}
}
