package com.ktdsuniv.normalpage.board.dao.impl;

import java.util.List;
<<<<<<< HEAD

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.board.dao.BoardDao;

=======

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.normalpage.board.dao.BoardDao;

>>>>>>> f755904bd48e68ce7698a12ae3e8c32f83bd45c2
import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;
import user.schema.UsersSchema;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
<<<<<<< HEAD
	public int addDailyReport(BoardsSchema board) {
		getMongo().insert(board);
		return 1;
	}

	@Override
	public List<BoardsSchema> dailyReportsList(UsersSchema user) {
		
=======
	public void addStudyNote(BoardsSchema board) {
		getMongo().save(board);	
	}

	
	@Override
	public List<BoardsSchema> getMyStudyNote(UsersSchema user) {
>>>>>>> f755904bd48e68ce7698a12ae3e8c32f83bd45c2
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		
		Query query = new Query(criteria);
<<<<<<< HEAD
		
=======
>>>>>>> f755904bd48e68ce7698a12ae3e8c32f83bd45c2
		return getMongo().find(query, BoardsSchema.class);
	}

	@Override
<<<<<<< HEAD
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

	

=======
	public BoardsSchema getIdBoardBy(String id) {
		return getMongo().findById(id, BoardsSchema.class);
	}

>>>>>>> f755904bd48e68ce7698a12ae3e8c32f83bd45c2
}
