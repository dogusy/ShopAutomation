import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGui {

	private JFrame frame;
	private JTextField Fname;
	private JPasswordField Fpass;
public int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui window = new UserGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	public UserGui() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

public void load() throws SQLException {
	connection=sqliteConnection.dbConnector();

	String query="select * from WorkerInfo where ID=? and Password=? ";
	PreparedStatement pst= connection.prepareStatement(query);
	pst.setString(1, Fname.getText());
	pst.setString(2, Fpass.getText());
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//login button check id and password also controls its role
		JButton Blogin = new JButton("Login");
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
						String query="select * from WorkerInfo where Name=? and Password=? ";
					
					
						
					
						
						PreparedStatement pst= connection.prepareStatement(query);
						pst.setString(1, Fname.getText());
						pst.setString(2, Fpass.getText());
						ResultSet rs= pst.executeQuery();
						
						
						//for che0cking users role
						String a=rs.getString("Role");
						 User u=new User();
						   u.password=rs.getString("Password");
						   u.id=rs.getInt("ID");
						   u.name=rs.getString("Name");
						  
						   u.address=rs.getString("Address");
						   u.phone=rs.getInt("PhoneNo");
						   u.email=rs.getString("Email");
						   u.role=rs.getString("Role");
						   u.sube=rs.getString("Sube");
						String admin="Admin";
						String clerk="Clerk";
						String manager="Manager";
						
					  Clerk cl=new Clerk();
						int count=0;
						   while(rs.next()) {
							   count=count+1;
							 
							   
						   }if(count==1  ) {
							 
							   JOptionPane.showMessageDialog(null,"Name and password correct");
							   if(a.equals(clerk)) {
								  
								   
								   frame.dispose();
								   ClerkPanel cp=new ClerkPanel();
								   cp.setVisible(true);
								   System.out.println(u.getSube());
								   
							   }else if(a.equals(admin)) {
								   UserGui id= new UserGui();
								  
								   frame.dispose();
								   AdminPanel ap=new AdminPanel();
								   ap.setVisible(true);
								   rs.close();
								   pst.close();
							   }else if(a.equals(manager)) {
								   UserGui id= new UserGui();
								  
								   frame.setVisible(true);
								   ManagerPanel mp= new ManagerPanel();
								   mp.setVisible(true);
								   
								   
							   }
						
							   }
							 else if (count>1) {
							   JOptionPane.showMessageDialog(null,"Duplicate Name and password");
							  
						   }
							 else {
							   JOptionPane.showMessageDialog(null,"Name and password not correct");
							   
						   }
						   rs.close();
						   pst.close();
						  
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		Blogin.setBounds(306, 281, 89, 23);
		frame.getContentPane().add(Blogin);
		
		JButton Bregister = new JButton("Register");
		Bregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Register a = new Register();
					a.setVisible(true);
				}catch(Exception e) {
					
				}
			}
		});
		Bregister.setBounds(306, 334, 89, 23);
		frame.getContentPane().add(Bregister);
		
		Fname = new JTextField();
		Fname.setBounds(277, 114, 162, 41);
		frame.getContentPane().add(Fname);
		Fname.setColumns(10);
		
		Fpass = new JPasswordField();
		Fpass.setBounds(277, 195, 162, 41);
		frame.getContentPane().add(Fpass);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(126, 114, 89, 27);
		frame.getContentPane().add(lblName);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(126, 208, 46, 14);
		frame.getContentPane().add(lblPass);
	}
}
