<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function editemployee(){
		var v=document.getElementById("uid").value;
		
		var xhr=new XMLHttpRequest();
		xhr.open("GET","GlobalServlet?ac=editEmployee&uid="+v,true);
		xhr.send();
		
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				console.log(xhr.responseText);
				//eval("response = "+xhr.responseText+";");
				document.getElementById("editresult").innerHTML=xhr.responseText;
				}
		}
	}
	

</script>


</head>
<body>


<h3> Welcome <%= session.getAttribute("id") %></h3>


<input type=hidden id="uid" value=<%= session.getAttribute("id") %>>


<a href="GlobalServlet?ac=viewEmployee">View Employee</a>
<a href="#"  onclick="editemployee()">Edit Profile</a>
<a href=GlobalServlet?ac=displayAllProfile>Display all Profile</a>
<br>
<br>

Name is ${ asd.name } <br>
Password is ${ asd.password } <br>
Email is ${ asd.email } <br>
Department is ${ asd.department }<br>

<div id="editresult"></div>
<br>
<br>

</head>
<body>