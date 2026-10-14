package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.EventBean;
import in.co.rays.proj4.model.EventModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/EventReportCtl")

public class EventReportCtl extends BaseReportCtl<EventBean>{



	public List<EventBean> getList() {
		EventModel model = new EventModel();
		@SuppressWarnings("unchecked")
		List<EventBean> courses = model.list();
		return courses;
	}

	public String getView() {
		return ORSView.EVENT_REPORT_VIEW;
	}

	/**
	 * Returns the ServletContext cache key for the compiled event report.
	 *
	 * @return {@code "COURSE_LIST_COMPILED_REPORT"}
	 */
	public String getCompiledReportKey() {
		return "EVENT_LIST_COMPILED_REPORT";
	}

}
