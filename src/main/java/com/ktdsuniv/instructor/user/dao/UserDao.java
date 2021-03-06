package com.ktdsuniv.instructor.user.dao;

import user.schema.UsersSchema;

public interface UserDao {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

	public String getSalt(UsersSchema user);

	public int existUserId(String userId);

}
