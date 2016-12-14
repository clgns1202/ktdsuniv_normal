package com.ktdsuniv.instructor.user.dao;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface UserDao {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

	public String getSalt(UsersSchema user);

	public UsersSchema getUserInfo(String userId);

	public int doModifyUserInfoAction(UsersSchema user);

	public List<LecturesSchema> getUserLecture(UsersSchema user);
}
