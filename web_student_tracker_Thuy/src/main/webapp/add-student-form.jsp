<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add student form</title>
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>

<body>
	<div class="container">
		<div class="header pt-4 pb-4 font-weight-bold text-light">
			<h1>Add Student Form</h1>
		</div>
		<div class="control mt-4 mb-4">
			<a type="button" class="btn btn-primary"
				href="StudentControllerServlet">Back to Dashboard</a>
		</div>


		<form id="form" class="mb-8" action="StudentControllerServlet"
			method="GET">
			<input type="hidden" name="command" value="ADD">

			<div class="form-group">
				<label for="firstName">First name</label> <input type="text"
					name="firstName" class="form-control" id="firstName"
					placeholder="Enter your first Name">
			</div>
			<div class="form-group">
				<label for="lastName">Last name</label> <input type="text"
					name="lastName" class="form-control" id="lastName"
					placeholder="Enter your last Name">
			</div>
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					name="email" class="form-control" id="email"
					placeholder="Enter your email address">
			</div>
			<button type="submit" class="btn btn-primary" value="Save">Add
				student</button>
		</form>
	</div>
</body>

</html>