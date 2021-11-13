import java.sql.*;
public class MYSQLHandler extends DBHandler{
	protected static int i;
	public MYSQLHandler() {
	i = 0;	
	}

	public void addcustomer(String n,String a,String p) {
		i++;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
			//Statement stmt=con.createStatement();
			String mysql = "insert into account_holder (id,name,address,phone_number) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(mysql);
			st.setInt(1,i );
			st.setString(2, n);
			st.setString(3, a);
			st.setString(4, p);
			int rowsInserted = st.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Account holder succesfully inserted");
			}
			else {
				System.out.println("Insertion failed");
			}
			con.close();
			}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void addsavingsaccount(int id, String n, double ir, double z) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
			//Statement stmt=con.createStatement();
			String mysql = "insert into savings_account (id,name,interest_rate,zakat) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(mysql);
			st.setInt(1,id );
			st.setString(2, n);
			st.setDouble(3, ir);
			st.setDouble(4, z);
			int rowsInserted = st.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Savings Account succesfully inserted");
			}
			else {
				System.out.println("Insertion failed");
			}
			con.close();
			}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void addcheckingaccount(int i, String n, int tf, int ta) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger");
			//Statement stmt=con.createStatement();
			String mysql = "insert into checking_account (name,id,transaction_fee,total_tax) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(mysql);
			st.setString(1,n );
			st.setInt(2, i);
			st.setInt(3, tf);
			st.setInt(4, ta);
			int rowsInserted = st.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Checkings Account succesfully inserted");
			}
			else {
				System.out.println("Insertion failed");
			}
			con.close();
			}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
