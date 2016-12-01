package com.ktdsuniv.instructor.user.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public UsersSchema getUserInfo(HttpSession session) {
		
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		logger.debug(user.getUserId());
		return user;
	}
	
	@Override
	public void signUp(UsersSchema user) {
		user.setBirthday(new Date(user.getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.signUp(user);
	}

	@Override
	public boolean signIn(UsersSchema user, HttpSession session) {
		UsersSchema signedUser = userBiz.signIn(user);
		if( signedUser != null){
			session.setAttribute(Session.USER, signedUser);
			return true;
		}
		
		return false;
	}
}
