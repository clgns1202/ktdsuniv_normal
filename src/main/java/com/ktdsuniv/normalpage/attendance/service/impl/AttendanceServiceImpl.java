package com.ktdsuniv.normalpage.attendance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.attendance.biz.AttendanceBiz;
import com.ktdsuniv.normalpage.attendance.service.AttendanceService;

import attendance.schema.AttendancesSchema;

public class AttendanceServiceImpl implements AttendanceService {
	
	private Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	private AttendanceBiz attendanceBiz;

	public void setAttendanceBiz(AttendanceBiz attendanceBiz) {
		this.attendanceBiz = attendanceBiz;
	}

	@Override
	public boolean addAttendanceForAndroid(String userId) {			
		return attendanceBiz.addAttendanceForAndroid(userId);
	}

	@Override
	public List<AttendancesSchema> getAttendanceListByUserId(String userId) {
		// TODO Auto-generated method stub
		return attendanceBiz.getAttendanceListByUserId(userId);
	}
}
