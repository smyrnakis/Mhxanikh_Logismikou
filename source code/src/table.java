import java.sql.*;

public class table {
	
	public table() {

	}

	public void create_table(){
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/iatrikos_fakelos";

		// Database credentials
		final String USER = "root";
		final String PASS = "GogasG";
		
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = null;
			
			sql = "CREATE TABLE user "
					+ "(Id INTEGER not NULL AUTO_INCREMENT, " + " Onoma VARCHAR(50), "
					+ " Eponumo VARCHAR(50), " + " Adia INTEGER, "
					+ " Login VARCHAR(50), " + " Password VARCHAR(50), "
					+ " PRIMARY KEY ( Id ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			
			sql = "CREATE TABLE patience "
					+ "(Id INTEGER not NULL AUTO_INCREMENT, " + " Onoma VARCHAR(50), "
					+ " Eponumo VARCHAR(50), " + " Blood VARCHAR(50), "
					+ " Piesh INTEGER, " + " Temp INTEGER, "
					+ " AFM VARCHAR(50), " + " Tel VARCHAR(50), "
					+ " PRIMARY KEY ( Id ))";

			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE history "
					+ "(Id INTEGER not NULL AUTO_INCREMENT, " + " Idp INTEGER not NULL, "
					+ " Eksetash VARCHAR(100), " + " Apotelesma Text, "
					+ " Date Text, " + " PRIMARY KEY ( Id ))";

			stmt.executeUpdate(sql);
			
			System.out.println("Created table in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}// end main
}
