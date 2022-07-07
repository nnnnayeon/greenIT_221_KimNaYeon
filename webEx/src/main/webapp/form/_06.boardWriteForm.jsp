<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="board.css">
<title>Insert title here</title>
</head>
<body>
    <h1>GREEN BOARD</h1>
    <div class="formContainer">
        <form method="post" action="_07.boardWriteFormPro">
            <input type="text" id="title" name="title" placeholder="title" required><br>
            <textarea name="contents" placeholder="contents text" required></textarea><br>
            <input type="button" value="뒤로가기" onclick="location.href = '_05.board.jsp'">
            <input type="submit" value="글쓰기" onclick="">
        </form>
    </div>

</body>
</html>