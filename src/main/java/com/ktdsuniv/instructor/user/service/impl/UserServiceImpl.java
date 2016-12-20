package com.ktdsuniv.instructor.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import lecture.schema.LecturesSchema;
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
		return user;
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
		logger.debug("로그인정보"+signedUser);
		
		if( signedUser != null){
			session.setAttribute(Session.USER, signedUser);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean doModifyUserInfoAction(UsersSchema user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LecturesSchema> getUserLecture(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

}
