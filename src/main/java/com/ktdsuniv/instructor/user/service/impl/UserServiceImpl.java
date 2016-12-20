package com.ktdsuniv.instructor.user.service.impl;

import java.util.Date;

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
	public boolean signUp(UsersSchema user) {
		user.setBirthday(new Date(user.getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		user.setCreatedDate(new Date());
		return userBiz.signUp(user);
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
