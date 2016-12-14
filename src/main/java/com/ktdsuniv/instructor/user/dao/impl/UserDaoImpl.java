package com.ktdsuniv.instructor.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	@Override
	public void signUp(UsersSchema user) {
		getMongo().save(user);
	}
	
	@Override
	public String getSalt(UsersSchema user) {
		Criteria criteria = new Criteria("userId");
		criteria.is(user.getUserId());
		
		Query query = new Query(criteria);
		query.fields().include("userSalt");

		return getMongo().findOne(query, UsersSchema.class).getUserSalt();
	}
	
	@Override
	public UsersSchema signIn(UsersSchema user) {
		Criteria criteria = new Criteria("userId");
		criteria.is(user.getUserId());
		criteria = criteria.and("userPassword");
		criteria.is(user.getUserPassword());
		
		Query query = new Query(criteria);
		
		return getMongo().findOne(query, UsersSchema.class);
	}

	@Override
	public UsersSchema getUserInfo(String userId) {
		Criteria criteria = new Criteria("userId");
		criteria.is(userId);
		Query query = new Query(criteria);
		return getMongo().findOne(query, UsersSchema.class);
	}

	@Override
	public int doModifyUserInfoAction(UsersSchema user) {
	
		
		UsersSchema originalUser = getMongo().findById(user.getId(), UsersSchema.class, "users");
		originalUser.setUserName(user.getUserName());
		originalUser.setPhoneNumber(user.getPhoneNumber());
		originalUser.setAddress(user.getAddress());
		originalUser.setModifiedDate(new Date());
		getMongo().save(originalUser);
		return 1;
	}

	@Override
	public List<LecturesSchema> getUserLecture(UsersSchema user) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		Query query = new Query(criteria);
		return getMongo().find(query, LecturesSchema.class, "lectures");
	}
	
}
