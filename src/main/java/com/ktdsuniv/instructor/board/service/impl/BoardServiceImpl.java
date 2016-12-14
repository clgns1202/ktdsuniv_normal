package com.ktdsuniv.instructor.board.service.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.service.BoardService;

import board.schema.BoardsSchema;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public boolean addDailyReport(BoardsSchema board, HttpSession session) {
		return boardBiz.addDailyReport(board);
	}
	
}
