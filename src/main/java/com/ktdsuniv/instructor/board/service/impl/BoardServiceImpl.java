package com.ktdsuniv.instructor.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.service.BoardService;

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

	
}
