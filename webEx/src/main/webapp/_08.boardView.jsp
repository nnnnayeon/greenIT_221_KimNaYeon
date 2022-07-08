<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="board.css">
<title>Insert title here</title>
</head>
    <div class="formContainer">
        <form method="post" action="">
            <input type="text" id="title" name="title" value="<%=%>" required readonly><br>
            <textarea name="contents" required readonly><%=%></textarea><br>
            <input type="button" value="뒤로가기">
            <input type="button" value="수정하기">
        </form>
    </div>
</html>