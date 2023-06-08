package com.conding404.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding404.user.service.UserServiceImpl;
import com.conding404.user.model.UserVO;

//1.확장자 패턴으로 변경
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAction(request, response);
	}
	
	//2. get/post 를 하나로 모은다.
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.요청분기
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
		
		//** MVC2에서는 화면을 띄우는 요청도 컨트롤러를 거쳐 나가도록 처리
		//** 기본이동이 전부 forward형식으로 처리를 합니다.
		//** 리다이렉트는 다기 컨트롤러를 태워 나가는 용도로 사용합니다.
		
		//필요한 객체를 if문 바깥에 선언
		UserServiceImpl service = new UserServiceImpl();//UserService service = new UserServiceImpl(); 이렇게 인터페이스로 해도 됨
		
		if(command.equals("/user/user_join.user")) {
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		
		}else if(command.equals("/user/user_login.user")) {
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		
		//회원가입요청
		}else if(command.equals("/user/joinForm.user")) {
			
			//가입
			
			int result = service.join(request, response);
			
			if(result == 1) { //중복
				
				request.setAttribute("msg", "중복된 아이디 입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
				
			} else { //가입성공
				
				response.sendRedirect("/user/login.user");
			}
			
			//로그인
		}else if(command.equals("/user/loginForm.user")) {
			UserVO vo = service.login(request, response);
			
			if(vo == null) {//로그인 실패
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
			} else {//로그인 성공
				//세션에 회원정보 저장
				HttpSession session = request.getSession();//getSession() 현재 접속중인 세션 반환
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				
				response.sendRedirect("user_mypage.user");
			}
		}else if(command.equals("/user/user_mypage.user")) {
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
			
		}else if(command.equals("/user/user_logout.user")) {
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}
	}
}
