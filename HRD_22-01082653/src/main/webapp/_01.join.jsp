<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
</head>
<body>
	<h1>JOIN</h1>
	<form action="location.href='_01.joinPro'">
		<input class="req" type="text" name="name" placeholder="name"><br>
        <input class="req" type="text" id="mobile" name="mobile" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="mobile" title="###-####-####">
		<div>
           <select>
               <option value="SK">SK</option>
               <option value="KT">KT</option>
               <option value="LG">LG</option>
           </select>
        </div>
        <input class="req" type="date"><br>
        <input class="req" type="text" name="usergrade" placeholder="grade"><br>
        <input class="req" type="number" placeholder="city"><br>
        
        <input type="button" value="뒤로가기" onclick="onclick=location.href='_00.main.jsp'">
        <input type="button" value="등록" onclick="checkVal(form)">
	</form>
	
	<script src="validation.js"></script>
</body>
</html>