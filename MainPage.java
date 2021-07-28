import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JPanel;

class MainPage extends JFrame implements ActionListener
{
JButton b1= new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JButton b5 = new JButton();


public MainPage()
{
		
		setVisible(true);
		
		setLayout(null);
		
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
        setContentPane(new JLabel(new ImageIcon("images\\back.jpg")));
        
        
		
		add(b1);
		b1.setBounds(40,40,180,53);
		b1.setIcon(new ImageIcon("images\\home.png"));
		
		
	
		
		add(b3);
		b3.setBounds(260,40,550,60);
		b3.setIcon(new ImageIcon("images\\delivery.png"));
		
		
		add(b4);
		b4.setBounds(850,40,390,55);
		b4.setIcon(new ImageIcon("images\\contact.png"));
		
		add(b5);
		b5.setBounds(1040,605,200,60);
		b5.setIcon(new ImageIcon("images\\admin.png"));
		
	
		
		 setSize(1500,1000);
		b1.addActionListener(this);
	
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	
		
       
		
		}
public void actionPerformed(ActionEvent a)
	{
		   if(a.getSource() == b1)
			{
				this.setVisible(false);
				MainPage h = new MainPage();
			}
		   
		   else if(a.getSource() == b3)
			{
				Delivery s = new Delivery();
			}
			else if(a.getSource() == b4)
			{
				this.setVisible(false);
				Contact c = new Contact();
				
			}
			else if(a.getSource() == b5)
			{
				AdminLogin A = new AdminLogin();
			}
			
	}


	

}
