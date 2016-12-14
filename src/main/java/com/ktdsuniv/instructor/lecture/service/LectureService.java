package com.ktdsuniv.instructor.lecture.service;

import javax.servlet.http.HttpSession;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;

public interface LectureService {

	public PageListVO getLectureList(SearchVO search);

	public LecturesSchema getDetailLecture(String lectureId);

	public boolean doApplyLecture(String lectureId, HttpSession session);

	public boolean doApplyCancleLecture(String lectureId, HttpSession session);

}
