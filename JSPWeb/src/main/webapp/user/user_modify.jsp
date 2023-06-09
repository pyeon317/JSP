<%@page import="com.coding404.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
		<h3>회원정보 수정</h3>
		<b>${sessionScope.user_name}님 회원 정보를 수정합니다</b>
		
		<!-- 
		readonly 는 태그의 읽기전용
		disabled 는 태그의 사용금지 (파라미터값에서 제외됨)
		checked 는 미리선택함
		required 는 필수로 값을 지정
		
		인풋태그에 미리값을 가지려면 value를 사용합니다.
		
		 -->
		
		
		<form action="user_update.user" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" value="${vo.id }" readonly="readonly" ></td>
				</tr>			
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required" pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="name" value="${vo.name }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${vo.email }"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="M" ${vo.gender == 'M' ? 'checked' : '' }>남자 
						<input type="radio" name="gender" value="F" ${vo.gender == 'F' ? 'checked' : '' }>여자 
					</td>
				</tr>
			</table>
							
			<input type="submit" value="정보수정">
			<input type="button" value="회원페이지로 가기" onclick="location.href='user_mypage.user' ">			
			
		</form>
		
		
	</div>


</section>


<%@ include file="../include/footer.jsp" %>    
    