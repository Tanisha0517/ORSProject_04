package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.bean.OnlineExaminationBean;
import in.co.rays.proj4.model.OnlineExaminationModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/OnlineExaminationListCtl")

public class OnlineExaminationListCtl extends BaseListCtl<OnlineExaminationBean, OnlineExaminationModel> {

	@Override
	protected OnlineExaminationBean populateBean(HttpServletRequest request) {
		OnlineExaminationBean bean = new OnlineExaminationBean();
		bean.setSubject(DataUtility.getString(request.getParameter("subject")));
//		bean.setIfscCode(DataUtility.getString(request.getParameter("ifsc_code")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.ONLINEEXAMINATION_LIST_VIEW;
	}

	@Override
	protected OnlineExaminationModel getModel() {
		return new OnlineExaminationModel();
	}

}
