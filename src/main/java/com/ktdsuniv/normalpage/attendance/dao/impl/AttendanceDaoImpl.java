package com.ktdsuniv.normalpage.attendance.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.normalpage.attendance.dao.AttendanceDao;

import attendance.schema.AttendancesSchema;
import common.support.mongo.MongoTemplateSupport;
import common.util.SHA256Util;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class AttendanceDaoImpl extends MongoTemplateSupport implements AttendanceDao{

	@Override
	public void addAttendanceWithBeacon(AttendancesSchema attendance) {
		getMongo().save(attendance);
	}

}
