package com.ktdsuniv.normalpage.attendance.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public interface AttendanceService {

	public void addAttendanceWithBeacon(UsersSchema usersSchema, LecturesSchema lecturesSchema);


}
