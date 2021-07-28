import java.sql.*;

import javax.swing.JOptionPane;

class AdminData
{	
	AdminLogin n;
	String name,pass,address,mail,contact,gender;
	int id;
	int flag = 0;
	
	public AdminData(AdminLogin n)
	{
		this.n = n;
		
		try{
			Connection con=DB.getConnection();
			Statement stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM `admin`");
			
			while(rs.next())
			{
				if(rs.getString(2).equals(n.adminName) && rs.getString(3).equals(n.adminPassword))
				{
					n.setVisible(false);
					
					id = rs.getInt(1);
					name = rs.getString(2);
					pass = rs.getString(3);
					address = rs.getString(4);
					mail = rs.getString(5);
					contact = rs.getString(6);
					gender = rs.getString(7);
					
					AdminPage m = new AdminPage(this);
					flag = 1;
					break;
				}
			}
			
			if(flag == 0)
			{
				JOptionPane.showMessageDialog(null,"Login Failed!");
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("Unknown Error");
		}
		
		catch(Exception eg)
		{
			System.out.println("Unknown Error");
		}
	}
	
	public AdminData(String query)
	{
		try
		{
			Connection con=DB.getConnection();
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate(query);	
		}
		
		catch(SQLException e)
		{
			System.out.println("Unknown Error");
		}
		
		catch(Exception eg)
		{
			System.out.println("Unknown Error");
		}
	}
} 