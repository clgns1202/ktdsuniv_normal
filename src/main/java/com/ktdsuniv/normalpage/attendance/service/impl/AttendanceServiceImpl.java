package com.ktdsuniv.normalpage.attendance.service.impl;

import com.ktdsuniv.normalpage.attendance.biz.AttendanceBiz;
import com.ktdsuniv.normalpage.attendance.service.AttendanceService;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class AttendanceServiceImpl implements AttendanceService {

	AttendanceBiz attendanceBiz;

	public void setAttendanceBiz(AttendanceBiz attendanceBiz) {
		this.attendanceBiz = attendanceBiz;
	}

	@Override
	public void addAttendanceWithBeacon(UsersSchema usersSchema, LecturesSchema lecturesSchema) {
		// TODO Auto-generated method stub
		attendanceBiz.addAttendanceWithBeacon(usersSchema, lecturesSchema);
	}
	
	
	
}
