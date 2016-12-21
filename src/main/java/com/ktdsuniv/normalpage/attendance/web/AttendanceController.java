package com.ktdsuniv.normalpage.attendance.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniv.normalpage.attendance.service.AttendanceService;

import attendance.schema.AttendancesSchema;

@Controller
public class AttendanceController {

	AttendanceService attendanceService;

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@RequestMapping("/addAttendanceForAndroid")
	@ResponseBody
	public boolean doCheckAttendancePage(){
		
		return attendanceService.addAttendanceForAndroid("55");
	}
	
	@RequestMapping("/getAttendanceList")
	@ResponseBody
	public List<AttendancesSchema> getAttendanceListPage(String userId){
		userId = "55";
		return attendanceService.getAttendanceListByUserId(userId);
	}
}
