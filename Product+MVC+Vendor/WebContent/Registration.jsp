<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h2 style="text-align: center;">Register Here</h2>
<form name="f" action="Registration" method="post">
Enter UserName:<br><input type="text" name="name"><br>
Enter Phone:<br><input type="text" name="phone"><br>
Enter Email:<br><input type="text" name="email"><br>
Enter Address<br><textarea type="text" name="address" style="width:150px; height:150px;"></textarea><br>
Enter Password:<br><input type="password" name="pwd1"><br>
Re-Enter Password:<br><input type="password" name="pwd2"><br>
<br><input type="submit" value="Submit"><input type="reset" value="Reset">
</form>
</body>
</html>