<%@page import="member.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


	<% request.setCharacterEncoding("UTF-8"); %>

	<%
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		String address = request.getParameter("address");
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String joindate = year + month + day;
		
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		Connection conn = null;
		PreparedStatement ps = null;
		// insert 는 rs 가 필요없다. rs 는 select 에서만 필요하다. 	
		try {
			conn = MemberDAO.getConnection();
			String sql = "INSERT INTO member_tbl_02 (custno, custname, phone, address, joindate, grade, city) VALUES(member_seq.nextval, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);  
			ps.setString(1, custname);
			ps.setString(2, phone);
			ps.setString(3, address);			
			ps.setString(4, joindate);		
			ps.setString(5, grade);
			ps.setString(6, city);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {}
		
		
	%>
	<script>
		alert('회원등록이 완료 되었습니다!');
		location.href='04_register.jsp';
	</script>	
