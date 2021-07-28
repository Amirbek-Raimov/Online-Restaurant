
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

class AdminInfo extends JFrame implements ActionListener
{
	JLabel Id,Name,Pass,Address,Mail,Contact,Gender,top;
	JLabel id,name,pass,address,mail,contact,gender;
	JButton cName,cPass,cAddress,cMail,cContact;
	AdminData a;
	
	public AdminInfo(AdminData a)
	{
		this.a = a;
		
		setSize(680,500);
		setVisible(true);
		getContentPane().setLayout(null);
		
	    JLabel label = new JLabel(new ImageIcon("images\\adminpanel.jpg"));
	    setContentPane(label);
		
	    /*** label ***/
	    top = new JLabel("- Admin -");
		top.setForeground(new Color(85, 107, 47));
		top.setFont(new Font("Cambria", Font.BOLD, 23));
		top.setBounds(70,30,100,60);
		getContentPane().add(top);
	    
		Id = new JLabel("Id :");
		Id.setForeground(new Color(139, 69, 19));
		Id.setFont(new Font("Century", Font.ITALIC, 13));
		Id.setBounds(60,100,50,30);
		getContentPane().add(Id);

		Name = new JLabel("Name :");
		Name.setForeground(new Color(139, 69, 19));
		Name.setFont(new Font("Century", Font.ITALIC, 13));
		Name.setBounds(60,150,50,30);
		getContentPane().add(Name);
		
		Pass = new JLabel("Password :");
		Pass.setForeground(new Color(139, 69, 19));
		Pass.setFont(new Font("Century", Font.ITALIC, 13));
		Pass.setBounds(60,200,80,30);
		getContentPane().add(Pass);
		
		Contact = new JLabel("Contact no. :");
		Contact.setForeground(new Color(139, 69, 19));
		Contact.setFont(new Font("Century", Font.ITALIC, 13));
		Contact.setBounds(60,250,80,30);
		getContentPane().add(Contact);
		
		Mail = new JLabel("Email :");
		Mail.setForeground(new Color(139, 69, 19));
		Mail.setFont(new Font("Century", Font.ITALIC, 13));
		Mail.setBounds(60,300,50,30);
		getContentPane().add(Mail);
		
		Address = new JLabel("Address :");
		Address.setForeground(new Color(139, 69, 19));
		Address.setFont(new Font("Century", Font.ITALIC, 13));
		Address.setBounds(60,353,100,30);
		getContentPane().add(Address);
		
		Gender = new JLabel("Gender :");
		Gender.setForeground(new Color(139, 69, 19));
		Gender.setFont(new Font("Century", Font.ITALIC, 13));
		Gender.setBounds(60,400,50,30);
		getContentPane().add(Gender);
		
		id = new JLabel(Integer.toString(a.id));
		id.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		id.setBounds(150,100,50,30);
		getContentPane().add(id);
		
		name = new JLabel(a.name);
		name.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		name.setBounds(150,150,100,30);
		getContentPane().add(name);
		
		pass = new JLabel(a.pass);
		pass.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		pass.setBounds(150,200,100,30);
		getContentPane().add(pass);
		
		contact = new JLabel(a.contact);
		contact.setBackground(new Color(250, 240, 230));
		contact.setForeground(new Color(0, 0, 0));
		contact.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		contact.setBounds(150,250,500,30);
		getContentPane().add(contact);
		
		mail = new JLabel(a.mail);
		mail.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		mail.setBounds(150,300,200,30);
		getContentPane().add(mail);
		
		address = new JLabel(a.address);
		address.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		address.setBounds(150,353,500,30);
		getContentPane().add(address);
		
		if((a.gender).equals("M"))
		{
			gender = new JLabel("Male");
		}
		else
		{
			gender = new JLabel("Female");
		}
		gender.setBounds(150,400,100,30);
		gender.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		getContentPane().add(gender);

		
		 /*** button ***/
		cName = new JButton("Change Name");
		cName.setBackground(new Color(244, 164, 96));
		cName.setFont(new Font("Arial", Font.BOLD, 11));
		cName.setBounds(400,150,150,22);
		getContentPane().add(cName);
		cName.addActionListener(this);
		
		cPass = new JButton("Change Password");
		cPass.setBackground(new Color(244, 164, 96));
		cPass.setFont(new Font("Arial", Font.BOLD, 11));
		cPass.setBounds(400,200,150,22);
		getContentPane().add(cPass);
		cPass.addActionListener(this);
		
		cContact = new JButton("Change ContactNo.");
		cContact.setBackground(new Color(244, 164, 96));
		cContact.setFont(new Font("Arial", Font.BOLD, 11));
		cContact.setBounds(400,250,150,22);
		getContentPane().add(cContact);
		cContact.addActionListener(this);
		
		cMail = new JButton("Change Email");
		cMail.setBackground(new Color(244, 164, 96));
		cMail.setFont(new Font("Arial", Font.BOLD, 11));
		cMail.setBounds(400,300,150,22);
		getContentPane().add(cMail);
		cMail.addActionListener(this);
		
		cAddress = new JButton("Change Address");
		cAddress.setForeground(new Color(0, 0, 0));
		cAddress.setBackground(new Color(244, 164, 96));
		cAddress.setFont(new Font("Arial", Font.BOLD, 11));
		cAddress.setBounds(400,355,150,22);
		getContentPane().add(cAddress);
		cAddress.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == cName)
		{
			String input = JOptionPane.showInputDialog("New Name");
			
			if(input.length() > 0)
			{
				AdminData n = new AdminData("UPDATE `admin` SET `Name` = '"+input+"' WHERE `admin`.`ID_No` = '"+a.id+"'");
			}
		}
		else if(e.getSource() == cPass)
		{
			String input = JOptionPane.showInputDialog("New Password");
			
			if(input.length() > 0)
			{
				AdminData n = new AdminData("UPDATE `admin` SET `Password` = '"+input+"' WHERE `admin`.`ID_No` = '"+a.id+"'");
			}
		}
		else if(e.getSource() == cContact)
		{
			String input = JOptionPane.showInputDialog("New ContactNo");
			
			if(input.length() > 0)
			{
				AdminData n = new AdminData("UPDATE `admin` SET `Contact_No` = '"+input+"' WHERE `admin`.`ID_No` = '"+a.id+"'");
			}
		}
		
		else if(e.getSource() == cMail)
		{
			String input = JOptionPane.showInputDialog("New Email");
			
			if(input.length() > 0)
			{
				AdminData n = new AdminData("UPDATE `admin` SET `Email` = '"+input+"' WHERE `admin`.`ID_No` = '"+a.id+"'");
			}
		}
		
		else if(e.getSource() == cAddress)
		{
			String input = JOptionPane.showInputDialog("New Address");
			
			if(input.length() > 0)
			{
				AdminData n = new AdminData("UPDATE `admin` SET `Address` = '"+input+"' WHERE `admin`.`ID_No` = '"+a.id+"'");	
			}
		}
	}
}