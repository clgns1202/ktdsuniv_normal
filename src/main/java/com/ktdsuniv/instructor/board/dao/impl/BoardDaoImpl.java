package com.ktdsuniv.instructor.board.dao.impl;

import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
	public void addStudyNote(BoardsSchema board) {
		getMongo().save(board);	
	}

}
