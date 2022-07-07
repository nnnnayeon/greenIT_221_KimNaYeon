package exWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Random;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
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
	
	public boolean addBoard(BoardDTO boardDto) {
		conn = DBManager.getConnection("firstJsp");
		
		String sql = "insert into board values(?,?,?,?,?,?,?,?)";
		
		Date date = new Date(boardDto.getYear()-1900,boardDto.getMonth()-1,boardDto.getDay());
		Timestamp createdAt = new Timestamp(date.getTime());
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sql);
			pstmt.setString(2, sql);
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setString(5, null);
			pstmt.setString(6, null);
			pstmt.setString(7, sql);
			pstmt.setString(8, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		int no = boardDto.getNo();
//		
//		int code = boardDto.getCode();
//		
//		String title = boardDto.getTitle();
//		String contects = boardDto.getContents();
//		
//		int viewCnt = boardDto.getViewCnt();
//		int likeCnt = boardDto.getLikeCnt();
//		
//		String sql = String.format("insert into board values()");
		
	}
	
	public int getSize() {
		String sql = "select count(*) from board";
		conn = DBManager.getConnection("firstJsp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			int size = rs.getInt(1);
			
			return size;
			
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
		return -1;
	}
	
	public int getCode() {
		Random ran = new Random();
		while(true) {
			int code = ran.nextInt(8999)+1000;
			conn = DBManager.getConnection("firstjsp");
			String sql = "select * from board";
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.getInt(2) != code) {
					return code;			
				}
			}
			catch(Exception e) {
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
		}
	}
	

}
