
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

class AdminLogin extends JFrame implements ActionListener 
{
	JButton b = new JButton("Admin Login");
	JLabel l = new JLabel("Admin Username");
	JLabel l1 = new JLabel("Admin Password");
	JTextField f = new JTextField();
	JTextField f1 = new JTextField();
	
	public AdminLogin()
	{	
		setSize(590,570);
		setVisible(true);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("images\\admn.jpg")));
		b.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b.setBounds(400,350,120,40);
		getContentPane().add(b);
		
		l.setForeground(new Color(0, 0, 128));
		l.setFont(new Font("Arial Black", Font.PLAIN, 13));
		l.setBounds(90,135,130,20);
		getContentPane().add(l);
		
		l1.setForeground(new Color(0, 0, 128));
		l1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		l1.setBounds(90,240,130,20);
		getContentPane().add(l1);
		
		f.setBounds(240,135,220,25);
		getContentPane().add(f);
		
		f1.setBounds(240,240,220,25);
		getContentPane().add(f1);
		
		b.addActionListener(this);
	}
	
	String adminName,adminPassword;
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == b)
		{
			adminName = f.getText();
		    adminPassword = f1.getText();
			    
				if(!adminName.equals("") && !adminPassword.equals(""))
			    {
					AdminData s = new AdminData(this);
			    }
				else
			    {
				    JOptionPane.showMessageDialog(null,"Please Fill up required Fields for Login !!!");
			    }
		}
	}
}