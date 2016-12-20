package com.ktdsuniv.instructor.user.biz;

import user.schema.UsersSchema;

public interface UserBiz {
	
	public boolean signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

}
