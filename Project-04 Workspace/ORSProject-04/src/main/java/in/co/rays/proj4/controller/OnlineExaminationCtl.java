package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.OnlineExaminationBean;
import in.co.rays.proj4.model.OnlineExaminationModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/OnlineExaminationCtl")

public class OnlineExaminationCtl extends BaseCtl<OnlineExaminationBean, OnlineExaminationModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("subject"))) {
			request.setAttribute("subject", "Subject is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("totalQuestions"))) {
			request.setAttribute("total_questions", "Total Questions are require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("duration"))) {
			request.setAttribute("duration", "Duration is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("totalMarks"))) {
			request.setAttribute("total_marks", "Total Marks is require");
			pass = false;
		}
		return pass;
	}

	@Override
	protected OnlineExaminationBean populateBean(HttpServletRequest request) {

		OnlineExaminationBean bean = new OnlineExaminationBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setSubject(DataUtility.getString(request.getParameter("subject")));
		bean.setTotalQuestions(DataUtility.getInt(request.getParameter("totalQuestions")));
		bean.setDuration(DataUtility.getInt(request.getParameter("duration")));
		bean.setTotalMarks(DataUtility.getInt(request.getParameter("totalMarks")));

		
		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.ONLINEEXAMINATION_VIEW;
	}

	@Override
	protected OnlineExaminationModel getModel() {
		return new OnlineExaminationModel();
	}

	
}
