package com.ktdsuniv.normalpage.board.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;
import user.schema.UsersSchema;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
	public int addDailyReport(BoardsSchema board) {
		getMongo().insert(board);
		return 1;
	}

	@Override
	public List<BoardsSchema> dailyReportsList(UsersSchema user) {
		
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		
		Query query = new Query(criteria);
		
		return getMongo().find(query, BoardsSchema.class);
	}

	@Override
	public BoardsSchema dailyReportDetail(String boardId) {
		
		Criteria criteria = new Criteria("id");
		criteria.is(boardId);
		
		Query query = new Query(criteria);
		
		return getMongo().findOne(query, BoardsSchema.class);
	}

	@Override
	public int dailyReportDelete(String boardId) {
		
		Criteria criteria = new Criteria("id");
		criteria.is(boardId);
		Query query = new Query(criteria);
		getMongo().remove(query, BoardsSchema.class);
		return 1;
	}

	

}
