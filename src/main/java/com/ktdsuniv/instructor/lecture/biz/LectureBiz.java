package com.ktdsuniv.instructor.lecture.biz;

import java.util.List;

import lecture.schema.LecturesSchema;

public interface LectureBiz {

	List<LecturesSchema> getLecturesByUserId(String userId);

}
