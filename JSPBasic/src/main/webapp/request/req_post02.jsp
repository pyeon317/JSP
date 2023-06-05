<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");//포스트방식의 한글처리
    String ssr = request.getParameter("ssr");
    String pw = request.getParameter("pw");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%=ssr %><br>
	<%=pw %><br>
</body>
</html>