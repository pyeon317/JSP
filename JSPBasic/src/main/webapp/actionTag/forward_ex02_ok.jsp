<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //2번 페이지에서 넘어온 값
    String name = (String)request.getAttribute("name");
    Date date = (Date)request.getAttribute("date");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>결과페이지</h3>
</body>
</html>