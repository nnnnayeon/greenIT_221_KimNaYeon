<%@page import="exWeb.UserDTO" %>
<%@page import="exWeb.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="join.css">
<title>HOME</title>
</head>
<body>
	<%
	UserDAO dao = UserDAO.getInstance();
	if(dao.getConnection()!=null){
		
		System.out.println("데이터베이스 연동 완료");
	}else{
		System.out.println("데이터베이스 연동 실패");		
	}
	%>
	<div class="wrap3">
	<form action="_05.indexPro.jsp">
	<h2>로그인</h2>
	<input type="text" class="logId" name="id" placeholder="아이디"><br>
	<input type="password" class="logPw" name="pw" placeholder="비밀번호"><br>
	<input type="submit" class="loginBtn" name="login" value="로그인">
	<input type="button" class="joinBtn" name="join" value="회원가입" onclick="location.href = '_01.agree.jsp'">
	</form>
	</div>
	<script src="validation.js"></script>
</body>
</html>