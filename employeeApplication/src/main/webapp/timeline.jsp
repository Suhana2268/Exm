<%@page import="employeeApplication.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome <%= session.getAttribute("id") %>  <br>

<input type=hidden id="uid" value=<%= session.getAttribute("id") %>>

<a href="GlobalServlet?ac=viewEmployee">View Employee</a>
<a href=GlobalServlet?ac=deleteProfile>Delete Profile</a>
<a href="#"  onclick="editemployee()">Edit Profile</a>
<a href=GlobalServlet?ac=displayAllProfile>Display all Profile</a>
<br>
<br>


<%
	out.println("with java code");
	List<Employee> employeeList= (List<Employee>)request.getAttribute("data");
	

	if(employeeList.size()>0){
	for(Employee emp:employeeList){
		out.println(emp.getName());
		out.println(emp.getPassword());
		out.println(emp.getEmail());
		out.println(emp.getDepartment());
	}
	} 

%>



</body>
</html>