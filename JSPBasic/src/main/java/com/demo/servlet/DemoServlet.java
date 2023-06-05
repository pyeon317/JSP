package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/banana")//쿨라이언트에서 특정 단어로 요청이 오면 이 클래스로 연결
public class DemoServlet extends HttpServlet{

	/**
	 * 알트 시프트 s
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		
		out.println("hello world");
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//컨텐츠타빙ㅂ, 인코딩타입 1 response객체에서
		resp.setContentType("text/plain; charset=UFT-8");//안하면 한글입력했을 때 안나옴
		PrintWriter out1 = resp.getWriter();
		out.println("");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	//get, post메서드를 오버라이드
	
}
