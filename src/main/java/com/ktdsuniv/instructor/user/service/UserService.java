package com.ktdsuniv.instructor.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import lecture.schema.LecturesSchema;

import javax.servlet.http.HttpSession;

import user.schema.UsersSchema;

public interface UserService {

	public UsersSchema getUserInfo(HttpSession session);

	public void signUp(UsersSchema user);

	public boolean signIn(UsersSchema user, HttpSession session);

	public boolean doModifyUserInfoAction(UsersSchema user);

	public boolean userPasswordModify(UsersSchema user);

	public boolean doDeleteUser(UsersSchema user);

	public UsersSchema signInForAndroid(UsersSchema user, HttpSession session);

	public  List<LecturesSchema> findLectureNameByLectureId(UsersSchema user);
}
