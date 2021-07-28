
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class BeveragePage extends JPanel implements ActionListener
{
	Beverage b;
	JPanel p[];
	JLabel pic[];
	JLabel name[];
	JLabel price[];
	JButton btn[];
	int row;
	Connection con;
	Statement stmnt;
	
	public BeveragePage()
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
		
        setLayout(new GridLayout(5,5));
		setBackground(new Color(0, 0, 0));
		
		b = new Beverage();
		
		row = (b.BevarageList).getRowCount();
		
		p = new JPanel[row];
		pic = new JLabel[row];
		name = new JLabel[row];
		price = new JLabel[row];
		btn = new JButton[row];
		
		for(int i=0;i<row;i++)
		{	
			p[i] = new JPanel();
			p[i].setLayout(new BoxLayout(p[i],BoxLayout.PAGE_AXIS));
			p[i].add(Box.createRigidArea(new Dimension(50,50)));
			p[i].setBackground(new Color(0, 0, 0));
			
			pic[i] = new JLabel((ImageIcon)((b.BevarageList).getValueAt(i,4)));
			name[i] = new JLabel(" - " + (String)(b.BevarageList).getValueAt(i,1) + " -");
			name[i].setFont(new Font("Bell MT", Font.BOLD, 22));
			name[i].setForeground(new Color(255, 250, 240));
			
			price[i] = new JLabel(" RMB " + ((Double)((b.BevarageList).getValueAt(i,2))).toString());
			price[i].setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			price[i].setForeground(new Color(255, 250, 240));
			
			btn[i] = new JButton("ADD TO CART");
			btn[i].setFont(new Font("Verdana", Font.PLAIN, 12));
			
			p[i].add(name[i]);
			p[i].add(price[i]);
			p[i].add(pic[i]);
			p[i].add(btn[i]);
			
			add(p[i]);
			
			btn[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		   for(int i=0;i<row;i++)
			{
				if(e.getSource() == btn[i])
				{
					btn[i].setEnabled(false);
					String name = (String)(b.BevarageList).getValueAt(i,1);
					Double pro_Price = (Double)(b.BevarageList).getValueAt(i,2);
						
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