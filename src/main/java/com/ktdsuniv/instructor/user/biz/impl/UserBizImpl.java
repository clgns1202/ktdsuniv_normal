package com.ktdsuniv.instructor.user.biz.impl;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.dao.UserDao;

import user.schema.UsersSchema;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void signUp(UsersSchema user) {
		userDao.signUp(user);
	}

	@Override
	public UsersSchema signIn(UsersSchema user) {
		return userDao.signIn(user);
	}
}
