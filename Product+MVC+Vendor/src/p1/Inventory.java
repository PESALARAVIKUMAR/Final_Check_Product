package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inventory
 */
@WebServlet("/Inventory")
public class Inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext sc=request.getServletContext();
		String name=sc.getAttribute("name").toString();
		System.out.println(name);
		ArrayList<VendorProducts> list=new ArrayList<VendorProducts>();
		list=VendorProductsDAO.GetVendorProducts(name);
		out.print("<table width='100%' border:1px");
		out.print("<tr><th>Product Id</th><th>Product Name</th><th>Price</th><th>Quantity</th></tr>");		
		for(VendorProducts vp:list)
		{
			out.print("<tr><td>"+vp.getProductid()+"</td><td>"+vp.getProductname()+"</td><td>"+vp.getPrice()+"</td><td>"+vp.getQuantity()+"</td></tr>");
		}
		out.print("</table>");
		out.println("<br><br><a href='HomePage.html' target='_parent'><button>HOMEPAGE</button></a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
