import java.sql.*;

public class Initialize {
	public Initialize(){
		
	}
	
	public void Insert(){
		 // JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/iatrikos_fakelos";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "GogasG";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      String sql = "INSERT INTO user " +
	                   "VALUES (null, 'Root', 'Root',  0, 'Root', 'Root')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO user " +
		                   "VALUES (null, 'TestOn1', 'TestEp1',  1, 'Test1', '123456')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO user " +
	                   "VALUES (null, 'TestOn2', 'TestEp2',  2, 'Test2', '123456')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO user " +
	                   "VALUES (null, 'TestOn3', 'TestEp3',  3, 'Test3', '123456')";
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO patience " +
	                   "VALUES (null, 'George', 'Gogas',  '0+', '9', '37', '123597486', '26610')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO patience " +
	                   "VALUES (null, 'Apostolhs', 'Smyrnakis',  '0+', '9', '37', '123597486', '26610')";
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO history " +
	                   "VALUES (null, 1, 'Aimatos',  'Ola kala', '12/5/14')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO history " +
	                   "VALUES (null, 1, 'Splhnas',  'Oriaka kala', '12/5/14')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO history " +
	                   "VALUES (null, 2, 'Aktinografia',  'Katagma gofou', '13/5/14')";
		      stmt.executeUpdate(sql);

		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Initialization completed!");
		   
	}
}
