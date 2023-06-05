<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String strcm = request.getParameter("cm");
    String strkg = request.getParameter("kg");
    
    double cm = Double.parseDouble(strcm);
	double kg = Double.parseDouble(strkg);
	double BMI = kg / (cm/100 * cm/100);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	String con = null;
	if( BMI >= 25){
		con = "과체중";
		}else if(BMI <= 18){
			con = "저체중";
		}else {
			con = "정상";
		}%>
	이름 : <%= name %><br>
	신장 : <%= cm %><br>
	몸무게 : <%= kg %><br>
	BMI : <%= BMI %><br>
	상태 : <%= con %>
	
	<% if( BMI >= 25){%>
		<b>과체중입니다</b>
	<% }else if(BMI <= 18){%>
		<b>저체중입니다</b>
		<% }else {%>
		<b>정상입니다</b>
	<%} %>
</body>
</html>