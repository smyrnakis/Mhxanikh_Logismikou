import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestModel {

	private String respond;
	private String name;
	private String pass;
	private int id;
	private int adia;
	
	public void getArguments(String name, String pass){
		this.name=name;
		this.pass=pass;		
	}
	
	public void Ask(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/iatrikos_fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user WHERE `Login` = '" + name + "' and `Password` = '" + pass + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				respond = "Correct";
				adia = rs.getInt("Adia");
				id = rs.getInt("Id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getId(){
		
		return id;
		
	}
	
	public String getRespond(){
		
		return respond;
		
	}	
	
	public int getAdia(){
		
		return adia;
	}
}
