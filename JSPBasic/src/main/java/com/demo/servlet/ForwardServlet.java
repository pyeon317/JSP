package com.demo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/apple")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForwardServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실행됨~~~");
		
		//리다이렉트
		//response.sendRedirect("actionTag/forward_ex02_ok.jsp");//리퀘스트를 하려면 리퀘스트~,리다이렉트를 하려면 리스폰스~
		request.setAttribute("name", "홍길동");
		request.setAttribute("date", new Date());
		//포워드
		//RequestDispatcher dp = request.getRequestDispatcher("actionTag/forward_ex02_ok.jsp");
		//dp.forward(request, response);
		//위아래 같은 의미
		request.getRequestDispatcher("actionTag/forward_ex02_ok.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
