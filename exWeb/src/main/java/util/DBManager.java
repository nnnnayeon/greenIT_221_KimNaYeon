package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost";
		String user = "c##myid";
		String password = "mypw";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			if(conn != null)
				System.out.println("DB연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연동 실패");
		}
		
		return conn;
	}
	
}
