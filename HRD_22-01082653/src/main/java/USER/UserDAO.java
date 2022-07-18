package USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import DBPKG.DBManager;

public class UserDAO {
	
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getinstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<UserDTO> users = new ArrayList<>();
	
	public boolean addUser(UserDTO userDto) {
		conn = DBManager.getConnection("database");
		String sql = String.format("insert into member_tbl_02(%d,%s,%s,%s,%s,%s,%s)", userDto.getCustno(), userDto.getCustname(), userDto.getPhone(), userDto.getAddress(), userDto.getJoindate(), userDto.getGrade(), userDto.getCity());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}
	
	public boolean updateUser(UserDTO userDto) {
		conn = DBManager.getConnection("database");
		String sql = String.format("update member_tbl_02 set custname='%s', phone='%s', address='%s', joindate='%s', grade='%s', city='%s' where custno=%d", userDto.getCustname(), userDto.getPhone(), userDto.getAddress(), userDto.getJoindate(), userDto.getGrade(), userDto.getCity(), userDto.getCustno());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}
	
	public ArrayList<UserDTO> getUsers(){
		conn = DBManager.getConnection("database");
		String sql = "select * from member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				Timestamp joindate = rs.getTimestamp(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				UserDTO userdto = new UserDTO(custno, custname, phone, address, joindate, grade, city);
				users.add(userdto);
			}
			return users;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	

}
