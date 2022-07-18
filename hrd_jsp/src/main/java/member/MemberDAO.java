package member;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDAO {
	
		
	static Connection conn = null;

	static public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
																			// SID 확인방법!
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");	
		return conn;
	}
}


