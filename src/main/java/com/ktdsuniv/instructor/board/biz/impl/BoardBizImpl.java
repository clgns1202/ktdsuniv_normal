package com.ktdsuniv.instructor.board.biz.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public boolean addDailyReport(BoardsSchema board, String userId) {
		
		return boardDao.addDailyReport(board, userId) > 0;
		
	}

	
	
}
