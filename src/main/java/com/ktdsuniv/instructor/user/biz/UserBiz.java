package com.ktdsuniv.instructor.user.biz;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface UserBiz {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

	public UsersSchema getUserInfo(String userId);

	public boolean doModifyUserInfoAction(UsersSchema user);

	public boolean userPasswordModify(UsersSchema user);

	public boolean doDeleteUser(UsersSchema user);

	public  List<LecturesSchema> findLectureNameByLectureId(UsersSchema user);
}
