package com.ktdsuniv.instructor.user.biz.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.dao.UserDao;

import common.util.SHA256Util;
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

}
