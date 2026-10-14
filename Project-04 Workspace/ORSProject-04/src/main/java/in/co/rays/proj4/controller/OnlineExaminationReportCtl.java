package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.OnlineExaminationBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.OnlineExaminationModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/OnlineExaminationReportCtl")

public class OnlineExaminationReportCtl extends BaseReportCtl<OnlineExaminationBean>{

	public List<OnlineExaminationBean> getList() {
		OnlineExaminationModel model = new OnlineExaminationModel();
		@SuppressWarnings("unchecked")
		List<OnlineExaminationBean> subjects = model.list();
		return subjects;
	}

	public String getView() {
		return ORSView.ONLINEEXAMINATION_REPORT_VIEW;
	}

	public String getCompiledReportKey() {
		return "ONLINEEXAMINATION_LIST_COMPILED_REPORT";
	}

}
