package com.ktdsuniv.instructor.lecture.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureDaoImpl extends MongoTemplateSupport implements LectureDao {

	@Override
	public List<LecturesSchema> getLecturesByUserId(String userId) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(userId);
		Query query = new Query(criteria);
		return getMongo().find(query, LecturesSchema.class, "lectures");				
	}
	
	@Override
	public int doApplyLecture(String lectureId, UsersSchema users) {
		Criteria criteria = new Criteria("_id");
		criteria.is(lectureId);
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.addToSet("user", users);
		
		getMongo().updateFirst(query, update, "lectures");
		
		return 1;
	}
	
	@Override
	public int doApplyCancleLecture(String lectureId, UsersSchema users) {
		Criteria criteria = new Criteria("_id");
		criteria.is(lectureId);
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.pull("user", users);
		
		getMongo().updateFirst(query, update, "lectures");
		return 1;
	}
	
}
