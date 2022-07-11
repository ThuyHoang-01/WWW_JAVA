<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="./css/style.css"></link>
</head>

<body>
	<div id="wrapper">
		<div class="container">
			<div class="header pt-4 pb-4 font-weight-bold text-white bg-primary">
				<h1>FooBar University</h1>
			</div>
			
			<div class="control mt-4">
				<button type="button" class="btn btn-primary"
					onclick="window.location.href='add-student-form.jsp'; return false;">
					Add Student</button>
			</div>

			<div class="show-data mt-4">
				<table class="table table-striped table-hover">
					<thead class="bg-primary">
						<tr class="text-white">
							<th>Student ID</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>


					<tbody>
						<!-- Duyet va render ra danh sach sinh vien -->
						<c:forEach var="tempStudent" items="${STUDENT_LIST}">

							<!-- Tao link cho tung Student -->
							<c:url var="tempLink" value="StudentControllerServlet">
								<c:param name="command" value="LOAD"></c:param>
								<c:param name="studentId" value="${tempStudent.id}"></c:param>
							</c:url>

							<!-- Tao link delete cho Student -->
							<c:url var="deleteLink" value="StudentControllerServlet">
								<c:param name="command" value="DELETE"></c:param>
								<c:param name="studentId" value="${tempStudent.id}"></c:param>
							</c:url>


							<tr>
								<td>${tempStudent.id}</td>
								<td>${tempStudent.firstName}</td>
								<td>${tempStudent.lastName}</td>
								<td>${tempStudent.email}</td>
								<td><a class="btn btn-primary" href="${tempLink}">Update</a>
									<a class="btn btn-danger" href="${deleteLink}"
									onclick="if (!confirm('Are you sure you want to delete this student?')) { return false; }">
										Delete </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>