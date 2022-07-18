<%@ page import ="USER.UserDAO" %>
<%@ page import ="USER.UserDTO" %>
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
	request.setCharacterEncoding("utf-8");
	
	UserDAO dao = UserDAO.getinstance();
 
 	int custno = Integer.parseInt(request.getParameter("custno"));
 	String custname = request.getParameter("custname");
 	String phone = request.getParameter("phone");
 	String address = request.getParameter("address");
 	String joindate = request.getParameter("joindate");
 	String grade = request.getParameter("grade");
 	String city = request.getParameter("city");
 	
 	UserDTO users = new UserDTO(custno, custname, phone, address, joindate, grade, city);
 	
 	String url = "";
 	if(dao.addUser(users)){
 		url="_00.main.jsp";
 	}
 	else {
 		url="_01.join.jsp";
 	}
	%>

</body>
</html>