<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function validate(){
		var v=document.getElementById("pwd").value;
		if(v.length>=4  && v.length<6){
			//alert("week password")
			document.getElementById("result").innerHTML="<font color=red>week password</font>";
		}
		if(v.length>=6  && v.length<8){
			//alert("week password")
			document.getElementById("result").innerHTML="<font color=yellow>medium password</font>";
		}
		if(v.length>=8){
			//alert("week password")
			document.getElementById("result").innerHTML="<font color=green>strong password</font>";
		}
		console.log(v);
	}
	
</script>


</head>
<body  style = "background: #ADA996;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
">
  <center>
	
	<form action="GlobalServlet?ac=register" method="post">
	<p id="abc" class="def"><font color="white" size="5"><b> Sign Up Page </b></font></p>
		<table border="5">
			<tr>
			<tr>
				<td>Name</td><td><input type=text name="nm" required  minlength="3" maxlength="10" id = "name" onchange="upperCase()" onfocus = "focusEvent()" onblur = "onBlurEvent()"></td>
			</tr>
			<tr>
				<td>Password</td><td><input type=password id="pwd" name="pass" required minlength="4" maxlength="15" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" onkeyup="validate()"><div id="result"></div></td>
			</tr>
			<tr>
				<td>Email</td><td><input type=email name="em" id = "email" onkeyup="validateEmail()"><div id = "emailresult"></div></td>
			</tr>
			<tr>
				<td>Department</td><td><input type=text name="dep" id = "dep" onblur="viewCaptcha()"></td>
			</tr>
				<td><input type=submit class = "btn" id = "ss" value=Register disabled></td><td><input class = "rst" type=reset></td>
			</tr>
		</table>
	</form>
  </center>
${ message }
</body>
</html>