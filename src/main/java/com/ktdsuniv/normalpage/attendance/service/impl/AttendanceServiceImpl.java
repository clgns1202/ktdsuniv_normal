package com.ktdsuniv.normalpage.attendance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.attendance.biz.AttendanceBiz;
import com.ktdsuniv.normalpage.attendance.service.AttendanceService;
import com.ktdsuniv.normalpage.attendance.vo.CheckTime;

import attendance.schema.AttendancesSchema;

public class AttendanceServiceImpl implements AttendanceService {
	
	private Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	private AttendanceBiz attendanceBiz;

	public void setAttendanceBiz(AttendanceBiz attendanceBiz) {
		this.attendanceBiz = attendanceBiz;
	}

	@Override
	public boolean addAttendanceForAndroid(String userId, String lectureId) {			
		return attendanceBiz.addAttendanceForAndroid(userId, lectureId);
	}

	@Override
	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId) {
		// TODO Auto-generated method stub
		return attendanceBiz.getAttendanceListByUserIdLectureId(userId, lectureId);
	}

	@Override
	public CheckTime getResultForUser(String userId, String lectureId) {
		// TODO Auto-generated method stub
		return attendanceBiz.getResultForUser(userId, lectureId);
	}
}
