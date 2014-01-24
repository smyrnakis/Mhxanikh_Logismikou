import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistoryModel {

	private HistoryView theView = new HistoryView();
	private String Id = new String();
	private String[] res = new String[3];
	private String[] Info = new String[3];
	
	public HistoryModel(HistoryView theView){
		this.theView=theView;
	}
	
	public void getId(){
		Id = theView.retId();
	}
	
	public void Ask(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM history WHERE Idp = " + Id);

			
			while (rs.next()) {
				res[0] = rs.getString("Eksetash");
				res[1] = rs.getString("Apotelesma");
				res[2] = rs.getString("Date");
				theView.insert(res);
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
	
	public void Exams(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Info = theView.Exam();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/iatrikos_fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String query = "INSERT INTO history (`Id`,`Idp`,`Eksetash`,`Apotelesma`,`Date`) VALUES (NULL,'"
					+ Id
					+ "','"
					+ Info[0]
					+ "','"
					+ Info[1]
					+ "','"
					+ Info[2] + "')";

			System.out.println(query);
			stmt.executeUpdate(query);
			
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
	
}
