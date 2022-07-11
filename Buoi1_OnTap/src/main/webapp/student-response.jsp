<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	 The student is confirmed : ${param.firstName} ${param.lastName} 
	 </br> The student is country: ${param.country}
	 </br> Favorite Programming Language:
	<ul>
		<%
		String[] langs = request.getParameterValues("ToThuy");
		for (String tempLang : langs){
			out.println("<li>" + tempLang + "</li>");
		}
		
		%>
	
	</ul>
</body>
</html>