import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditModel {

	private EditView theView = new EditView();
	private String ID = null;
	private String[] result;
	private String[] inp = new String[7];

	public EditModel(EditView theView) {
		this.theView = theView;
	}

	public void Inp() {
		ID = theView.GetSearch();
	}

	public void Ask() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		result = new String[8];
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/iatrikos_fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM patience WHERE Id = " + ID);
			while (rs.next()) {
				result[0] = rs.getString("Id");
				result[1] = rs.getString("Onoma");
				result[2] = rs.getString("Eponumo");
				result[3] = rs.getString("Blood");
				result[4] = rs.getString("Piesh");
				result[5] = rs.getString("Temp");
				result[6] = rs.getString("AFM");
				result[7] = rs.getString("Tel");
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

	public void Result() {
		theView.SetResult(result);
	}

	public void Edit() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		result = new String[8];
		try {
			inp = theView.GetResult();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			String query = null;
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();

			query = "UPDATE patience SET `Id` = '" + ID + "' ,`Onoma` = '" + inp[0]
					+ "' ,`Eponumo` = '" + inp[1] + "' ,`Blood` = '" + inp[2]
					+ "' ,`Piesh` = '" + inp[3] + "' ,`Temp` = '" + inp[4]
					+ "' ,`AFM` = '" + inp[5] + "' ,`Tel` = '" + inp[6]
					+ "' WHERE `Id` = '" + ID + "'";
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
