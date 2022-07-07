<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan</title>
</head>
<body>
	<form action="gugudanPro.jsp">
    <table border="1">
        <thead>
            <th>No</th>
            <th>Quiz</th>
            <th>Input</th>
        </thead>
        <tbody>
        	<%
        	Random ran = new Random();
        	
        	for(int i=0; i<10; i++){
        		int x = ran.nextInt(8)+2;
        		int y = ran.nextInt(10)+1;
        		String quiz = String.format("%d x %d =", x, y);
        		int result = x * y;
        	%>
            <tr>
                <td><%=i+1 %></td>
                <td><%=quiz %></td>
                <td>
                	<input type="number" name="answer<%=i+1%>">
                	<input type="hidden" name="quiz<%=i+1%>" value="<%=quiz%>">
                	<input type="hidden" name="result<%=i+1%>" value="<%=result%>">
                </td>
            </tr>
            
            <%
        	}
            %>
        </tbody>
    </table>
	<input type="submit">
	</form>
</body>
</html>