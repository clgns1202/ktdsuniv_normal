package com.ktdsuniv.instructor.user.dao;

import java.util.List;

import grades.schema.TestsSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface UserDao {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

	public String getSalt(UsersSchema user);

	public UsersSchema getUserInfo(String userId);

	public int doModifyUserInfoAction(UsersSchema user);

	public int userPasswordModify(UsersSchema user);

	public int doDeleteUser(UsersSchema user);

	public List<LecturesSchema> findLectureNameByLectureId(UsersSchema user);

}
