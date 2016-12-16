package com.ktdsuniv.instructor.lecture.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureDaoImpl extends MongoTemplateSupport implements LectureDao {

	@Override
	public List<LecturesSchema> getLecturesByUserId(String userId) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("user.userId");
		criteria.is(userId);
		Query query = new Query(criteria);
		return getMongo().find(query, LecturesSchema.class, "lectures");				
	}
}
