package com.ktdsuniv.instructor.user.service.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public UsersSchema getUserInfo(HttpSession session) {
		
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		return user;
	}
}
