package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.EventBean;
import in.co.rays.proj4.model.EventModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/EventListCtl")

public class EventListCtl extends BaseListCtl<EventBean, EventModel>{

	@Override
	protected EventBean populateBean(HttpServletRequest request) {
		EventBean bean = new EventBean();
		bean.setEventName(DataUtility.getString(request.getParameter("event_name")));
		bean.setOrganizer(DataUtility.getString(request.getParameter("organizer")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.EVENT_LIST_VIEW;
	}

	@Override
	protected EventModel getModel() {
		return new EventModel();

	}


}
