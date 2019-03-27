<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vendor Login</title>
<style>
body{ background-color:powderblue;}
form{text-align: center;}
.center{ display:block; margin-left: auto; margin-right: auto; width: :50%;	}
</style>
</head>

<body>
<img src="tiger.jfif" class="center">
<h1 style="text-align: center;">LIVE STORE</h1>

<form action="Login" method="get">
<fieldset>
<legend>*****</legend>
<b><i>Enter UserName:</i></b><br><input type="text" name="name"><br>
<i>Enter Password:</i><br><input type="password" name="pwd"><br>
<br><input type="submit" value="Submit">
<input type="reset" value="Reset">
</fieldset>
<a href="Registration.jsp">Register Here</a>
</form>

</body>
</html>