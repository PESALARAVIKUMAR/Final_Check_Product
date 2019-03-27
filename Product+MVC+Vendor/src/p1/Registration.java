package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Vendor v=new Vendor();
		String name=request.getParameter("name");
		v.setName(name);
		String phone=request.getParameter("phone");
		v.setPhone(phone);
		String email=request.getParameter("email");
		v.setEmail(email);
		String address=request.getParameter("address");
		v.setAddress(address);
		String pwd1=request.getParameter("pwd1");
		String pwd2=request.getParameter("pwd2");
		if((phone.matches("[0-9]{10}"))&(pwd1.equals(pwd2)))
		{
			v.setPwd(pwd1);
			int savedstatus=VendorDAO.SaveDetails(v);
			if(savedstatus>0)
			{
				out.println("<script>alert('Registration Success')</script>");
				request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
			else
			{
				out.println("<script>alert('Registration failed')</script>");
			}			
		}
		else
		{
			out.println("<script>alert('Re-Enter Password Correctly')</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
