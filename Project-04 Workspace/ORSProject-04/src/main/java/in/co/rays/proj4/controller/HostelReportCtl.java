package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.HostelBean;
import in.co.rays.proj4.model.HostelModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/HostelReportCtl")

public class HostelReportCtl extends BaseReportCtl<HostelBean>{
	public List<HostelBean> getList() {
		HostelModel model = new HostelModel();
		@SuppressWarnings("unchecked")
		List<HostelBean> hostel = model.list();
		return hostel;
	}

	public String getView() {
		return ORSView.HOSTEL_REPORT_VIEW;
	}

	public String getCompiledReportKey() {
		return "HOSTEL_LIST_COMPILED_REPORT";
	}
}
