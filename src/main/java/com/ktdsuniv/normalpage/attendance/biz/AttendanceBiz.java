package com.ktdsuniv.normalpage.attendance.biz;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface AttendanceBiz {

	public void addAttendanceWithBeacon(UsersSchema usersSchema, LecturesSchema lecturesSchema);

}
