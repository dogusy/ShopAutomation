import java.sql.*;
import java.util.*;
public class Clerk extends User{
	
	public static int ClerkId;
	public static String report;
	Connection connection=null;	

	public Clerk(int uid, String uname, String uaddress,int uphone,String uemail,String upassword,String urole,String usube,String creport) {
		super( uid,  uname,  uaddress, uphone, uemail, upassword, urole, usube);
		ClerkId=uid;
		report=creport;
	}
	
	public Clerk() {
		
		}
	
	public void saveReport() {
		connection=sqliteConnection.dbConnector();
		Random random = new Random();
		int x = random.nextInt(90) + 10;
		try {
			String query="insert into Report(ID,Report)"+"values(?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			
			pst.setInt(1,x);
			pst.setString(2, report );
			pst.execute();
			pst.close();
			
		}catch(Exception e) {
			
		}
	}
	public void sendreport() {
		connection=sqliteConnection.dbConnector();
		Random random = new Random();
		int x = random.nextInt(50) + 10;
		try {
			String query="insert into CSendReport(ID,Report)"+"values(?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			
			pst.setInt(1,x);
			pst.setString(2, report);
			pst.execute();
			pst.close();
			
		}catch(Exception e) {
			
		}
		
	}
	public String showMarketInvent() {
		connection=sqliteConnection.dbConnector();
		Clerk c= new Clerk();
		String a="";
		try {
			if(c.sube.equals("Ankara")) {
			String query="select * from InventoryAnkara";
			
			return query;
			
			}
			if(c.sube.equals("Yalova")) {
				String query="select * from InventoryYalova";
				
				return query;
				}
			
		}catch(Exception e) {
			
		}
		return a;
		
	}
	public void demandProduct(String product,int count,String place,int id) {
		connection=sqliteConnection.dbConnector();
		Clerk c= new Clerk();
		try {
			
			String insert="insert into DemandProduct(Product,Count,ID,Sube)"+"values(?,?,?,?)";
			PreparedStatement pst1=connection.prepareStatement(insert);
			pst1.setString(1, product);
			pst1.setInt(2, count);
			pst1.setString(4, place);
			pst1.setInt(3, id);
			
			
			pst1.execute();
			pst1.close();
			
			
			
		}catch(Exception a) {
			
		}
		
	}
	
	

}
