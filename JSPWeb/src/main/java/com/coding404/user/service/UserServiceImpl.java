package com.coding404.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding404.user.model.UserDAO;
import com.coding404.user.model.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public int join(HttpServletRequest reqeust, HttpServletResponse response) {
		
		String id = reqeust.getParameter("id");
		String pw = reqeust.getParameter("pw");
		String name = reqeust.getParameter("name");
		String email = reqeust.getParameter("email");
		String gender = reqeust.getParameter("gender");
		
		//아이디 중복검사
		//싱글톤 객체를 얻는 방법
		UserDAO dao = UserDAO.getInstance();
		int result = dao.idCheck(id);
		
		if(result == 1) { //중복
			return 1;
		} else { //가입처리
			UserVO vo = new UserVO(id, pw, name, email, gender, null);
			dao.join(vo);
			
			return 0;
		}
		
		
	}

	
	@Override
	public UserVO login(HttpServletRequest reqeust, HttpServletResponse response) {
		
		String id = reqeust.getParameter("id");
		String pw = reqeust.getParameter("pw");
		
		//로그인
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		return vo;
	}


	
	@Override
	public UserVO getInfo(HttpServletRequest reqeust, HttpServletResponse response) {
		
		//회원아이디 - 회원아이디는 세션에 존재
		HttpSession session = reqeust.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//dao호출
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		return vo;
	}


	
	@Override
	public int updateInfo(HttpServletRequest reqeust, HttpServletResponse response) {
		
		/*
		 * 서비스와 DAO영역을 작성.
		 * 1. 아이디 기반으로 회원정보를 수정합니다.
		 * 2. 성공실패 여부를 컨트롤러로 반환 받습니다.
		 * 3. 수정 성공시에는 mypage로 리다이렉트, 실패시에는 modify로 리다이렉트 
		 */
		String id = reqeust.getParameter("id");
		String pw = reqeust.getParameter("pw");
		String name = reqeust.getParameter("name");
		String email = reqeust.getParameter("email");
		String gender = reqeust.getParameter("gender");
		
		
		UserVO vo = new UserVO(id, pw, name, email, gender, null);
		
		//dao객체
		UserDAO dao = UserDAO.getInstance();
		int result = dao.updateInfo(vo);
		
		return result;
	}

}
