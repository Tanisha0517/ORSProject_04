package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.model.BankModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/BankCtl")

public class BankCtl extends BaseCtl<BankBean, BankModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("bankId"))) {
			request.setAttribute("bankId", "Bank Id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("bankName"))) {
			request.setAttribute("bankName", "Bank Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("branchName"))) {
			request.setAttribute("branchName", "Branch Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("ifscCode"))) {
			request.setAttribute("ifscCode", "Ifsc Code is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", "Address is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected BankBean populateBean(HttpServletRequest request) {

		BankBean bean = new BankBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setBankId(DataUtility.getString(request.getParameter("bankId")));
		bean.setBankName(DataUtility.getString(request.getParameter("bankName")));
		bean.setBranchName(DataUtility.getString(request.getParameter("branchName")));

		bean.setIfscCode(DataUtility.getString(request.getParameter("ifscCode")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.BANK_VIEW;
	}

	@Override
	protected BankModel getModel() {
		return new BankModel();
	}

}
