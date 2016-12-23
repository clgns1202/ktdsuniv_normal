package com.ktdsuniv.normalpage.attendance.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniv.normalpage.attendance.service.AttendanceService;
import com.ktdsuniv.normalpage.attendance.vo.CheckTime;

import attendance.schema.AttendancesSchema;

@Controller
public class AttendanceController {

	AttendanceService attendanceService;

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@RequestMapping("/addAttendanceForAndroid")
	@ResponseBody
	public boolean doCheckAttendancePage(String userId, String lectureId){
		
		return attendanceService.addAttendanceForAndroid(userId, lectureId);
	}
	
	@RequestMapping("/getAttendanceList")
	@ResponseBody
	public List<AttendancesSchema> getAttendanceListPage(String userId, String lectureId){
		return attendanceService.getAttendanceListByUserIdLectureId(userId, lectureId);
	}
	
	@RequestMapping("/getResultForUser")
	@ResponseBody
	public CheckTime getResultForUserPage(String userId, String lectureId){
		return attendanceService.getResultForUser(userId, lectureId);
	}
	
}
