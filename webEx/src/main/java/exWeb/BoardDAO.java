package exWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	Random ran = new Random();
	private ArrayList<BoardDTO> board = new ArrayList<>();
	
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
	
	public ArrayList<BoardDTO> getBoardDto() {
		conn = DBManager.getConnection("firstJsp");
		String sql = "select * from board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int no, code;
			String title, contents;
			int viewCnt, likeCnt;
			String createAt, modifiedAt;
			
			while(rs.next()) {
				no = rs.getInt(1);
				code = rs.getInt(2);
				title = rs.getString(3);
				contents = rs.getString(4);
				viewCnt = rs.getInt(5);
				likeCnt = rs.getInt(6);
				createAt = rs.getString(7);
				modifiedAt = rs.getString(8);
				
				BoardDTO boardDto = new BoardDTO(no,code,title,contents,viewCnt,likeCnt,createAt,modifiedAt);
				board.add(boardDto);
			}
			
			return board;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	
	public int addBoard(BoardDTO boardDto) {
		conn = DBManager.getConnection("firstJsp");
		
		String sql = "insert into board values(?,?,?,?,?,?,?,?)";
		board.add(boardDto);
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardDto.getNo());
			pstmt.setInt(2, boardDto.getCode());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getViewCnt());
			pstmt.setInt(6, boardDto.getLikeCnt());
			
			Timestamp createAt = new Timestamp(System.currentTimeMillis());
			
			pstmt.setTimestamp(7, createAt);
			pstmt.setTimestamp(8, createAt);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
		
	}
	
	
	public int getArrayListSize() {
		int cnt = 0;
		
		cnt = board.size();
		return  cnt;
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
		ran = new Random();
		conn = DBManager.getConnection("firstjsp");
		
		int num = -1;
		
		while(true) {
			int code = ran.nextInt(8999)+ 1000;
				
			try {
				String sql = String.format("select count(*) from board where code = %d", code);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					num = rs.getInt(1);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(num == 0) {
				return code;
			}
		}
		
	}
	
	public int getCodes() {
		int code = ran.nextInt(8999)+1000;
		conn = DBManager.getConnection("firstjsp");
		String sql = "select * from board where code = ? ";
		 
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, code);
				
				rs = pstmt.executeQuery();
				
				while(true) {
					 code = ran.nextInt(8999)+1000;
					
					if(!rs.next()) {
						return code;
					}
				
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return -1;
	
	}
	
//
//			try {
//				String sql = "select * from board";
//				while (true) {
//					
//					int code = ran.nextInt(8999) + 1000;
//
//				if (rs.getInt(2) != code) {
//					return code;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					conn.close();
//					pstmt.close();
//					rs.close();
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//			}
//		}


}
