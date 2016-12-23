package com.ktdsuniv.normalpage.attendance.biz.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.attendance.biz.AttendanceBiz;
import com.ktdsuniv.normalpage.attendance.dao.AttendanceDao;
import com.ktdsuniv.normalpage.attendance.vo.CheckTime;
import com.ktdsuniv.normalpage.lecture.dao.LectureDao;
import com.ktdsuniv.normalpage.user.dao.UserDao;

import attendance.schema.AttendancesSchema;

public class AttendanceBizImpl implements AttendanceBiz{

	AttendanceDao attendanceDao;
	LectureDao lectureDao;
	UserDao userDao;

	Logger log = LoggerFactory.getLogger(AttendanceBizImpl.class);
	
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao= attendanceDao;
	}


	@Override
	public boolean addAttendanceForAndroid(String userId, String lectureId) {
		AttendancesSchema attendance = new AttendancesSchema();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		attendance.setUserId(userId);
		attendance.setLectureId(lectureId);
		attendance.setNowDate(sdf.format(new Date()));
		attendance.setDateTime(new Date());
		
		List<AttendancesSchema> attendancesList = attendanceDao.getAttendanceListByNowDate(userId, lectureId, attendance.getNowDate());		
		int listCount = attendancesList.size();
		log.debug("날짜와 유저 아이디로 검색한 다큐먼트의 개수: "+listCount);
		
		Date join = new Date();
		Date out = new Date();
		join.setHours(9);
		out.setHours(18);
		
		if(listCount==0){
			if(attendance.getDateTime().before(join)){attendance.setResult("입실");}
			else if(attendance.getDateTime().after(join) && attendance.getDateTime().before(out)){attendance.setResult("지각");}
			else{attendance.setResult("결석");}
		}		
		else if(listCount==1){
			if(attendance.getDateTime().before(out)){attendance.setResult("조퇴");}		
			else if(attendance.getDateTime().after(out)){attendance.setResult("퇴실");}
		}
		else if(listCount >= 2){
			return false;
		}else{
			attendance.setResult("기타");			
		}
		
		return attendanceDao.addAttendanceForAndroid(attendance);
	}

	@Override
	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttendanceListByUserIdLectureId(userId,lectureId);
	}


	@Override
	public CheckTime getResultForUser(String userId, String lectureId) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeForm = new SimpleDateFormat("HHmmSS");
		
		String nowDate = sdf.format(new Date());
		List<AttendancesSchema> attendanceList = attendanceDao.getAttendanceListByNowDate(userId, lectureId, nowDate);
		List<String> myTime = new ArrayList<String>();
		
		for(AttendancesSchema attendance:attendanceList){
			myTime.add(timeForm.format(attendance.getDateTime()));
		}
		
		CheckTime checkTime = new CheckTime();
		checkTime.setCheckTime(myTime);
		return checkTime;
	}
}

