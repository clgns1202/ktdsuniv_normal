package com.ktdsuniv.instructor.user.biz;

import user.schema.UsersSchema;

public interface UserBiz {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);
}
