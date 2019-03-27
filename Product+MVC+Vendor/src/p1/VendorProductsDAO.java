package p1;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class VendorProductsDAO 
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
	public static ArrayList GetVendorProducts(String name)
	{
		ArrayList<VendorProducts> list=new ArrayList<VendorProducts>();
		try
		{
			Connection con=ProductDAO.GetConnection();
			String statement="select * from "+name;
			PreparedStatement ps=con.prepareStatement(statement);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				VendorProducts vp=new VendorProducts();
				vp.setProductid(rs.getInt(1));
				vp.setProductname(rs.getString(2));
				vp.setQuantity(rs.getInt(3));
				vp.setPrice(rs.getFloat(4));
				list.add(vp);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
}
