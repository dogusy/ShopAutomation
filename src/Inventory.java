import java.sql.*;

public class Inventory {
  
	public Inventory() {
		
	}
	
	public String AllInventory() {
		String query="select * from Inventory";
		return query;
	}
	
}
