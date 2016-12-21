package com.ktdsuniv.normalpage.attendance.biz;

import java.util.List;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface AttendanceBiz {

	public boolean addAttendanceForAndroid(String userId);

	public List<AttendancesSchema> getAttendanceListByUserId(String userId);

}
