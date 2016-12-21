package com.ktdsuniv.normalpage.attendance.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktdsuniv.normalpage.attendance.service.AttendanceService;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public class AttendanceController {

	AttendanceService attendanceService;

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@RequestMapping("/checkAttendance")
	public void doCheckAttendancePage(UsersSchema usersSchema, LecturesSchema lecturesSchema){
		attendanceService.addAttendanceWithBeacon(usersSchema,lecturesSchema);
	}
	
}
