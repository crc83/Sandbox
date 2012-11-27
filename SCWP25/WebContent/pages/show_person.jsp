<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="employee" type="org.sbelei.Person" class="org.sbelei.Employee">
	<jsp:setProperty name="employee" property="*"/>
</jsp:useBean>
<table>
	<tr><td>Employee:</td><td>${employee.name}</td></tr>
	<tr><td>Gender:</td><td>${employee.gender}</td></tr>
	<tr><td>Phone:</td><td>${employee["phone"]}</td></tr>
	<tr><td>Manager name:</td><td>${employee["manager"].name}</td></tr>
	<tr><td>Manager name:</td><td>${employee["manager"]["name"]}</td></tr>
</table>
<hr>
 <%= employee %>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>