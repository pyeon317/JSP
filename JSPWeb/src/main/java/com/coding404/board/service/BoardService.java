package com.coding404.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding404.board.model.BoardVO;

public interface BoardService {
	
	void regist(HttpServletRequest request, HttpServletResponse response);//등록
	List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	BoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
}
