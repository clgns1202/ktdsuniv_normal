package com.ktdsuniv.normalpage.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.user.biz.UserBiz;
import com.ktdsuniv.normalpage.user.service.UserService;

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
		String userId = user.getUserId();
		return userBiz.getUserInfo(userId);
	}
	
	@Override
	public void signUp(UsersSchema user) {
		//user.setBirthday(new Date(user.getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
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

	@Override
	public boolean userPasswordModify(UsersSchema user) {
		return userBiz.userPasswordModify(user);
	}

	@Override
	public boolean doDeleteUser(UsersSchema user) {
		return userBiz.doDeleteUser(user);
	}

	@Override
	public UsersSchema signInForAndroid(UsersSchema user, HttpSession session) {
		UsersSchema getUser = userBiz.signIn(user);
		logger.debug("안드로이드 로그인 정보"+getUser);
		
		if( getUser != null){
			session.setAttribute(Session.USER, getUser);
			return getUser;
		}
		return null;
	}

	@Override
	public  List<LecturesSchema> findLectureNameByLectureId(UsersSchema user) {
		return userBiz.findLectureNameByLectureId(user);
	}
	
	@Override
	public List<LecturesSchema> getUserLecture(HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		if(user != null){
			return userBiz.getUserLecture(user);			
		}
		else{
			return null;
		}
	}


}
