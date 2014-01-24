import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddModel {

	private AddView theView;
	private String[] Info = new String[7];

	public AddModel(AddView theView) {
		this.theView = theView;
	}

	public void info() {
		Info = theView.sendInf();
		System.out.println(Info[0] + " " + Info[1] + " " + Info[2] + " "
				+ Info[3] + " " + Info[4] + " " + Info[5] + " " + Info[6]);
		theView.res();
	}

	public void insert() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "INSERT INTO patience (`Id`,`Onoma`,`Eponumo`,`Blood`,`Piesh`,`Temp`,`AFM`,`Tel`) VALUES (NULL,'"
				+ Info[0]
				+ "','"
				+ Info[1]
				+ "','"
				+ Info[2]
				+ "','"
				+ Info[3]
				+ "','"
				+ Info[4]
				+ "','"
				+ Info[5]
				+ "','"
				+ Info[6] + "')";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/iatrikos_fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
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
