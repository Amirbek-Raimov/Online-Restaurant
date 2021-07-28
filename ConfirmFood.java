import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class ConfirmFood implements ActionListener
{
	JFrame f;
	ArrayList<String> name;
	ArrayList<Double> price;
	JLabel nameArr[],priceArr[];
	JPanel mainPanel;
	JPanel setLabel;
	JPanel items[];
	JLabel setName,setQuantity,setPrice,setCancel;
	JSpinner quantityArr[];
	SpinnerNumberModel model[];
	//JButton delete[];
	JScrollPane scroll;
	int arrSize;
	JPanel order;
	JLabel topText;
	int flag;
	JLabel showTotal;
	JLabel netTotal;
	JPanel totalAmount;
	JButton confirm,cancel;
	JPanel confirmation;
	Double total;
	Connection con;
	Statement stmnt;
	
	public ConfirmFood()
	{
		name = new ArrayList<String>();
		price = new ArrayList<Double>();
		total = 0.0;
		
		try
		{
			Connection con=DB.getConnection();
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM `temp_order`");
			
			while(rs.next())
			{
				name.add(rs.getString(1));
				price.add(rs.getDouble(2));
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
		
		arrSize = name.size();
	
	    nameArr = new JLabel[arrSize];
	    priceArr = new JLabel[arrSize];
	    quantityArr = new JSpinner[arrSize];
	   // delete = new JButton[arrSize];
		model = new SpinnerNumberModel[arrSize];
		items = new JPanel[arrSize];
		
		order = new JPanel();
		order.setBackground(new Color(255, 153, 153));
		order.setLayout(new BoxLayout(order,BoxLayout.PAGE_AXIS));
		topText = new JLabel("");
		topText.setIcon(new ImageIcon(ConfirmFood.class.getResource("/images/confirm.png")));
		topText.setForeground(new Color(255, 51, 51));
		topText.setAlignmentX(Component.CENTER_ALIGNMENT);
		topText.setFont(new Font("Verdana", Font.BOLD, 50));
		order.add(topText);
		
		setLabel = new JPanel();
		setLabel.setBackground(new Color(255, 153, 153));
		setLabel.setLayout(new BoxLayout(setLabel,BoxLayout.LINE_AXIS));
		setLabel.add(Box.createRigidArea(new Dimension(50,0)));
		
		setName = new JLabel("Food_Name");
		setName.setFont(new Font("Verdana", Font.BOLD, 12));
		setQuantity = new JLabel("Quantity");
		setQuantity.setFont(new Font("Verdana", Font.BOLD, 12));
		setPrice = new JLabel("Price");
		setPrice.setFont(new Font("Verdana", Font.BOLD, 12));
		setCancel = new JLabel("Cancel");
		setCancel.setFont(new Font("Verdana", Font.BOLD, 12));
		setCancel.setForeground(new Color(255, 153, 153));
		
		setLabel.add(setName);
		setLabel.add(Box.createRigidArea(new Dimension(50,0)));
		setLabel.add(setQuantity);
		setLabel.add(Box.createRigidArea(new Dimension(50,0)));
		setLabel.add(setPrice);
		setLabel.add(Box.createRigidArea(new Dimension(50,0)));
		setLabel.add(setCancel);
		setLabel.add(Box.createRigidArea(new Dimension(50,0)));
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 153, 153));
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		mainPanel.add(Box.createRigidArea(new Dimension(50,50)));
		
		mainPanel.add(order);
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		
		mainPanel.add(setLabel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		
		for(int i=0;i<arrSize;i++)
		{
			
			items[i] = new JPanel();
			items[i].setBackground(new Color(255, 153, 153));
			items[i].setLayout(new BoxLayout(items[i],BoxLayout.LINE_AXIS));
			items[i].add(Box.createRigidArea(new Dimension(50,0)));
			
			nameArr[i] = new JLabel(name.get(i));
			priceArr[i] = new JLabel((price.get(i)).toString());
			total+=price.get(i);
			model[i] = new SpinnerNumberModel(1,1,1000,1);
			quantityArr[i] = new JSpinner(model[i]);
		//	delete[i] = new JButton("Delete");
		//	delete[i].setForeground(new Color(255, 255, 255));
		//	delete[i].setBackground(new Color(255, 51, 51));
		//	delete[i].setFont(new Font("Verdana", Font.BOLD, 12));
			
			items[i].add(nameArr[i]);
			items[i].add(Box.createRigidArea(new Dimension(50,0)));
			quantityArr[i].setMaximumSize(quantityArr[i].getPreferredSize());
			items[i].add(quantityArr[i]);
			items[i].add(Box.createRigidArea(new Dimension(50,0)));
			items[i].add(priceArr[i]);
			items[i].add(Box.createRigidArea(new Dimension(50,0)));
			//items[i].add(delete[i]);
			items[i].add(Box.createRigidArea(new Dimension(50,0)));
			
			mainPanel.add(items[i]);
			mainPanel.add(Box.createRigidArea(new Dimension(50,50)));
		}
		
		totalAmount = new JPanel();
		totalAmount.setBackground(new Color(255, 153, 153));
		totalAmount.setLayout(new BoxLayout(totalAmount,BoxLayout.LINE_AXIS));
		totalAmount.add(Box.createRigidArea(new Dimension(100,50)));
		
		netTotal = new JLabel("");
		netTotal.setIcon(new ImageIcon(ConfirmFood.class.getResource("/images/total.png")));
		netTotal.setForeground(new Color(0, 153, 102));
		netTotal.setFont(new Font("Verdana", Font.BOLD, 15));
		totalAmount.add(netTotal);
		showTotal = new JLabel(total.toString());
		showTotal.setFont(new Font("Papyrus", Font.BOLD, 49));
		totalAmount.add(showTotal);
		totalAmount.add(Box.createRigidArea(new Dimension(50,0)));
		mainPanel.add(totalAmount);
		mainPanel.add(Box.createRigidArea(new Dimension(50,50)));
		
		confirm = new JButton("Confirm");
		confirm.setFont(new Font("Verdana", Font.BOLD, 12));
		confirm.setBackground(new Color(0, 204, 102));
		confirm.setForeground(new Color(255, 255, 255));
		cancel = new JButton("Cancel");
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setBackground(new Color(255, 51, 51));
		cancel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		
		confirmation = new JPanel();
		confirmation.setBackground(new Color(255, 153, 153));
		confirmation.setLayout(new BoxLayout(confirmation,BoxLayout.LINE_AXIS));
		confirmation.add(Box.createRigidArea(new Dimension(50,50)));
		
		confirmation.add(confirm);
		confirmation.add(Box.createRigidArea(new Dimension(150,0)));
		confirmation.add(cancel);
		confirmation.add(Box.createRigidArea(new Dimension(50,0)));
		
		mainPanel.add(confirmation);
		mainPanel.add(Box.createRigidArea(new Dimension(50,50)));
		
		
		
		ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
    
	    JSpinner s = (JSpinner) e.getSource();
	
    for(int i=0;i<arrSize;i++)
	{
		if(s == quantityArr[i])
		{
			if(!(priceArr[i].getText()).equals("")) //a deleted row's  priceArr[i].getText() is equal to null
			{
				total-=(Double.parseDouble(priceArr[i].getText()));
				Double d = price.get(i);
			    Double ans = (((Integer)s.getValue())*d);
			    priceArr[i].setText(ans.toString());
				total+=ans;
				showTotal.setText(total.toString());
			    break;
			}
		}
	}
      
	}
    
	};
	
	for(int i=0;i<arrSize;i++)
	{
		quantityArr[i].addChangeListener(listener);
		//delete[i].addActionListener(this);
	}
		
		scroll = new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		topText_1 = new JLabel("");
		topText_1.setForeground(new Color(255, 51, 51));
		topText_1.setFont(new Font("Verdana", Font.BOLD, 50));
		topText_1.setAlignmentX(0.5f);
		mainPanel.add(topText_1);
		
		f = new JFrame();
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmFood.class.getResource("/images/icon.jpg")));
		f.setSize(800,800);
		f.getContentPane().add(scroll);
		
		f.setVisible(true);
	
	}
	
	String foodName;
	private JLabel topText_1;
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == confirm)
		{
			if(arrSize != 0)
			{
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(20,20)));
			JLabel l = new JLabel("Enter your name");
			panel.add(l);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			JTextField field1 = new JTextField(10);
			panel.add(field1);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			JLabel l1 = new JLabel("Enter your address");
			panel.add(l1);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			JTextField field2 = new JTextField(10);
			panel.add(field2);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			JLabel l2 = new JLabel("Enter your contact no");
			panel.add(l2);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			JTextField field3 = new JTextField(10);
			panel.add(field3);
			panel.add(Box.createRigidArea(new Dimension(0,20)));
			
			int value = JOptionPane.showConfirmDialog(f, panel, "Enter your information", JOptionPane.OK_CANCEL_OPTION);
			
			if (value == JOptionPane.OK_OPTION)
			{
				 String s1 = field1.getText();
				 String s2 = field2.getText();
				 String s3 = field3.getText();
				 
				 if((!s1.equals("")) && (!s2.equals("")) && (!s3.equals("")))
				 {
					 JOptionPane.showMessageDialog(null,"Please wait for confirmation call at your number","Order is confirmed",JOptionPane.INFORMATION_MESSAGE);
					 f.setVisible(false);
					 try
						{
							stmnt.executeUpdate("TRUNCATE `temp_order`");
						   
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
                 else
				 {
					 JOptionPane.showMessageDialog(null,"You have not submitted required information !!","Enter your info",JOptionPane.INFORMATION_MESSAGE);
				 }					 
			}
			
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You have not selected any item !!","Not selected",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(a.getSource() == cancel)
		{
			 int ans = JOptionPane.showConfirmDialog(null," Are you sure ?",null, JOptionPane.YES_NO_OPTION);
				
				if (ans == JOptionPane.YES_OPTION)
				{
					f.setVisible(false);
					try
					{
						stmnt.executeUpdate("TRUNCATE `temp_order`");
					    JOptionPane.showMessageDialog(null," Order cancelled !!! ");
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
		else
		{
//			for(int i=0;i<arrSize;i++)
//			{
//				if(a.getSource() == delete[i])
//				{
//					flag = i;
//					foodName = (nameArr[flag].getText());System.out.println(total);
//					//total-=(Double.parseDouble(priceArr[flag].getText()));System.out.println(total);
//					//showTotal.setText(total.toString());
//					price.remove(flag);
//					break;
//				}
//			}
//			
			if(flag != (arrSize-1))
			{
				for(int i=flag+1;i<arrSize;i++)
				{
					//set current row to null
					
					nameArr[i-1].setText("");
					quantityArr[i-1].setValue(1);
					quantityArr[i-1].setVisible(false);
					priceArr[i-1].setText("");
					//delete[i-1].setVisible(false);
					
					//copy next row to current row
					
					nameArr[i-1].setText(nameArr[i].getText());
					quantityArr[i-1].setValue(quantityArr[i].getValue());
					quantityArr[i-1].setVisible(true);
					priceArr[i-1].setText(priceArr[i].getText());
					//delete[i-1].setVisible(true);
					
					//make next row null
					
					nameArr[i].setText("");
					quantityArr[i].setValue(1);
					quantityArr[i].setVisible(false);
					priceArr[i].setText("");
					//delete[i].setVisible(false);
				}
			}
			else
			{
				    //set the last row to zero
				    
					nameArr[arrSize-1].setText("");
					quantityArr[arrSize-1].setValue(1);
				    quantityArr[arrSize-1].setVisible(false);
				    priceArr[arrSize-1].setText("");
				   // delete[arrSize-1].setVisible(false);
			}
			
			arrSize--;
			
			try
			{
				stmnt.executeUpdate("DELETE FROM `temp_order` WHERE `temp_order`.`Product_Name` = '"+foodName+"'");
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
}