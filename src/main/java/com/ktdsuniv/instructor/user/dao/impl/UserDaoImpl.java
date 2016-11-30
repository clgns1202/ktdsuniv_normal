package com.ktdsuniv.instructor.user.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	@Override
	public void signUp(UsersSchema user) {
		getMongo().save(user);
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
	
}
