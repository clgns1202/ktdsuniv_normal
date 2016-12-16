package com.ktdsuniv.normalpage.lecture.biz.impl;

import java.util.List;

import com.ktdsuniv.normalpage.lecture.biz.LectureBiz;
import com.ktdsuniv.normalpage.lecture.dao.LectureDao;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureBizImpl implements LectureBiz {

	private LectureDao lectureDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}

	@Override
	public List<LecturesSchema> getLecturesByUserId(String userId) {
		return lectureDao.getLecturesByUserId(userId);
	}
	
	@Override
	public boolean doApplyLecture(String lectureId, UsersSchema users) {
		return lectureDao.doApplyLecture(lectureId,users)>0;
	}
	
	@Override
	public boolean doApplyCancleLecture(String lectureId, UsersSchema users) {
		return lectureDao.doApplyCancleLecture(lectureId, users)>0;
	}
	
}
