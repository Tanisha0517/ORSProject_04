<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	List<StudentBean> studentList = (List) request.getAttribute("studentList");
	%>

	<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

		<div align="center">

			<h1>Add MarkSheet</h1>

			<h3 style="color: green"><%=_suc%></h3>
			<h3 style="color: red"><%=_err%></h3>

			<table>
			
			
			
			    <tr>
					<th>Roll No<font color="red">*</font></th>
					<td><input type="text" name="rollNo" value=""
						placeholder="enter role no"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("rollNo", request)%></td>
				</tr>
				
				<tr>
					<th>Name<font color="red">*</font></th>
					<!-- <td><select class='form-control' name='studentId'>
							<option selected value=''>-------------Select------------</option>
							<%
							for (StudentBean sbean : studentList) {
							%>
							<option value='<%=sbean.getKey()%>'><%=sbean.getValue()%></option>
							<%
							}
							%>
					</select></td>
					 -->
					 
					 <td><%=HTMLUtility.getList("studentId", "" ,studentList) %></td>
					 <!-- name, student list object -->
					 
				
				<tr>
					<th>Student Id<font color="red">*</font></th>
					<td><input type="text" name="studentId" value=""
						placeholder="enter Student ID"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("studentId", request)%></td>
				</tr>

				<!--  <tr>
					<th>Name<font color="red">*</font></th>
					<td><input type="text" name="name" value=""
						placeholder="enter name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr> -->

				<tr>
					<th>Physics<font color="red">*</font></th>
					<td><input type="text" name="physics" value=""
						placeholder="enter physics"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("physics", request)%></td>
				</tr>

                <tr>
					<th>Chemistry<font color="red">*</font></th>
					<td><input type="text" name="chemistry" value=""
						placeholder="enter chemistry"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("chemistry", request)%></td>
				</tr>
                
                <tr>
					<th>Maths<font color="red">*</font></th>
					<td><input type="text" name="maths" value=""
						placeholder="enter maths"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("maths", request)%></td>
				</tr>
				
				
				
                
                
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=BaseCtl.OP_SAVE%>"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>