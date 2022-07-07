<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<link rel="stylesheet" href="join.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<div class="wrap2">
	<form action="_03.joinPro.jsp">
		<a> <img src="https://bit.ly/3y6zo6A"></a>
		<div class=info>
		<h4>아이디</h4>
		<input class="id" name="id" id="essen" type="text" placeholder="@naver.com " required>
		<h4>비밀번호</h4>
		<input class="password"  name="pw" id="essen" type="password" required>
		<p class="warning" >8 ~ 16자 영문, 숫자 조합을 사용해주세요.</p>
		<h4>비밀번호 확인</h4>
		<input class="password2" name="pw" id="essen" type="password" required>
		<h4>이름</h4>
		<input class="name" name="name" id="essen" type="text" required>
		<div class="birth">
		<h4>생년월일</h4>
		<input name="year" id="yy" type="text" placeholder="년(4자)" maxlength="4" required>
		<select id="mm" name="month">
			<option>월</option>
			<option>1월</option>
			<option>2월</option>
			<option>3월</option>
			<option>4월</option>
			<option>5월</option>
			<option>6월</option>
			<option>7월</option>
			<option>8월</option>
			<option>9월</option>
			<option>10월</option>
			<option>11월</option>
			<option>12월</option>
		</select>
		<input name="day" id="dd" type="text" placeholder="일" maxlength="2" required>
		</div>
		<h4>성별</h4>
		<select id="gender" name="gender" >
			<option>성별</option>
			<option>남자</option>
			<option>여자</option>
		</select>
		<div class="phone" >
		<h4>휴대전화</h4>
		<select id="country" name="country">
			<option>대한민국 +82</option>
			<option>가나 +23</option>
			<option>가봉 +241</option>
			<option>가이아나 +241</option>
			<option>감비아 +220</option>
			<option>과테말라 +502</option>
		</select>
		<span class="send">	
		<input id="number" name="mobile" type="text" placeholder="전화번호 입력" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="mobile" title="###-####-####" required>
		<button id="pBtn">인증번호 받기</button></span>
		<input id="cNum" type="text" placeholder="인증번호 입력하세요" required>
		</div>
		<input type="submit" value="가입하기" id="join">

	</form>	</div>
	<script src="validation.js"></script>
</body>
</html>