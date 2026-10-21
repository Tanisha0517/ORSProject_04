<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.HostelBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hostel</title>

<!-- Bootstrap CSS/JS already loaded via Header.jsp -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<%@ include file="Header.jsp"%>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);

	HashMap<String, String> map = new HashMap<String, String>();

	map.put("Boys", "Boys");
	map.put("Girls", "Girls");
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.HostelBean"
		scope="request"></jsp:useBean>

	<div
		class="container d-flex justify-content-center align-items-center pt-5"
		style="padding-bottom: 100px !important;">

		<div class="card shadow-sm border-0"
			style="width: 100%; max-width: 700px;">

			<div class="card-header bg-white text-center border-bottom py-4">
				<h2 class="text-primary fw-bold mb-1">
					<i class="fa-solid fa-user-shield"></i>
					<%=bean != null && bean.getId() > 0 ? "Update Hostel" : "Add Hostel"%>
				</h2>
				<p class="text-secondary mb-0">Manage Hostel</p>
			</div>

			<div class="card-body p-4">

				<%
				if (_suc != null && _suc.length() > 0) {
				%>
				<div class="alert alert-success text-center py-2">
					<%=_suc%>
				</div>
				<%
				}

				if (_err != null && _err.length() > 0) {
				%>
				<div class="alert alert-danger text-center py-2">
					<%=_err%>
				</div>
				<%
				}
				%>

				<form action="<%=ORSView.HOSTEL_CTL%>" method="post">

					<input type="hidden" name="id"
						value="<%=DataUtility.getStringData(bean.getId())%>">

					<div class="mb-3">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-user text-primary"></i> Hostel Name <span
							class="text-danger">*</span>
						</label> <input type="text" name="hostelName"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getHostelName())%>"
							placeholder="enter hostel name"> <small
							class="text-danger"> <%=ServletUtility.getErrorMessage("hostelName", request)%>
						</small>
					</div>

					<div class="col-md-6 mb-3">
						<label class="form-label fw-bold"> <i
							class="bi bi-gender-ambiguous text-success"></i> Hostel Type <span
							class="text-danger">*</span>
						</label>

						<%=HTMLUtility.getList("hostelType", DataUtility.getStringData(bean.getHostelType()), map)%>

						<small class="text-danger"> <%=ServletUtility.getErrorMessage("hostelType", request)%>
						</small>
					</div>



					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Contact No <span
							class="text-danger">*</span>
						</label> <input type="text" name="contactNo" class="form-control duration"
							value="<%=DataUtility.getStringData(bean.getContactNo())%>"
							placeholder="enter contact no"> <small
							class="text-danger"> <%=ServletUtility.getErrorMessage("contactNo", request)%>
						</small>
					</div>


					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Warden Name <span
							class="text-danger">*</span>
						</label> <input type="text" name="wardenName"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getWardenName())%>"
							placeholder="enter warden name"> <small
							class="text-danger"> <%=ServletUtility.getErrorMessage("wardenName", request)%>
						</small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Address <span
							class="text-danger">*</span>
						</label> <input type="text" name="address" class="form-control duration"
							value="<%=DataUtility.getStringData(bean.getAddress())%>"
							placeholder="enter address"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("address", request)%>
						</small>
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