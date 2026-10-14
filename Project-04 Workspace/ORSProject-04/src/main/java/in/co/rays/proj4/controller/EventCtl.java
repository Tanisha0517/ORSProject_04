package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.EventBean;
import in.co.rays.proj4.model.EventModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/EventCtl")

public class EventCtl extends BaseCtl<EventBean, EventModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("eventName"))) {
			request.setAttribute("eventName", "Event Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", "Description is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("venue"))) {
			request.setAttribute("venue", "venue is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("organizer"))) {
			request.setAttribute("organizer", "organizer is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected EventBean populateBean(HttpServletRequest request) {

		EventBean bean = new EventBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEventName(DataUtility.getString(request.getParameter("eventName")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		bean.setVenue(DataUtility.getString(request.getParameter("venue")));
		bean.setOrganizer(DataUtility.getString(request.getParameter("organizer")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.EVENT_VIEW;
	}

	@Override
	protected EventModel getModel() {
		return new EventModel();
	}

}
