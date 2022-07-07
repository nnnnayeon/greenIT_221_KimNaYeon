<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agree</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="join.css">
</head>
<body>
	<div class=wrap>
		<form method="get" action="_02.join.jsp">
			<a> <img src="https://bit.ly/3y6zo6A">
			</a>
			<h4>
				<input type="checkbox" name="checkAll" class="checkAll"> 네이버
				이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 정보 수신(선택)에 모두 동의합니다.
			</h4>

			<h4>
				<input type="checkbox" name="check1" class="check"> 네이버 이용약관
				동의<span class="essen">(필수)</span>
			</h4>
			<textarea name="text" cols="30" rows="1">여러분을 환영합니다.네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’)</textarea>
			<h4>
				<input type="checkbox" name="check2" class="check"> 개인정보 수집
				및 이용 동의<span class="essen">(필수)</span>
			</h4>
			<textarea name="text" cols="30" rows="1">개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</textarea>
			<h4>
				<input type="checkbox" name="check3" class="check"> 위치기반서비스
				이용약관 동의<span class="choice">(선택)</span>
			</h4>
			<textarea name="text" cols="30" rows="1">위치기반서비스 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.

제 1 조 (목적)</textarea>
			<h4>
				<input type="checkbox" name="check4" class="check" id="check4"> 프로모션 정보
				수신 동의<span class="choice">(선택)</span>
			</h4>
			<p class="text">네이버에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(네이버앱 알림 또는 문자),
				이메일로 받아보실 수 있습니다.</p>
				
			<p class="hide">네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</p>
			<div class="btn">
				<input type="button" value="취소" class="cancle" onclick="location.href = '_00.index.jsp'">
				<input type="button" value="확인" class="submit" onclick=checkVal(form)>
			</div>

		</form>
	</div>
	<script src="validation.js"></script>
</body>
</html>