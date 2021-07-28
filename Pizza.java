
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


class Pizza
{
	JTable PizzaList;
	
	public Pizza()
	{  	
		try
		{
			Connection con=DB.getConnection();
			Statement stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM `pizza`");
			
			ResultSetMetaData rsmetadata = rs.getMetaData();
			int col = rsmetadata.getColumnCount();
			DefaultTableModel dtm = new DefaultTableModel();
			
			Vector<String> col_name = new Vector<String>();
			Vector<Object> row_data = new Vector<Object>();
			
			for(int i=1;i<=col;i++)
			{
				col_name.addElement(rsmetadata.getColumnName(i));
			}
			
			dtm.setColumnIdentifiers(col_name);
			
			while(rs.next())
			{
				row_data = new Vector<Object>();
				
				row_data.addElement(rs.getInt("Food_Id"));
				row_data.addElement(rs.getString("Name"));
				row_data.addElement(rs.getDouble("Price"));
				row_data.addElement(rs.getString("Category"));
				byte[] pic = rs.getBytes("Image");
				ImageIcon img = new ImageIcon(pic);
				img.getImage();
				
				row_data.addElement(img);
				
				dtm.addRow(row_data);
			}
			
			PizzaList = new JTable();
			PizzaList.setModel(dtm);
		}
		
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		catch(Exception eg)
		{
			System.out.println(eg);
		}
	}
}