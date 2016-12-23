package com.ktdsuniv.normalpage.board.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.normalpage.board.biz.BoardBiz;
import com.ktdsuniv.normalpage.board.service.BoardService;

import board.schema.BoardsSchema;
import common.constants.Session;
import user.schema.UsersSchema;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public boolean addDailyReport(BoardsSchema board) {
		
		
		return boardBiz.addDailyReport(board);
		
	}

	@Override
	public List<BoardsSchema> dailyReportsList(UsersSchema user) {
		return boardBiz.dailyReportsList(user);
	}

	@Override
	public BoardsSchema dailyReportDetail(String boardId) {
		return boardBiz.dailyReportDetail(boardId);
	}

	@Override
	public boolean doDailyReportDelete(String boardId) {
		return boardBiz.dailyReportDelete(boardId);
	}

	public void addStudyNote(BoardsSchema board, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		board.setUser(user);
		board.setCreatedDate(new Date());
		boardBiz.addStudyNote(board);
	}
	
	@Override
	public List<BoardsSchema> getMyStudyNote(HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		
		return boardBiz.getMyStudyNote(user);
	}

	@Override
	public BoardsSchema getIdBoardBy(String id) {
		return boardBiz.getIdBoardBy(id);
	}
	
}
