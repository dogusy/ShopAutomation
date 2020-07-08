import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Manager extends User {
	public  int ManagerId;
	public static String report;
	Connection connection=null;	

	public Manager(int uid, String uname, String uaddress,int uphone,String uemail,String upassword,String urole,String usube,String creport) {
		super( uid,  uname,  uaddress, uphone, uemail, upassword, urole, usube);
		ManagerId=uid;
		report=creport;
	}
	
	public Manager() {
		
	}
	public String viewReport(int id) {
		String query="select Report from CSendReport where ID='"+id+"'";
		return query;
	}
	public void createreport() {
		connection=sqliteConnection.dbConnector();
		Random random = new Random();
		int x = random.nextInt(50) + 10;
		try {
			String query="insert into MSendReport(ID,Report)"+"values(?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			
		
			pst.setInt(1, x);
			pst.setString(2, report);
			pst.execute();
			pst.close();
			
		}catch(Exception e) {
			
		}
		
	}
	public String ViewAllInvent() {
		Inventory ý= new Inventory();
		String query;
			return  query=ý.AllInventory();
	
	}
	public String Getcount(String place,String product)   {
		
		String query="";
		if(place.equals("Ankara"))
		query="select * from InventoryAnkara where Product='"+product+"'";
		else if(place.equals("Yalova"))
			 query="select * from InventoryYalova where Product='"+product+"'";
		
		return query;
	
	}
	public void decrease(String product,int ab) throws SQLException {
		String query="select * from Inventory where Product='"+product+"'";
		
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			int a =rs.getInt("Count");
			String query2="update Inventory  set Count="+(a-ab)+"where Product= '"+product+"'";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			
			
			rs.close();
			rs2.close();
			pst.close();
			pst2.close();
			
			
	
		
	}
}
