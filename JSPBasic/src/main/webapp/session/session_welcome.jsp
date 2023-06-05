
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = (String)session.getAttribute("user_id");
    String nick = (String)session.getAttribute("user_nick");
    
    //로그인한 사람만 접근이 가능
    if(session.getAttribute("user_id") == null){
    	response.sendRedirect("session_login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background: ; 
opacity: ;
}
.wrap{
	display : flex;
		justify-content:center;
		align-items: center;
		height: 100vh;
}
</style>
</head>
<body>
	<div class = "wrap">
		아이디 <%=id%>, 닉네임 <%=nick %>님 환영합니다.<br><br><br><br>
		
		<a href = "session_logout.jsp">로그아웃</a>
	</div>
	
</body>
</html>