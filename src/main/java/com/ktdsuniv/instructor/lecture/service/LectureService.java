package com.ktdsuniv.instructor.lecture.service;

import java.util.List;

import lecture.schema.LecturesSchema;

public interface LectureService {

	public LecturesSchema getLectureById(String string);

	public List<LecturesSchema> getLecturesByUserId(String userId);

}
