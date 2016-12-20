package com.ktdsuniv.instructor.user.service;

import javax.servlet.http.HttpSession;

import user.schema.UsersSchema;

public interface UserService {

	public boolean signUp(UsersSchema user);

	public boolean signIn(UsersSchema user, HttpSession session);

}
