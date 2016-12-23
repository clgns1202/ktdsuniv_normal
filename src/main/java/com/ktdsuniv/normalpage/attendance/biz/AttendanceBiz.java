package com.ktdsuniv.normalpage.attendance.biz;

import java.util.Date;
import java.util.List;

import com.ktdsuniv.normalpage.attendance.vo.CheckTime;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface AttendanceBiz {

	public boolean addAttendanceForAndroid(String userId, String lectureId);

	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId);

	public CheckTime getResultForUser(String userId, String lectureId);

}
