package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	// DBManager.getConnection();
	// ㄴ 외부 클래스에서 디비 연동이 필요할 때, Connection 을 얻어갈 수 있음
	public static Connection getConnection(String database) {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "root";	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+database, user, password);
//			System.out.println("DB 연동 성공");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("DB 연동 실패");
			return null;
		}
	}

}
