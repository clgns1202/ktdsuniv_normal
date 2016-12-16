package com.ktdsuniv.instructor.lecture.dao;

import java.util.List;

import lecture.schema.LecturesSchema;

public interface LectureDao {

	List<LecturesSchema> getLecturesByUserId(String userId);

}
