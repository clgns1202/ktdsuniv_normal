package com.ktdsuniv.normalpage.attendance.dao;

import java.util.List;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface AttendanceDao {
		
	public List<AttendancesSchema> getAttendanceListByNowDate(String userId, String lectureId, String nowDate);
	
	public List<AttendancesSchema> getAttendanceListByUserId(String userId);

	public boolean addAttendanceForAndroid(AttendancesSchema attendance);

	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId);

	
}
