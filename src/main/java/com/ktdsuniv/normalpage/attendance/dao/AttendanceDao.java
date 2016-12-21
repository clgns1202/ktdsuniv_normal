package com.ktdsuniv.normalpage.attendance.dao;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface AttendanceDao {
	public void addAttendanceWithBeacon(AttendancesSchema attendance);
}
