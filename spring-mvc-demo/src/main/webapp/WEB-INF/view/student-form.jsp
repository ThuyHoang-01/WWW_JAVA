<%@ page pageEncoding="UTF-8" language="java" contentType="text"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Student - Input Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br><br>
		Last Name: <form:input path="lastName" />
		<br><br>
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br><br>
		<form:checkboxes path="operatingSystems" items="${student.operatingSystemOptions}"/>
		<br><br>
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
	
	

</body>
</html>