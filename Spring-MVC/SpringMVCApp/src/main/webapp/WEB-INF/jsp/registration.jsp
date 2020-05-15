<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>Registration</h2>
	<form:form modelAttribute="registration">
		<form:errors path="*" element="div"></form:errors>
		<table>
			<tr>
				<td>
					<spring:message code="name"/>
				</td>
				<td>
					<form:input path="name"/>
				</td>
				<td>
					<form:errors path="name"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" rowspan="3">
					<input type="submit" value=<spring:message code="save.changes"/>>
				</td>
			</tr>
			
		</table>
	
	</form:form>
</body>
</html>