package p1;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
public class ProductDAO 
{
	public static Connection GetConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ravi","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int SaveDetails(Product p)
	{
		int savedstatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
			System.out.println(p.getId());
			ps.setInt(1,p.getId());
			ps.setString(2,p.getName());
			ps.setString(3,p.getCategory());
			ps.setString(4,p.getDescription());
			ps.setFloat(5,p.getPrice());
			savedstatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return savedstatus;
	}
	public static ArrayList GetDetails(int id)
	{
		ArrayList<Product> list=new ArrayList<Product>();
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from product where productid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getFloat(5));
				list.add(p);
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static int UpdateDetails(Product p)
	{
		int updatestatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("update product set productname=?,description=?,price=? where productid=?");
			ps.setString(1,p.getName());
			ps.setString(2,p.getDescription());
			ps.setFloat(3,p.getPrice());
			ps.setInt(4,p.getId());
			updatestatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return updatestatus;
	}
	public static int DeleteProduct(Product p)
	{
		int delstatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where productid=?");
			ps.setInt(1,p.getId());
			delstatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return delstatus;
	}
	
}

