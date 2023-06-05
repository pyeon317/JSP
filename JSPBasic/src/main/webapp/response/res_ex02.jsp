<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		/*css문법*/
		body{/*로그인 폼의 위치를 이동, body 전체에 적용됨*/
			padding: 0;
			margin: 0;
			background-image : url('/JSPBasic/response/cat1.jpg') ;/*주소 경로를 다 적으면 절대경로*/
			background-repeat: no-repeat;
			background-size: 100px 100px;/*각각 나눠서 썼지만 background : 으로 하면 한번에 전부 사용 가능함*/
			opacity: 0.8;/*투명도. 0.0~1.0*/
		}
		
		.wrap{
		display : flex;
		justify-content:center;
		align-items: center;
		height: 100vh;
		}
		
		#btn{/*클래스는 .  아이디는 #  */
			width: 100%;/*좌우길이*/
			background: #03c75a;/*배경색*/
			color: #fff;/*글자색*/
			font-weight: 900;/*글자크기*/
			border: none;/*테두리*/
			padding: 10px 5px;/*버튼 너비*/
		}
		.ins{
		background: gray;
		border: none;
		}
		
		
	</style>
</head>
<body>
	<!-- 
	디자인을 할 때 
	1. 인라인스타일시트 style속성을 사용해서 태그에 디자인을 주는 방법
	2. 내부스타일시트 태그에 class속성를 생성하고, head태그에서 디자인을 태그에 적용하는 방법
	id는 화면에서 반드시 이름이 고유할 때 적용 - 한 개에만 적용한다는 의미 // id는 #으로 접근
	class는 같은 이름이 여러 개여도 가능 - 여러 개에 동시적용한다는 의미 // class는 . 으로 접근
	 -->
	<div class="wrap">
		<form action="res_ex02_result.jsp" method="post" class="box">
			<h3 style="color: pink; text-align: center">로그인 폼</h3>
			<input type = "text" name="id" placeholder="아이디" style="color: red;" class="ins"><br>
			<input type = "password" name= "pw" placeholder="비밀번호"style="color: yellow;" class="ins"><br>
			<input type = "submit" value="로그인" id="btn">
		</form>
	</div>
</body>
</html>