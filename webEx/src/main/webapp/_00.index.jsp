<%@page import="exWeb.UserDTO" %>
<%@page import="exWeb.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="form.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>LOGIN</title>
</head>
<body>
	<%
	/*
	UserDAO dao = UserDAO.getInstance();
	if(dao.getConnection()!=null){
		
		System.out.println("데이터베이스 연동 완료");
	}else{
		System.out.println("데이터베이스 연동 실패");		
	}
	*/
	%>
	<h1>LOGIN</h1>
	<form method="post" action="./login">
		<div class="contentss">
			<input class="req" name="id" type="text" placeholder="id">
			<span class="warning"><br>필수값 입력 바랍니다.<br></span>
			
			<input class="req" name="password" type="password" placeholder="password">
			<span class="warning"><br>필수값 입력 바랍니다.</span>
		</div>
		
		<div class="buttons">
			<input type="button" value="회원가입" onclick="location.href='./agree'">
			 <input type="submit"  onclick="check(form)" value="로그인" >
		</div>
	</form>
	
	<script src="validation.js"></script>
</body>
</html>