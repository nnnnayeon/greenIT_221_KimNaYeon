<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="form.css">
<title>Insert title here</title>
</head>
<body>
	<%
		
	%>
	<h1>회원탈퇴</h1>
	<form method="post" action="_00.index.jsp">
		<div class="contents">
			<input class="req" name="password" type="password" placeholder="password">
			<span class="warning"><br>필수값 입력 바랍니다.</span>
		</div>
		
		<div class="buttons">
			<input type="button" value="뒤로가기" onclick="location.href='_04.main.jsp'">
			<input type="button" value="탈퇴하기" onclick="checkJoinVal(form)">
		</div>
	</form>
	<script type="validation.js"></script>
</body>
</html>