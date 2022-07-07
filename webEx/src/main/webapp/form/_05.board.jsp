<%@page import="exWeb.BoardDTO"%>
<%@page import="exWeb.BoardDAO"%>
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
	<% BoardDAO dao = BoardDAO.getInstance();  %>
	<h1>Board List</h1>
	<div class="boardListContainer">
		<table border="1">
			<thead>
				<tr>
					<th>no</th>
					<th>code</th>
					<th>title</th>
					<th>ViewCnt</th>
					<th>likeCnt</th>
					<th>createAt</th>
					<th>modifiedAt</th>
				</tr>
			</thead>

			<tbody>
				<%	  
		       	if(dao.getBoardDto().size() > 0){
		            for(int i = 0; i < dao.getSize(); i++) {
		           		BoardDTO dto = dao.getBoardDto().get(i);
            	%>

				<tr>
					<td><%=dto.getNo()%></td>
					<td><%=dto.getCode()%></td>
					<td><%=dto.getTitle()%></td>
					<td><%=dto.getContents() %></td>
					<td><%=dto.getViewCnt()%></td>
					<td><%=dto.getLikeCnt()%></td>
					<td><%=dto.getCreateAt()%></td>
					<td><%=dto.getModifiedAt()%></td>
				</tr>

				<%
		            }		            
            }
            %>
			</tbody>
		</table>
	</div>
</body>
</html>