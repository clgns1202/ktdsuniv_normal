package com.ktdsuniv.instructor.user.biz;

import user.schema.UsersSchema;

public interface UserBiz {
	
	public void signUp(UsersSchema user);

	public UsersSchema signIn(UsersSchema user);

	public UsersSchema getUserInfo(String userId);

	public boolean doModifyUserInfoAction(UsersSchema user);
}
