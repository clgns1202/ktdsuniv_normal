package com.ktdsuniv.normalpage.attendance.biz.impl;

import com.ktdsuniv.normalpage.attendance.biz.AttendanceBiz;
import com.ktdsuniv.normalpage.attendance.dao.AttendanceDao;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class AttendanceBizImpl implements AttendanceBiz{

	AttendanceDao attendanceDao;

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao= attendanceDao;
	}

	public void addAttendanceWithBeacon(UsersSchema usersSchema, LecturesSchema lecturesSchema) {
		AttendancesSchema attendance = new AttendancesSchema();
		attendance.setUsersSchema(usersSchema);
		attendance.setLecturesSchema(lecturesSchema);
		
		
		attendanceDao.addAttendanceWithBeacon(attendance);
	}

	
	
	
	
}
