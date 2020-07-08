import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class User {
	

	public  int id;
	public static String name;
	public static String address;
	public static int phone;
	public static String email;
	public static String password;
	public static String role;
	public static String sube;
	Connection connection=null;	
	
	public User(int uid, String uname, String uaddress,int uphone,String uemail,String upassword,String urole,String usube) {
		
		id=uid;
		name=uname;
		address=uaddress;
		phone=uphone;
		email=uemail;
		password=upassword;
		
	}
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSube() {
		return sube;
	}
	public void setSube(String sube) {
		this.sube = sube;
	}
	public void register() {
		connection=sqliteConnection.dbConnector();
		Random random = new Random();
		int x = random.nextInt(90) + 10;
		try {
			String query="insert into updateClerk (Name,Password,ID,Address,PhoneNo,Email,Role,Sube)" + "values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			String query1="select ID from WorkerInfo";
			
			PreparedStatement pst1= connection.prepareStatement(query1);
			
			ResultSet rs1= pst1.executeQuery();
			String query2="select Name from WorkerInfo";
			
			PreparedStatement pst2= connection.prepareStatement(query2);
			
			ResultSet rs2= pst2.executeQuery();
			int count=0;
		 	while(rs1.next()) {
		 		  count=count+1;
			if(count==1)
				x = random.nextInt(90) + 10;
				
			
			}
		 	count=0;
		 	while(rs2.next()) {
		 		  count=count+1;
			if(count==1)
				JOptionPane.showMessageDialog(null,"Please enter different name");
			
				
			
			}
	
		 	
		 	rs2.close();
		 	pst2.close();
			rs1.close();
			pst1.close();
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setInt(3, x);
			pst.setInt(5, phone);
			pst.setString(4, address);
			pst.setString(6, email);
			pst.setString(7, role);
			pst.setString(8, sube);
			if(name.isEmpty())
				JOptionPane.showMessageDialog(null,"Please enter name.");
			else if(password.isEmpty())
				JOptionPane.showMessageDialog(null,"Please enter password.");
			else if(Integer.toString(phone).isEmpty())
				JOptionPane.showMessageDialog(null,"Please enter phone.");
			else if(address.isEmpty())
				JOptionPane.showMessageDialog(null,"Please enter address.");
			else if(role.isEmpty())
				JOptionPane.showMessageDialog(null,"Please select role.");
			else if(sube.isEmpty())
				JOptionPane.showMessageDialog(null,"Please select market.");
			
			
			pst.execute();
			
			pst.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UserInfo() {
	User u=new User();
	UserGui ug= new UserGui();
	connection=sqliteConnection.dbConnector();
	try {
		System.out.println(ug.id);
		String query="select * from WorkerInfo where=?";
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs =pst.executeQuery();
		while(rs.next()) {
			if(ug.id==rs.getInt("ID")) {
	 u.password=rs.getString("Password");
	   u.id=rs.getInt("ID");
	   u.name=rs.getString("Name");
	   u.address=rs.getString("Address");
	   u.phone=rs.getInt("PhoneNo");
	   u.email=rs.getString("Email");
	   u.role=rs.getString("Role");
		
			}}
	   }catch(Exception e) {
		   
	   }
	}


	}
