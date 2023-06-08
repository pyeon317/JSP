<%@page import="com.demo.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Member member = (Member)request.getAttribute("member");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=member.getId() %><br>
	<%=member.getPw() %><br>
	<%=member.getName() %><br>
</body>
</html>