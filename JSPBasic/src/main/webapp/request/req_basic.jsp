<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath(); 
    	StringBuffer url = request.getRequestURL();
    	String uri = request.getRequestURI();
    	String remote = request.getRemoteAddr();
    	String header = request.getHeader("content-Type");//헤더정보값
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	컨택스트패스(프로젝트 식별 주소):<%=path %><br/>
	유알엘(전체 주소):<%=uri %><br/>
	유알아이(포트번호를 제외한 나머지 주소):<%=uri %><br/>
	접속한 주소(ip주소/본인 컴퓨터일 경우 0:0:0:~:1):<%=remote %><br/>
	요청에 대한 문서타입:<%=header %><br/>
	
</body>
</html>