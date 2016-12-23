package com.ktdsuniv.normalpage.board.biz.impl;

import java.util.List;

import com.ktdsuniv.normalpage.board.biz.BoardBiz;
import com.ktdsuniv.normalpage.board.dao.BoardDao;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void addStudyNote(BoardsSchema board) {
		String content = board.getContent();
		content = content.replaceAll("\n", "<br/>");
		content = content.replaceAll("\n", "");
		board.setContent(content);
		boardDao.addStudyNote(board);
	}

	@Override
	public List<BoardsSchema> getMyStudyNote(UsersSchema user) {
		return boardDao.getMyStudyNote(user);
	}

	@Override
	public BoardsSchema getIdBoardBy(String id) {
		return boardDao.getIdBoardBy(id);
	}

	@Override
	public boolean addDailyReport(BoardsSchema board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardsSchema> dailyReportsList(UsersSchema user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardsSchema dailyReportDetail(String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dailyReportDelete(String boardId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
