<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="p1.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #ccc;">
<img src="panda.jfif" style="padding-left:13%;">
<b><i>

<%	ArrayList<Vendor> list=new ArrayList<Vendor>();
	String name=application.getAttribute("name").toString();
	list=VendorDAO.GetVendorDetails(name);
	for(Vendor v:list)
	{
		%><h3><%=v.getName() %></h3>
		<h3><%=v.getPhone() %></h3>
		<h3><%=v.getEmail() %></h3>
		<h4><%=v.getAddress() %></h4><%
	}
%>
</i></b>
</body>
</html>