import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Contact extends MainPage

{
	
	JLabel l = new JLabel("Xi'an, China ");
	JLabel l1 = new JLabel("Dongda Market First Floor");
	JLabel l2 = new JLabel("Contact Number=+8600000000000");
	JLabel l3 = new JLabel("Monday to Friday 8:00 am – 11:30 pm");
	JLabel l4 = new JLabel("Saturday and Sunday	10:00am– 10:00 pm");
	JLabel l5 = new JLabel("We appreciate your Feedback!");
	JLabel l6 = new JLabel("Email");
	JTextField f = new JTextField();
	JLabel l7 = new JLabel("Feedback");
	JTextField f1 = new JTextField();
	JButton b = new JButton();
	
	
	
	public Contact()
	{
		
		l.setBounds(40,144,600,30);
		l.setFont(new Font("Algerian",32,32));
		l.setForeground (Color.black);
		add(l);
		
		l1.setBounds(40,175,600,30);
		l1.setFont(new Font("Algerian",32,32));
		l1.setForeground (Color.black);
		add(l1);
		
		l2.setBounds(40,205,600,30);
		l2.setFont(new Font("Algerian",32,32));
		l2.setForeground (Color.black);
		add(l2);
		
		l3.setBounds(40,235,600,30);
		l3.setFont(new Font("Algerian",32,32));
		l3.setForeground (Color.black);
		add(l3);
		
		l4.setBounds(40,265,600,30);
		l4.setFont(new Font("Algerian",25,25));
		l4.setForeground (Color.black);
		add(l4);
		
		l5.setBounds(825,150,600,30);
		l5.setFont(new Font("Broadway",26,26));
		l5.setForeground (Color.black);
		add(l5);
		
		
		l6.setBounds(920,200,100,30);
		l6.setFont(new Font("Times New Roman",25,25));
		l6.setForeground (Color.black);
		add(l6);
		
		f.setBounds(1020,200,250,30);
		f.setForeground (Color.black);
		add(f);
		
		l7.setBounds(920,300,100,30);
		l7.setFont(new Font("Times New Roman",25,25));
		l7.setForeground (Color.black);
		add(l7);
		
		f1.setBounds(1020,300,250,120);
		f1.setForeground (Color.black);
		add(f1);
		
		add(b);
		b.setBounds(1020,420,150,30);
		b.setIcon(new ImageIcon("images\\submit.png"));
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
				AdminLogin B = new AdminLogin();
			}
			else
			{
				//Login n = new Login();
				
			}
	}
}