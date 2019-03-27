package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VendorDAO {
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
	public static int SaveDetails(Vendor v)
	{
		int savedstatus=0;
		try
		{
			Connection con=VendorDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("insert into vendor values(?,?,?,?,?,?)");
			String name="create table "+v.getName()+" (productid int(10),productname varchar(100), quantity int(10), price float(7,2))";
			PreparedStatement pss=con.prepareStatement(name);
			ps.setString(1,v.getName());
			ps.setString(2,v.getPhone());
			ps.setString(3,v.getEmail());
			ps.setString(4,v.getAddress());
			ps.setString(5,v.getPwd());
			ps.setString(6,"NULL");
			int s=pss.executeUpdate();
			savedstatus=ps.executeUpdate();
			savedstatus+=s;
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return savedstatus;
	}
	public static String GetPassword(String name)
	{
		String password="";
		try
		{
			Connection con=VendorDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select password from vendor where name=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			password=rs.getString("password");
			//System.out.println(password);	
			}		
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return password;
	}
	public static ArrayList GetVendorDetails(String name)
	{
		ArrayList<Vendor> list=new ArrayList<Vendor>();
		Vendor v=new Vendor();
		try
		{
			Connection con=VendorDAO.GetConnection();
			PreparedStatement ps= con.prepareStatement("Select * from vendor where name=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				v.setName(rs.getString("name"));
				v.setPhone(rs.getString("phone"));
				v.setEmail(rs.getString("email"));
				v.setAddress(rs.getString("address"));
				v.setPwd(rs.getString("password"));
				v.setProducts(rs.getString("products"));
				list.add(v);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	@SuppressWarnings("rawtypes")
	public static ArrayList DisplayAllProducts()
	{
		ArrayList<Product> list=new ArrayList<Product>();
		try
		{
			Connection con=VendorDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getFloat(5));
				p.setQuantity(rs.getInt(6));
				list.add(p);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static int StoreProducts(VendorProducts vp)
	{
		int status=0;
		try
		{
			Connection con=VendorDAO.GetConnection();
			String statement="insert into "+vp.getName()+" values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(statement);
			ps.setInt(1,vp.getProductid());
			ps.setString(2,vp.getProductname());
			ps.setInt(3,vp.getQuantity());
			ps.setFloat(4,vp.getPrice());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
}
