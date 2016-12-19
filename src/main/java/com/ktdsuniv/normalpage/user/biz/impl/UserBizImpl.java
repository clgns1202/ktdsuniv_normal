package com.ktdsuniv.normalpage.user.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.user.biz.UserBiz;
import com.ktdsuniv.normalpage.user.dao.UserDao;

import common.util.SHA256Util;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class UserBizImpl implements UserBiz {

	
	private Logger logger = LoggerFactory.getLogger(UserBizImpl.class);
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void signUp(UsersSchema user) {
		String salt = SHA256Util.generateSalt();
		user.setUserSalt(salt);
		
		String password = user.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		user.setUserPassword(password);
		userDao.signUp(user);
	}

	@Override
	public UsersSchema signIn(UsersSchema user) {
		String salt = userDao.getSalt(user);
		logger.info("솔트"+salt);
		user.setUserSalt(salt);
		
		String password = user.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		user.setUserPassword(password);
		
		return userDao.signIn(user);
	}

	@Override
	public UsersSchema getUserInfo(String userId) {
		
		return userDao.getUserInfo(userId);
	}

	@Override
	public boolean doModifyUserInfoAction(UsersSchema user) {
		return userDao.doModifyUserInfoAction(user) > 0;
	}

	@Override
	public boolean userPasswordModify(UsersSchema user) {
		String salt = SHA256Util.generateSalt();
		user.setUserSalt(salt);
		
		String password = user.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		user.setUserPassword(password);
		
		return userDao.userPasswordModify(user) > 0;
	}

	@Override
	public boolean doDeleteUser(UsersSchema user) {
		return userDao.doDeleteUser(user) > 0;
	}

	@Override
	public List<LecturesSchema> findLectureNameByLectureId(UsersSchema user) {
		return userDao.findLectureNameByLectureId(user);
	}
}
