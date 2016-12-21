package com.ktdsuniv.normalpage.attendance.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import attendance.schema.AttendancesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public interface AttendanceService {

	public boolean addAttendanceForAndroid(String userId);

	public List<AttendancesSchema> getAttendanceListByUserId(String userId);

}
