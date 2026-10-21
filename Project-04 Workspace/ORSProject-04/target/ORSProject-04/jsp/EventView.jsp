<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.EventBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	/* EventBean bean = (EventBean) request.getAttribute("bean"); */
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("true", "yes");
	map.put("false", "no");
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.EventBean"
		scope="request"></jsp:useBean>

	<!-- FIX: pt-5 rakha upar ke liye, pb-5 ki jagah extra inline padding-bottom
	     diya taaki fixed/sticky Footer neeche content (Save button) ko overlap na kare -->
	<div
		class="container d-flex justify-content-center align-items-center pt-5"
		style="padding-bottom: 100px !important;">

		<div class="card shadow-sm border-0"
			style="width: 100%; max-width: 700px;">

			<div class="card-header bg-white text-center border-bottom py-4">
				<h2 class="text-primary fw-bold mb-1">
					<i class="fa-solid fa-user-shield"></i>
					<%=bean != null && bean.getId() > 0 ? "Update Event" : "Add Event"%>
				</h2>
				<p class="text-secondary mb-0">Manage Event</p>
			</div>

			<div class="card-body p-4">

				<%
				if (_suc != null && _suc.length() > 0) {
				%>
				<div class="alert alert-success text-center py-2"><%=_suc%></div>
				<%
				}
				if (_err != null && _err.length() > 0) {
				%>
				<div class="alert alert-danger text-center py-2"><%=_err%></div>
				<%
				}
				%>

				<form action="<%=ORSView.EVENT_CTL%>" method="post">

					<input type="hidden" name="id"
						value="<%=DataUtility.getStringData(bean.getId())%>">

					<div class="mb-3">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-user text-primary"></i> Event Name <span
							class="text-danger">*</span>
						</label> <input type="text" name="eventName"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getEventName())%>"
							placeholder="enter event name"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("eventName", request)%></small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Description <span
							class="text-danger">*</span>
						</label> <input type="text" name="description"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getDescription())%>"
							placeholder="enter description"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("description", request)%></small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Venue <span
							class="text-danger">*</span>
						</label> <input type="text" name="venue"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getVenue())%>"
							placeholder="enter venue"> <small class="text-danger"><%=ServletUtility.getErrorMessage("venue", request)%></small>
					</div>


					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Organizer <span
							class="text-danger">*</span>
						</label> <input type="text" name="organizer" class="form-control duration"
							value="<%=DataUtility.getStringData(bean.getOrganizer())%>"
							placeholder="enter organizer"> <small class="text-danger"><%=ServletUtility.getErrorMessage("organizer", request)%></small>
					</div>


					<div class="text-center">
						<input type="submit" name="operation" class="btn btn-primary px-4"
							value="<%=bean != null && bean.getId() > 0 ? "Update" : BaseCtl.OP_SAVE%>">
					</div>

				</form>
			</div>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>