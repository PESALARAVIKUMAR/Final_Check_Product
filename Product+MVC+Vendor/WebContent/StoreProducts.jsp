<%@page import="p1.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="p1.VendorDAO"%>
<%@page import="p1.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String pname="";
float price=0;
VendorProducts vp= new VendorProducts();
String name=application.getAttribute("name").toString();
vp.setName(name);
int productid=Integer.parseInt(request.getParameter("pid"));
vp.setProductid(productid);
ArrayList<Product> list=new ArrayList<Product>();
list=ProductDAO.GetDetails(productid);
for(Product p:list)
{
	pname=p.getName();
	price=p.getPrice();
}
vp.setPrice(price);
vp.setProductname(pname);
vp.setQuantity(2);
int s=VendorDAO.StoreProducts(vp);
if(s>0)
{
	out.println("<script>alert('Products Added')</script>");
	request.getRequestDispatcher("DisplayAll").forward(request,response);
}
else
{
	System.out.println("ErroR");
}
%>
</body>
</html>