package com.coding404.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conding404.user.model.UserVO;

public interface UserService {
	//추상메서드
	int join(HttpServletRequest request, HttpServletResponse response);
	UserVO login(HttpServletRequest request, HttpServletResponse response);
}
