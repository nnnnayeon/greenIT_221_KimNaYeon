package exWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserDAO {
	// Data Access Object
	// private ArrayList<UserDTO> list=null;
	
	// 싱글톤 패턴으로 UserDAO 작성
	private UserDAO() {
//		list=new ArrayList<UserDTO>();		
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	private String log;

	private String url = "jdbc:mysql://localhost:3306/firstJsp";

	private String user = "root";
	private String password = "root";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	// 회원추가
	public boolean addUser(UserDTO userDto) {
		conn = getConnection();
		
		String id = userDto.getId();
		String pw = userDto.getPassword();
		String name = userDto.getName();
		Date date = new Date(userDto.getYear()-1900,userDto.getMonth()-1,userDto.getDay());
		Timestamp birthdate = new Timestamp(date.getTime());
		String gender = userDto.getGender();
		String email = userDto.getEmail();
		String country = userDto.getCountry();
		String mobile = userDto.getMobile();
		
		String sql =String.format("insert into users values('%s','%s','%s','%s','%s','%s','%s','%s');",id,pw,name,birthdate.toString(),gender,email,country,mobile);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	// 회원탈퇴
	public boolean removeUser(String id, String pw) {
		conn = getConnection();
		
		String str = "delete from users where pw = '"+ pw +"'";
		try {
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, str);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	*/
	
	// 로그인
	public boolean loginUser(String id, String pw) {
		getConnection();
		String str = "select name from users where id = '"+id+"' and password = '"+pw+"'";
		try {
			
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				log = rs.getString(1);
				pstmt.close();
				rs.close();
				return true;
			}
			else {
				pstmt.close();
				rs.close();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	public int addUser(UserDTO userDto) {
		
		conn = DBmanager.getConnection(database);
		
		System.out.println("conn: "+conn);
		
		String SQL = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
		
		Date date = new Date(userDto.getYear()-1900, userDto.getMonth(), userDto.getDay());
		Timestamp birthdate = new Timestamp(date.getTime());
		
		try {
			
			System.out.println(userDto.getName());
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birthdate);
			pstmt.setInt(5, userDto.getGender() == "woman" ? 1 : 0 );
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getMobile());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	*/
	
	/*
	public boolean loginCheck(UserDTO userDto) {
		String sql = String.format("select count(*) from users where id = '%s' and `password`='%s';",userDto.getId(),userDto.getPassword());
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1)>0) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	*/
	
	/*
	public boolean checkDupl(String id) {
		String sql = String.format("select count(*) from users where id = '%s';",id);
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1)>0) {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	*/
	
	/*
	// 회원 추가
	public int addUser(UserDTO userDto) {
		// 중복 아이디 확인 후, list 에 추가
		if(checkDupl(userDto.getId())) {
			this.list.add(userDto);
			return this.list.size() -1;
		}
		return -1;
	}
	
	// 중복 아이디 확인
	public boolean checkDupl(String id) {
		for(UserDTO user : this.list) {
			if(user.getId().equals(id))
				return false;
		}
		return true;
	}
	
	public boolean loginCheck(UserDTO userDto) {
		for(UserDTO user : this.list) {
			if(user.getId().equals(userDto.getId()) && user.getPassword().equals(userDto.getPassword())) {
				return true;
			}
		}
		return false;
	}
	*/

}
