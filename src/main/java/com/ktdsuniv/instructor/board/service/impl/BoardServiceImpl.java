package com.ktdsuniv.instructor.board.service.impl;

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
	public boolean addDailyReport(BoardsSchema board, HttpSession session) {
		
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		String userId = user.getUserId();
		
		return boardBiz.addDailyReport(board, userId);
		
	}
	
}
