<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="01_header.jsp" %>
	<%	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<String[]> memberList = new ArrayList<String[]>();
	try {
		conn = MemberDAO.getConnection();
	//	String sql = "SELECT custno, custname, phone, address, TO_CHAR( joindate, 'YYYY\"년\"MM\"월\"DD\"일\"'), grade, city FROM member_tbl_02"; 
		
		String sql = "SELECT * FROM  member_tbl_02";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String[] member = new String[7];
			
			// 7개
			member[0] = rs.getInt("custno") + "";
			member[1] = rs.getString("custname");
			member[2] = rs.getString("phone");
			member[3] = rs.getString("address");
						
			String joindate =  rs.getString("joindate");
			String year = joindate.substring(0, 4);
			String month = joindate.substring(5, 7);
			String day = joindate.substring(8, 10);
			joindate = year + "년 " + month + "월 " + day + "일";
			member[4] = joindate;
			String grade = rs.getString("grade");
			String gradeCode[] = {"A" , "B" ,"C"};
			String gradeList[] = {"VIP" , "일반" , "직원"};
			for(int i = 0; i < gradeCode.length; i++){
				if(grade.equals(gradeCode[i])){
					grade = gradeList[i];
				}
			}			
			member[5] = grade;
						
			String city = rs.getString("city");
			String [] cityCode = {"01" ,  "10" ,  "20" , "30" , "40" , "60"};
			String [] cityList = {"서울" , "인천" , "성남" , "대전" , "광주" , "부산"};		
			for(int i = 0; i < cityCode.length; i++){
				if(cityCode[i].equals(city)){
					city = cityList[i];
					break;
				}
			}	
			member[6]= city;
			memberList.add(member);
			
		}
		
		conn.close();
		ps.close();
		rs.close();
		
	}catch(Exception e) {}
	
	%>
	<div align="center">
		<h2>회원목록 조회/수정</h2>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>통신사</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
		<%	
			for(int i=0; i<memberList.size(); i++){
				String[] member = memberList.get(i);
			
		%>
			<tr>
				<td><a href="07_update.jsp?custno=<%= member[0] %>"><%= member[0] %></a></td>
				<td><%= member[1] %></td>
				<td><%= member[2] %></td>
				<td><%= member[3] %></td>
				<td><%= member[4] %></td>
				<td><%= member[5] %></td>
				<td><%= member[6] %></td>
			</tr>
		<%	
			}
		%>			
		</table>
	</div>
	
	<br /><br /><br /><br />

<%@include file="02_footer.jsp" %>