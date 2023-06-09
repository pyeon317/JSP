package com.coding404.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding404.board.model.BoardVO;
import com.coding404.board.service.BoardService;
import com.coding404.board.service.BoardServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring( conPath.length()  );
		
		System.out.println(command);
		
		BoardService service = new BoardServiceImpl();
		
		
		
		
		//글쓰기 화면에 대한 처리
		if(command.equals("/board/board_write.board")) {
			
			request.getRequestDispatcher("board_write.jsp").forward(request, response);
			
		//목록 화면에 처리
		} else if(command.equals("/board/board_list.board")) {
			
			//목록을 가지고 나옴
			List<BoardVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("board_list.jsp").forward(request, response);
			
		
		
		//등록 작업
		} else if(command.equals("/board/registForm.board")) {
			service.regist(request, response);
			//1.forward
			//request.getRequestDispatcher("board_list.jsp").forward(request, response);
			//2.redirect
			response.sendRedirect("board_list.jsp");
		
		
		
		//상세 화면
		} else if(command.equals("/board/board_content.board")){
			
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_content.jsp").forward(request, response);
		
		
		
		//수정 화면
		}else if(command.equals("/board/board_modify.board")){
			
			//내용을 수정하는 것이기 때문에 그대로 사용
			//getContent : bno 필요>?bno=${vo.bno} 를 써서 bno값을 받도록 함
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);
		
		//글 수정
		} else if(command.equals("/board/board_update.board")) {
			
			service.update(request, response);
			
			String bno = request.getParameter("bno");
			//상세페이지로 이동
			response.sendRedirect("board_content.board?bno=" + bno);
		
			
		//글 삭제
		} else if(command.equals("/board/board_delete.board")) {
			
		}
	
	
	
	}
}
