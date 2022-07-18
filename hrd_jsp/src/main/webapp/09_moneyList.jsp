<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="01_header.jsp" %>

	<%
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
		
	// 번호 이름 등급 
	ArrayList<String[]> memberList = new ArrayList<String[]>();
	// 번호 매출 
	ArrayList<String[]> moneyList = new ArrayList<String[]>();
	
	try {
		conn = MemberDAO.getConnection();		
		String sql = "SELECT * FROM  member_tbl_02";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();		
		while(rs.next()) {
			String[] member = new String[4];
			member[0] = rs.getInt("custno") + "";
			member[1] = rs.getString("custname");					
			String grade = rs.getString("grade");
			String gradeCode[] = {"A" , "B" ,"C"};
			String gradeList[] = {"VIP" , "일반" , "직원"};
			for(int i = 0; i < gradeCode.length; i++){
				if(grade.equals(gradeCode[i])){
					grade = gradeList[i];
				}
			}			
			member[2] = grade;	
			member[3] = "0";
			memberList.add(member);			
		}		
		conn.close();
		ps.close();
		rs.close();
		
		conn = MemberDAO.getConnection();		
		sql = "SELECT * FROM  money_tbl_02";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();		
		while(rs.next()) {
			String[] money = new String[2];
			
			money[0] = rs.getInt("custno") + "";
			money[1] = rs.getString("pcost");					
			moneyList.add(money);
		}		
		conn.close();
		ps.close();
		rs.close();
			
	}catch(Exception e) {}
		
	application.log("---------------------------------------");
	for(String[] member : memberList){
		application.log(member[0] + " " + member[1] + " " + member[2]);
	}
	application.log("---------------------------------------");
	for(String[] money : moneyList){
		application.log(money[0] + " " + money[1] );
	}
	application.log("---------------------------------------");	
	
	for(String [] member : memberList){
		for(String [] money : moneyList){
			if(member[0].equals(money[0])){
				int price = Integer.parseInt(member[3]);
				price += Integer.parseInt(money[1]);
				member[3] = price + "";
			}
		}
	}
	
	application.log("---------------------------------------");
	for(String[] member : memberList){
		application.log(member[0] + " " + member[1] + " " + member[2] + " " + member[3]);
	}
	
	for(int i = 0; i < memberList.size(); i++){
		for(int j = i + 1; j < memberList.size(); j++){
			if(memberList.get(i)[3].compareTo(memberList.get(j)[3]) < 0){
				String [] temp = memberList.get(i);
				memberList.set(i , memberList.get(j));
				memberList.set(j , temp);
			}
		}
	}
	application.log("---------------------------------------");
	for(String[] member : memberList){
		application.log(member[0] + " " + member[1] + " " + member[2] + " " + member[3]);
	}
	
	application.log("---------------------------------------");
	
	DecimalFormat df = new DecimalFormat("###,###");
			
	%>
		
	<div align="center">
		<h2>회원 매출 조회</h2>
	
		<table border="1">
			<tr>
				<td>회원번호</td>
				<td>회원성명</td>
				<td>고객등급</td>
				<td>매출</td>
			</tr>
	    <%	for(int i=0; i<memberList.size(); i++) { %>
			<tr>
				<%
					String [] member = memberList.get(i);
					int total = Integer.parseInt(member[3]);
				%>
			
				<%if(total > 0 ){ %>
				<td><%= member[0] %></td>
				<td><%= member[1]%></td>
				<td><%=  member[2] %></td>
				<td><%= df.format( total )%></td>
				<%} %>
			</tr>
		<%}%> 
		</table>
	</div>
	
	<br /><br /><br /><br />
	
<%@include file="02_footer.jsp" %>