<%@page import="java.util.ArrayList"%>
<%@page import="iuh.fit.src.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%
// just create some sample data ... normally provided by MVC
String[] cities = { "1. Mumbai", "2. Singapore", "3. Vietnam" };
pageContext.setAttribute("myCities", cities);
%>

<%
List<Student> data = new ArrayList<>();

data.add(new Student("John", "Doe", true));
data.add(new Student("Max", "John", true));
data.add(new Student("Mary", "Jane", false));
pageContext.setAttribute("myStudents", data);
%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="tempCity" items="${myCities}">
	${tempCity} <br />
	</c:forEach>

	<br></br>

	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Sex</th>
		</tr>
		<c:forEach var="tempStudent" items="${myStudents}">
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td><c:if test="${tempStudent.sex}">
					Male
					</c:if> <c:if test="${not tempStudent.sex}">
					Female
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<br></br>

	<c:set var="data" value="we love 2 code" />
	Length of the string <b>${data}</b>: ${fn:length(data)}
	<br></br>	
	Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}
	<br></br>
	Does the string <b>${data}</b> start with <b>luv</b>?: ${fn:startsWith(data, "luv")}
</body>
</html>