<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Login Page</title>
</head>

<body>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<c:if test="${param.error !=null}">
			<i class="failed">Sorry! You entered invalid user name/password.</i>
		</c:if>
		
		<p>
			User name: <input type="text" name="username"/>
		</p>
		
		<p>
			Password: <input type="password" name="password"/>
		</p>
		
		<input type="submit" value="Login"/>
		
		<c:if test="${param.logout !=null}">
			<div class="alert alert-success col-xs-offset-1 col-xs-10">You have been logged out.</div>
		</c:if>
	</form:form>	
</body>
</html>









