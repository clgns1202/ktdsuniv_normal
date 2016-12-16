package com.ktdsuniv.normalpage.lecture.biz;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface LectureBiz {

	public boolean doApplyLecture(String lectureId, UsersSchema users);

	public boolean doApplyCancleLecture(String lectureId, UsersSchema users);

	public List<LecturesSchema> getLecturesByUserId(String userId);

}
