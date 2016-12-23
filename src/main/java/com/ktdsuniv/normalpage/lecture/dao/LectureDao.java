package com.ktdsuniv.normalpage.lecture.dao;

import java.util.List;

import lecture.schema.LecturesSchema;


import user.schema.UsersSchema;

public interface LectureDao {

	public int doApplyLecture(String lectureId, UsersSchema users);

	public int doApplyCancleLecture(String lectureId, UsersSchema users);

	public List<LecturesSchema> getLecturesByUserId(String userId);

	public LecturesSchema getLectures(String lectureId);

}
