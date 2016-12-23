package com.ktdsuniv.normalpage.attendance.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktdsuniv.normalpage.attendance.vo.CheckTime;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public interface AttendanceService {

	public boolean addAttendanceForAndroid(String userId, String lectureId);

	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId);

	public CheckTime getResultForUser(String userId, String lectureId);
}
