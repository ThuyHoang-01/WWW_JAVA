<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Step 1: Create HTML form -->
	<jsp:include page="student-form.html"/>
	
	The student is confirmed: ${param.firstName} ${param.lastName} 
	Favorite Programming Languages:
	<ul>
		<%
		String[] langs = request.getParameterValues("favoriteLanguage");
		if(langs != null){
			for (String temp : langs) {
				out.println("<li>" + temp + "<li>");
			}
		}
		%>
	</ul>
</body>
</html>