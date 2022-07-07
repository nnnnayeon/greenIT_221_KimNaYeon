<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 2~9단까지 출력 --%>
	<%-- 타이틀 h1 --%>
	<%-- 내용 p --%>
	
	<%
	// 스크립틀릿
	for(int i=2; i<=9; i++){%>
		<h1>[<%=i %>단]</h1>
		<%
		for(int j=1; j<=10; j++){%>
			<%=i %> X <%=j %> = <%=i*j %><br>
		<%
		}
		%>
		</p>
	<%
	}
	%>
		
</body>
</html>