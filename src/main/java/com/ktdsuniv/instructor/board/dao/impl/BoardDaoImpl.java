package com.ktdsuniv.instructor.board.dao.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;
import common.support.mongo.MongoTemplateSupport;

public class BoardDaoImpl extends MongoTemplateSupport implements BoardDao {

	@Override
	public int addDailyReport(BoardsSchema board, String userId) {
		getMongo().insert(board, userId);
		return 1;
	}


}
