package com.ktdsuniv.normalpage.user.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.normalpage.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import grades.schema.TestsSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
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
		logger.debug("안녕하세요 이근재입니다." +userId);
		Criteria criteria = new Criteria("userId");
		criteria.is(userId);
		Query query = new Query(criteria);
		return getMongo().findOne(query, UsersSchema.class, "users");
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
	public int userPasswordModify(UsersSchema user) {
		
		logger.debug("==========================username=============================="+user.getUserName());
		UsersSchema originalUser = getMongo().findById(user.getId(),UsersSchema.class,"users");
		originalUser.setUserName(user.getUserName());
		originalUser.setPhoneNumber(user.getPhoneNumber());
		originalUser.setAddress(user.getAddress());
		originalUser.setModifiedDate(new Date());
		originalUser.setUserPassword(user.getUserPassword());
		originalUser.setUserSalt(user.getUserSalt());
		getMongo().save(originalUser);
		
		return 1;
	}

	@Override
	public int doDeleteUser(UsersSchema user) {
		Criteria criteria = new Criteria("userId");
		criteria.is(user.getUserId());
		Query query = new Query(criteria);
		getMongo().findAndRemove(query, UsersSchema.class);
		return 1;
	}

	@Override
	public List<LecturesSchema> findLectureNameByLectureId(UsersSchema user) {
			 Criteria criteria = new Criteria("user.userId");
			 criteria.is(user.getUserId());
			 Query query = new Query(criteria);
			 List<LecturesSchema> lectures = getMongo().find(query, LecturesSchema.class, "lectures");
		return lectures;
	}
	
	
}
