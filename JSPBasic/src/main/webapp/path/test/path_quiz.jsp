<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<!-- style="background-image:url('/JSPBasic/jsptag/cat2.jpg')" -->
	<!-- a태그 사용해서 req_get01페이지로 상대경로-->
	<a href ="../../request/req_get01.jsp">req_get01 상대</a>
	<!-- a태그 사용해서 req_get01페이지로 절대경로-->
	<a href ="/JSPBasic/request/req_get01.jsp">req_get01 절대</a>
	<!-- a태그 사용해서 DemoServlet페이지로 상대경로 (브라우저의 경로를 확인)-->
	<a href ="../../banana">servlet맵핑</a>
	<!-- a태그 사용해서 DemoServlet페이지로 절대경로-->
	<a href ="/JSPBasic/banana">servlet절대</a>
	<br>
	<!-- jsptag폴더 밑에 있는 이미지를 띄워주세요. img태그로-->
	<img alt="이거 아닌듯" src="/JSPBasic/jsptag/cat2.jpg">
	<!-- alt는 이미지가 로딩이 안될때 출력되는 텍스트 -->
	
	<!-- contextPath =톱캣이 프로젝트를 구분하는 경로. 기본적으로 위의 경로는 패스가 고정되어있기 때문에 패스를 바꾸면 문제가 생긴다. 그러나 아래처럼 하면 패스가 바뀌어도 자동으로 가져오기 때문에 문제가 없다.-->
	<a href ="<%=request.getContextPath() %>/banana">servlet절대</a> 
</body>
</html>