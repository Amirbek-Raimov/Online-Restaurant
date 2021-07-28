
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class PizzaPage extends JPanel implements ActionListener
{
	Pizza p;
	JPanel panel[];
	JLabel pic[];
	JLabel name[];
	JLabel price[];
	JButton btn[];
	int row;
	Connection con;
	Statement stmnt;
	
	public PizzaPage()
	{
        try
		{
        	Connection con=DB.getConnection();
			stmnt = con.createStatement();
		}
		
		catch(SQLException e)
		{
			System.out.println("Unknown Error");
		}
		
		catch(Exception eg)
		{
			System.out.println("Unknown Error");
		}		
		
		setLayout(new GridLayout(9,4));
		setBackground(new Color(0, 0, 0));
		
		p = new Pizza();
		
		row = (p.PizzaList).getRowCount();
		
		panel = new JPanel[row];
		pic = new JLabel[row];
		name = new JLabel[row];
		price = new JLabel[row];
		btn = new JButton[row];
		
		for(int i=0;i<row;i++)
		{	
			panel[i] = new JPanel();
			panel[i].setLayout(new BoxLayout(panel[i],BoxLayout.PAGE_AXIS));
			panel[i].add(Box.createRigidArea(new Dimension(50,50)));
			panel[i].setBackground(new Color(0, 0, 0));
			
			pic[i] = new JLabel((ImageIcon)((p.PizzaList).getValueAt(i,4)));
			name[i] = new JLabel(" - " + (String)(p.PizzaList).getValueAt(i,1) + " -");
			name[i].setFont(new Font("Bell MT", Font.BOLD, 22));
			name[i].setForeground(new Color(255, 250, 240));
			
			price[i] = new JLabel(" RMB " + ((Double)((p.PizzaList).getValueAt(i,2))).toString());
			price[i].setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			price[i].setForeground(new Color(255, 250, 240));
			
			btn[i] = new JButton("ADD TO CART");
			btn[i].setFont(new Font("Verdana", Font.PLAIN, 12));
			
			panel[i].add(name[i]);
			panel[i].add(price[i]);
			panel[i].add(pic[i]);
			panel[i].add(btn[i]);
			
			add(panel[i]);
			
			btn[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent a)
	{
		   for(int i=0;i<row;i++)
			{
				if(a.getSource() == btn[i])
				{
					btn[i].setEnabled(false);
					String name = (String)(p.PizzaList).getValueAt(i,1);
					Double pro_Price = (Double)(p.PizzaList).getValueAt(i,2);
						
						try
						{
							stmnt.executeUpdate("INSERT INTO `Temp_Order` (`Product_Name`, `Product_Price`) VALUES ('"+name+"', '"+pro_Price+"');");
						}
//						catch(SQLException e)
//						{
//							JOptionPane.showMessageDialog(null,"You have already inserted this item");
//						}
						catch(Exception eg)
						{
							System.out.println("Unknown Error");
						}
				}
			}
	}
}