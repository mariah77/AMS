import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OracleDBHandler extends DBHandler {

	protected static int i;
	public OracleDBHandler() {
	i = 0;	
	}
	@Override
	public void addcustomer(String n, String a, String p) {
		// TODO Auto-generated method stub
		i++;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Succesfully");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
			System.out.println("Connection Established");
			
			
			String sql = "INSERT INTO account_holder (id,name,address,phone) VALUES (?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, i);
			prep.setString(2, n);
			prep.setString(3, a);
			prep.setString(4, p);
			int rowsInserted = prep.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Account Holder succesfully inserted");
			}
		 
		con.close();
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver Not Loaded");
		
	}
	catch(SQLException e) {
		System.out.println("Connection not established");
		e.printStackTrace();
	}

		
	}

	@Override
	public void addsavingsaccount(int id, String n, double ir, double z) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Succesfully");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
			System.out.println("Connection Established");
			
			
			String sql = "INSERT INTO savings_account(id,name,interest_rate,zakat) VALUES (?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, id);
			prep.setString(2, n);
			prep.setDouble(3, ir);
			prep.setDouble(4, z);
			int rowsInserted = prep.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Savings Account succesfully inserted");
			}
		 
		con.close();
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver Not Loaded");
		
	}
	catch(SQLException e) {
		System.out.println("Connection not established");
		e.printStackTrace();
	}

		
	}

	@Override
	public void addcheckingaccount(int id, String n, int tf, int ta) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Succesfully");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
			System.out.println("Connection Established");
			
			
			String sql = "INSERT INTO checking_account(id,name,transaction_fee,total_tax) VALUES (?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, id);
			prep.setString(2, n);
			prep.setInt(3, tf);
			prep.setInt(4, ta);
			int rowsInserted = prep.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Checking Account succesfully inserted");
			}
		 
		con.close();
	}
	catch(ClassNotFoundException e) {
		System.out.println("Driver Not Loaded");
		
	}
	catch(SQLException e) {
		System.out.println("Connection not established");
		e.printStackTrace();
	}

		
	}

}
