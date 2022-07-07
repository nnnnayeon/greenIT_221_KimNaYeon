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
		// post 메소드로 전달된 파라미터 값 확인 
		// ㄴ 캐릭터셋 인코딩을 반드시 맞춰주어야 한다
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*
		id
		password[]
		name
		year
		month
		day
		gender
		email
		country
		mobile
		*/
		String id = request.getParameter("id");
		String[] password = request.getParameterValues("password");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String mobile = request.getParameter("mobile");
		
		/*
		out.println(id);
		out.println(password[0]);
		out.println(password[1]);
		out.println(name);
		out.println(year);
		out.println(month);
		out.println(day);
		out.println(gender);
		out.println(email);
		out.println(country);
		out.println(mobile);
		out.println(id);
		*/
		
		String log = (String) session.getAttribute("log");
		
		if(log == null){
			System.out.println(log);
			// response.sendRedirect("_00.index.jsp");
		}else{
			// System.out.println(log);
			%>
			<h1><%=log%>님 환영합니다</h1>
			<div class="buttons">
				<input type="button" value="로그아웃" onclick="location.href='_00.logoutPro.jsp'">
				<input type="button" value="게시판" onclick="location.href='_05.board.jsp'">
			</div>
		<%
		}
		%>
</body>
</html>