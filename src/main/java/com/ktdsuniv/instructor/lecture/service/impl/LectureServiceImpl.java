package com.ktdsuniv.instructor.lecture.service.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.service.LectureService;

import common.constants.Session;
import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}

	@Override
	public PageListVO getLectureList(SearchVO search) {
		if(search.getSearchType()==1){
			search.setSearchKeyName("lectureName");
		}
		else if(search.getSearchType()==2) {
			search.setSearchKeyName("instructor.user.userName");
		}
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		return commonBiz.getMongoList(search, pager, LecturesSchema.class);
	}
	
	@Override
	public LecturesSchema getDetailLecture(String lectureId) {
		return commonBiz.getMongoById("_id", lectureId, LecturesSchema.class);
	}
	
	@Override
	public boolean doApplyLecture(String lectureId, HttpSession session) {
		UsersSchema users = (UsersSchema) session.getAttribute(Session.USER);
		return lectureBiz.doApplyLecture(lectureId, users);
	}
	
	@Override
	public boolean doApplyCancleLecture(String lectureId, HttpSession session) {
		UsersSchema users = (UsersSchema) session.getAttribute(Session.USER);
		return lectureBiz.doApplyCancleLecture(lectureId, users);
	}
	
}
