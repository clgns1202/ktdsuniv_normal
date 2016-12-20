package com.ktdsuniv.normalpage.board.dao.impl;

import com.ktdsuniv.normalpage.board.dao.BoardDao;

import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
	public void addStudyNote(BoardsSchema board) {
		getMongo().save(board);	
	}

}
