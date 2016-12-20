package com.ktdsuniv.instructor.board.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public boolean addDailyReport(BoardsSchema board) {
		
		return boardDao.addDailyReport(board) > 0;
		
	}

	@Override
	public List<BoardsSchema> dailyReportsList(UsersSchema user) {
		return boardDao.dailyReportsList(user);
	}

	@Override
	public BoardsSchema dailyReportDetail(String boardId) {
		return boardDao.dailyReportDetail(boardId);
	}

	@Override
	public boolean dailyReportDelete(String boardId) {
		return boardDao.dailyReportDelete(boardId) > 0;
	}

}
