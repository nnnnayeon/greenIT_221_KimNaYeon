<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.MemberDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="01_header.jsp" %>
	<%
		int custno = Integer.parseInt(request.getParameter("custno"));
		String[] member = new String[7];
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MemberDAO.getConnection();
			
			String sql = "SELECT * FROM  member_tbl_02 where custno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);
			rs = ps.executeQuery();
			
			if(rs.next()) {

				// 7개
				member[0] = rs.getInt("custno") + "";
				member[1] = rs.getString("custname");
				member[2] = rs.getString("phone");
				member[3] = rs.getString("address");						
				member[4] =  rs.getString("joindate");			
				
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
			
				member[6]= city;
				conn.close();
				ps.close();
				rs.close();
			}
		}catch(Exception e) {}
		
		
		String phoneArr[] = member[2].split("-");
		
		String year = member[4].substring(0, 4);
		String month = member[4].substring(5, 7);
		String day = member[4].substring(8, 10);
	%>
	<div align="center">
		<h2>회원목록 조회/수정</h2>
		<form method="post" action="08_updatePro.jsp">
			<table border="1">
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="custno" value="<%= custno %>" /></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value="<%= member[1] %>" /></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" size="3" name="phone1" value="<%= phoneArr[0] %>" /> - 
					<input type="text" size="4" name="phone2" value="<%= phoneArr[1] %>" />- 
					<input type="text" size="4" name="phone3" value="<%= phoneArr[2] %>" /></td>
				</tr>
				<tr>
					<th>통신사</th>
					<td>
						<input type="radio" name="address" value="SK" <% if(member[3].equals("SK")) { %> checked="checked" <% } %> />SK
						<input type="radio" name="address" value="KT" <% if(member[3].equals("KT")) { %> checked="checked" <% } %> />KT
						<input type="radio" name="address" value="LG" <% if(member[3].equals("LG")) { %> checked="checked" <% } %> />LG
					</td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" size="4" name="year" value="<%= year %>" />년 <input type="text" size="2" name="month" value="<%= month %>" />월 <input type="text" size="2" name="day" value="<%= day %>" />일</td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td>
						<select name="grade">
							<option value="A" <% if(member[5].equals("A")) { %> selected="selected" <% } %> >A</option>
							<option value="B" <% if(member[5].equals("B")) { %> selected="selected" <% } %> >B</option>
							<option value="C" <% if(member[5].equals("C")) { %> selected="selected" <% } %> >C</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value="<%= member[6] %>" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정" />
						<input type="button" value="조회" onclick="location.href='06_memberList.jsp'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<br /><br /><br /><br />
	
<%@include file="02_footer.jsp" %>