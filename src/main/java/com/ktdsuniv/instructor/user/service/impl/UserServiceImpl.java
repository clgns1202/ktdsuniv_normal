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
		String userId = user.getUserId();
		return userBiz.getUserInfo(userId);
	}
	
	@Override
	public void signUp(UsersSchema user) {
		user.setBirthday(new Date(user.getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.signUp(user);
	}

	@Override
	public boolean signIn(UsersSchema user, HttpSession session) {
		UsersSchema signedUser = userBiz.signIn(user);
		logger.debug("로그인정보"+signedUser);
		
		if( signedUser != null){
			session.setAttribute(Session.USER, signedUser);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean doModifyUserInfoAction(UsersSchema user) {
		return userBiz.doModifyUserInfoAction(user);
	}


}
