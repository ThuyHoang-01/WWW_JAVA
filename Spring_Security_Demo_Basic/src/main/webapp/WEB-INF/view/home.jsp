<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>SE Company Home Page</title>
</head>
<body>
	<h2>SE Company Home Page</h2>
	<hr>
	Welcome to the SE Company home page!
	<hr>

	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>

	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>