package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.model.BankModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/BankListCtl")

public class BankListCtl extends BaseListCtl<BankBean, BankModel> {

	@Override
	protected BankBean populateBean(HttpServletRequest request) {
		BankBean bean = new BankBean();
		bean.setBankName(DataUtility.getString(request.getParameter("bank_name")));
		bean.setIfscCode(DataUtility.getString(request.getParameter("ifsc_code")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.BANK_LIST_VIEW;
	}

	@Override
	protected BankModel getModel() {
		return new BankModel();

	}

}
