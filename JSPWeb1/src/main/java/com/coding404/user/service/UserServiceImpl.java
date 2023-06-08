package com.coding404.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conding404.user.model.UserDAO;
import com.conding404.user.model.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		//즁복아이디 검사
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
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		return vo;
		
	}

}
