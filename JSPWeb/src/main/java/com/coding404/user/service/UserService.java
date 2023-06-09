package com.coding404.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding404.user.model.UserVO;

public interface UserService {
	//추상메서드 
	int join(HttpServletRequest reqeust, HttpServletResponse response); 
	UserVO login(HttpServletRequest reqeust, HttpServletResponse response);
	UserVO getInfo(HttpServletRequest reqeust, HttpServletResponse response);
	int updateInfo(HttpServletRequest reqeust, HttpServletResponse response);
}
