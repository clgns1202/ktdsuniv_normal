package com.ktdsuniv.instructor.lecture.dao;

import user.schema.UsersSchema;

public interface LectureDao {

	public int doApplyLecture(String lectureId, UsersSchema users);

	public int doApplyCancleLecture(String lectureId, UsersSchema users);

}
