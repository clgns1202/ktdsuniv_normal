package com.ktdsuniv.normalpage.board.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.normalpage.board.dao.BoardDao;

import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;
import user.schema.UsersSchema;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
	public void addStudyNote(BoardsSchema board) {
		getMongo().save(board);	
	}

	
	@Override
	public List<BoardsSchema> getMyStudyNote(UsersSchema user) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		
		Query query = new Query(criteria);
		return getMongo().find(query, BoardsSchema.class);
	}

	@Override
	public BoardsSchema getIdBoardBy(String id) {
		return getMongo().findById(id, BoardsSchema.class);
	}

}
