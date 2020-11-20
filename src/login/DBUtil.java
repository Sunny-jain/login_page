package login;

import java.sql.*;

public class DBUtil {
	 static Connection con = null;
	 
	 static { 
	  try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sj","system");
	   
	  } catch (ClassNotFoundException | SQLException e) {
	   e.printStackTrace();
	  }
	 }
	 
	 public static Connection getDBConnection() { 
	  return con;
	 }
}