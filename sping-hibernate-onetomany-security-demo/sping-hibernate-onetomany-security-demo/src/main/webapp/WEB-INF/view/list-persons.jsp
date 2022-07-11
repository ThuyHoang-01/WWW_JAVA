<%-- 
    Document   : person
    Created on : Mar 13, 2021, 7:43:39 PM
    Author     : Trần Thái Minh Tân
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap2.min.css"
	rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/jquery/jquery-3.3.1.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/bootstrap2.min.js' />"></script>
<c:url var="pattern" value="/resources/img/bg.jpg" />
<style>
* {
	margin: 0px auto;
	padding: 0px;
}

body {
	background-image: url(${pattern});
}

caption h1 {
	color: #FF0000;
	background: linear-gradient(to right, #9DD7E1, white, #9DD7E1);
	margin-bottom: 5px;
	margin-top: 5px;
	text-shadow: 3px 4px 5px orange;
}

tbody {
	background: #00FFCC;
}

nav {
	width: 100%;
	height: 50px;
	background-color: black;
	line-height: 50px;
	text-align: center;
	border-radius: 5px;
}

li a {
	text-decoration: none;
	font-weight: bold;
	font-family: Tahoma;
	color: yellow;
}

.menu li {
	width: 140px;
	height: 50px;
	float: left;
	list-style: none;
	text-indent: 4px;
	position: relative;
}

.menu li:hover {
	background-color: #808080;
}

.menu li:hover a {
	color: white;
}

span {
	color: yellow;
	float: right;
	padding-right: 10px;
}

span a {
	color: yellow;
	float: right;
	padding-right: 10px;
}

span a:hover {
	color: white;
}
</style>
</head>
<body>
	<div class="container">
		<c:url var="editImgUrl" value="/resources/img/edit.png" />
		<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
		<c:url var="viewImgUrl" value="/resources/img/eye.png" />
		<c:url var="addUrl" value="/person/showFormForAdd" />
		<div class="col-md-12">
			<nav class="nav">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/home">Trang
						chủ</a></li>
				<li><a href="${pageContext.request.contextPath}/person/list">Danh
						sách hồ sơ</a></li>
				<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<li><a href="${addUrl}">Thêm hồ sơ mới</a></li>
				</security:authorize>
			</ul>
			<security:authorize access="hasAnyRole('EMPLOYEE','MANAGER', 'ADMIN')">
				<span> User: <security:authentication
						property="principal.username" />, Role(s): <security:authentication
						property="principal.authorities" /> &nbsp; <%-- 				<a href="${pageContext.request.contextPath}/showMyLoginPage?logout">Logout</a> --%>

				</span></nav>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" value="Logout" />
			</form:form>
			</security:authorize>
		</div>
		<div class="col-md-12">
			<section class="table-responsive">
			<table class="table table-striped">
				<caption>
					<h1>Hồ sơ người dùng</h1>
				</caption>
				<thead style="background: #CC99FF">
					<tr>
						<th>Mã</th>
						<th style="width: 200px;">Họ</th>
						<th>Tên</th>
						<th>Số tiền</th>
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
							<th
								style="border-radius: 50px; width: 130px; text-align: center;">Sửa</th>
						</security:authorize>
						<security:authorize access="hasAnyRole('ADMIN')">
							<th
								style="border-radius: 50px; width: 130px; text-align: center;">Xóa</th>
						</security:authorize>
						<th style="border-radius: 50px; width: 130px; text-align: center;">Xem
							thẻ tín dụng</th>
						<!--<th colspan="3"></th>-->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${persons}" var="person">

						<c:url var="editUrl" value="/person/showFormForUpdate">
							<c:param name="personId" value="${person.id}" />
						</c:url>
						<c:url var="deleteUrl" value="/person/delete">
							<c:param name="personId" value="${person.id}" />
						</c:url>
						<c:url var="viewUrl" value="/creditcard/list">
							<c:param name="personId" value="${person.id}" />
						</c:url>

						<tr>
							<td><c:out value="${person.id}" /></td>
							<td><c:out value="${person.firstName}" /></td>
							<td><c:out value="${person.lastName}" /></td>
							<td><c:out value="${person.money}" /></td>
							<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
								<td style="border-radius: 50px; text-align: center;"><a
									href="${editUrl}"><img src="${editImgUrl}" /> </a></td>
							</security:authorize>
							<security:authorize access="hasAnyRole('ADMIN')">
								<td style="border-radius: 50px; text-align: center;"><a
									href="${deleteUrl}"><img src="${deleteImgUrl}" /></a></td>
							</security:authorize>
							<td style="border-radius: 50px; text-align: center;"><a
								href="${viewUrl}"><img src="${viewImgUrl}" /></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			</section>
		</div>
	</div>

	<c:if test="${empty persons}">
            No records found. 
        </c:if>
</body>
</html>
