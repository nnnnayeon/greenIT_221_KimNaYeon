<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.MemberDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="01_header.jsp" %>

	<%	
	    
	
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int max = 0;
		try {		
			conn =  MemberDAO.getConnection();
			application.log("conn " + conn);
			String sql = "SELECT MAX(custno) FROM member_tbl_02";		
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			application.log("rs " + rs);
			if(rs.next()){
				max = rs.getInt(1);
				application.log("max " + max);
				conn.close();
				ps.close();
				rs.close();			
			}			
		}catch(Exception e) {}	
		
		
		String joindate = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		joindate = sdf.format(date);
		
		String year = joindate.substring(0, 4);
		String month = joindate.substring(4, 6);
		String day = joindate.substring(6, 8);
	%>

	<div align="center">
		<h2>홈쇼핑 회원 등록</h2>
		<form name="form" method="post" action="05_registerPro.jsp" onsubmit="return checkAll()">
			<table border="1">
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%= max + 1 %>" /></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" /></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" size="3" name="phone1" /> - <input type="text" size="4" name="phone2" /> - <input type="text" size="4" name="phone3" /></td>
				</tr>
				<tr>
					<th>통신사</th>
					<td>
						<input type="radio" name="address" value="SK" checked="checked" />SK
						<input type="radio" name="address" value="KT" />KT
						<input type="radio" name="address" value="LG" />LG
					</td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" size="4" name="year" value="<%= year %>" />년
					 <input type="text" size="2" name="month"  value="<%= month %>"/>월
					  <input type="text" size="2" name="day"  value="<%= day %>"/>일</td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td>
						<select name="grade">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" />
						<input type="button" value="조회" onclick="location.href='06_memberList.jsp'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<br /><br /><br /><br />

<%@include file="02_footer.jsp" %>