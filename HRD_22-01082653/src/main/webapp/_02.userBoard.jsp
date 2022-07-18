<%@page import="USER.UserDAO"%>
<%@page import="USER.UserDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	UserDAO dao = UserDAO.getinstance();
	%>
    <h1>UserBoard</h1>
    <div class="boardListContainer">
        <table border="1">
            <thead>
                <th>회원번호</th>
                <th>회원성명</th>
                <th>전화번호</th>
                <th>통신사</th>
                <th>가입일지</th>
                <th>고객등급</th>
                <th>거주지역</th>
            </thead>
            <tbody>
            	<% 
            	for(int i=0; i<dao.getUsers().size(); i++){
            		UserDTO dto = dao.getUsers().get(i);
            	%>
                <tr>
					<td><%=dto.getCustno() %></td>               
					<td><%=dto.getCustname() %></td>               
					<td><%=dto.getPhone() %></td>               
					<td><%=dto.getAddress() %></td>               
					<td><%=dto.getJoindate() %></td>               
					<td><%=dto.getGrade() %></td>               
					<td><%=dto.getCity() %></td>               
                </tr>
            </tbody>
            <%
            	}
            %>
            
        </table>

    </div>
</body>
</html>