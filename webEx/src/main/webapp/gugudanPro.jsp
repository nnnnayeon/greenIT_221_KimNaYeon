<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>No</th>
            <th>Quiz</th>
            <th>Input</th>
            <th>Result</th>
            <th>OX</th>
        </thead>
        <tbody>
			<%
			int score = 0;
			
			// answer1 / quiz1 / result1
			for(int i=0; i<10; i++){
				int answer = Integer.parseInt(request.getParameter("answer" + (i+1)));
				int result = Integer.parseInt(request.getParameter("result" + (i+1)));
				String quiz = request.getParameter("quiz" + (i + 1));
				if(answer == result)
					score += 10;	
			%>
            <tr>
                <td><%=i+1 %></td>
                <td><%=quiz %></td>
                <td><%=result %></td>
                <td><%=answer %></td>
                <td><%=answer == result ? "O" : "X" %></td>
            </tr>
            <%} %>
        </tbody>
    </table>
    <%=score %>점 입니다.
</body>
</html>