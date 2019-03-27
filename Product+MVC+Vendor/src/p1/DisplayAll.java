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
 * Servlet implementation class DisplayAll
 */
@WebServlet("/DisplayAll")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext sc=request.getServletContext();
		//System.out.println(sc.getAttribute("name").toString());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<Product> list=new ArrayList<Product>();
		list=VendorDAO.DisplayAllProducts();
		out.print("<table style='width=100%; border:1px'");
		out.print("<tr><th>Enter & Click</th><th>Product Id</th><th>Product Name</th><th>Category</th><th>Description</th><th>Price</th><th>Quantity</th></tr>");
		for(Product pp:list)
		{
			out.print("<tr><td><input type='text' name='quantity' style='width:30px;'><a href='StoreProducts.jsp?pid="+pp.getId()+"'><button style='width:50px;'>Add</button></a></td><td>"+pp.getId()+"</td><td>"+pp.getName()+"</td><td>"+pp.getCategory()+"</td><td>"+pp.getDescription()+"</td><td>"+pp.getPrice()+"</td><td>"+pp.getQuantity()+"</td></tr>");
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
