package com.ktdsuniv.instructor.lecture.biz;

import user.schema.UsersSchema;

public interface LectureBiz {

	public boolean doApplyLecture(String lectureId, UsersSchema users);

	public boolean doApplyCancleLecture(String lectureId, UsersSchema users);

}
