import java.sql.*;

public class Admin extends User {
	public  int AdminId;

	Connection connection=null;	

	public Admin(int uid, String uname, String uaddress,int uphone,String uemail,String upassword,String urole,String usube) {
		super( uid,  uname,  uaddress, uphone, uemail, upassword, urole, usube);
		AdminId=uid;
			}
	public Admin() {
	
}
	public void updateUser(int id) {
		connection=sqliteConnection.dbConnector();
		try {
			String query="select * from updateClerk where ID='"+id+"'";
			String query1="insert into WorkerInfo (Name,Password,ID,Address,PhoneNo,Email,Role,Sube)" + "values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			PreparedStatement pst1=connection.prepareStatement(query1);
			pst1.setString(1, rs.getString("Name"));
			pst1.setString(2, rs.getString("Password"));
			pst1.setInt(3, rs.getInt("ID"));
			pst1.setInt(5, rs.getInt("PhoneNo"));
			pst1.setString(4, rs.getString("Address"));
			pst1.setString(6, rs.getString("Email"));
			pst1.setString(7, rs.getString("Role"));
			pst1.setString(8, rs.getString("Sube"));
			pst1.execute();
			
			pst1.close();
			pst.close();
		}catch(Exception a) {
			
		}
	}
	public String getRegisterRecords() {
		String query="select * from updateClerk";
		return query;
		
	}
	public String viewfeedback(int id) {
		connection=sqliteConnection.dbConnector();
		
			String query="select Report from MSendReport where ID= '"+id+"'";
			return query;
		
	}
	public String giveFeedback() {
		
		String query="insert into AdminSendManager(ID,Report,Name)"+ "values(?,?,?)";
		return query;
	}
	public String createTable() {
		
		String query="insert into Goals(Product,GoalCount,GoalDate) values(?,?,?)";
		
		return query;
	}

}
