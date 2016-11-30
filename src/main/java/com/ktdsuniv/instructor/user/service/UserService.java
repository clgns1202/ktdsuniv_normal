package com.ktdsuniv.instructor.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import user.schema.UsersSchema;

public interface UserService {

	public UsersSchema getUserInfo(HttpSession session);


}
