package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Cam_Do_Database;integratedSecurity=true;");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}
	
	public static void close(Connection con) {
		try{
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
