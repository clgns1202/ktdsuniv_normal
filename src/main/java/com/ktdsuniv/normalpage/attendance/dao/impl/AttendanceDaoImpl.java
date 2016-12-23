package com.ktdsuniv.normalpage.attendance.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.normalpage.attendance.dao.AttendanceDao;

import attendance.schema.AttendancesSchema;
import common.support.mongo.MongoTemplateSupport;

public class AttendanceDaoImpl extends MongoTemplateSupport implements AttendanceDao{

	@Override
	public boolean addAttendanceForAndroid(AttendancesSchema attendance) {		
		getMongo().save(attendance);
		return true;
	}
	

	@Override
	public List<AttendancesSchema> getAttendanceListByUserId(String userId) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("usersSchema.userId");
		criteria.is(userId);
		Query query = new Query(criteria);
		
		return getMongo().find(query, AttendancesSchema.class, "attendances");
	}



	@Override
	public List<AttendancesSchema> getAttendanceListByNowDate(String userId, String lectureId, String nowDate) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("userId");
		criteria.is(userId);
		criteria = criteria.and("nowDate");
		criteria.is(nowDate);
		criteria = criteria.and("lectureId");
		criteria.is(lectureId);
		
		Query query = new Query(criteria);
		return getMongo().find(query, AttendancesSchema.class, "attendances");
	}


	@Override
	public List<AttendancesSchema> getAttendanceListByUserIdLectureId(String userId, String lectureId) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("userId");
		criteria.is(userId);
		criteria = criteria.and("lectureId");
		criteria.is(lectureId);
		
		Query query = new Query(criteria);
		
		return getMongo().find(query, AttendancesSchema.class, "attendances");
	}
	
}
