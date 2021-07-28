import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

class AdminPage extends JFrame implements ActionListener
{
	JButton mf,adminProfile;
	String name,pass,address,mail,contact,gender;
	JLabel l;
	int id;
	AdminData m;
	
	public AdminPage(AdminData m)
	{
		this.m = m;
		
		setSize(820,600);
		setVisible(true);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("images\\admin.jpg")));
		
		l = new JLabel("Admin");
		l.setForeground(new Color(105, 105, 105));
		l.setFont(new Font("Britannic Bold", Font.PLAIN, 50));
		l.setBounds(350,90,200,80);
		getContentPane().add(l);
		
		mf = new JButton("Manage Food");
		mf.setBackground(new Color(250, 250, 210));
		mf.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		
		adminProfile = new JButton(m.name);
		adminProfile.setBackground(new Color(250, 250, 210));
		adminProfile.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		
		mf.setBounds(220,230,150,60);
		adminProfile.setBounds(450,230,150,60);
		
		getContentPane().add(mf);
		
		getContentPane().add(adminProfile);
		
		mf.addActionListener(this);
		adminProfile.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == mf)
		{
			ManageFood m = new ManageFood();
		}
		else
		{
			AdminInfo j = new AdminInfo(m);
		}
	}
}