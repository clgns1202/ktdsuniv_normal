package com.ktdsuniv.instructor.lecture.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import lecture.schema.LecturesSchema;

public class LectureBizImpl implements LectureBiz {

	private LectureDao lectureDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}

	@Override
	public List<LecturesSchema> getLecturesByUserId(String userId) {
		// TODO Auto-generated method stub
		return lectureDao.getLecturesByUserId(userId);
	}
	
}
