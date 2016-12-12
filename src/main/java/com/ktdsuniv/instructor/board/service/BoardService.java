package com.ktdsuniv.instructor.board.service;

import javax.servlet.http.HttpSession;

import board.schema.BoardsSchema;

public interface BoardService {

	public boolean addDailyReport(BoardsSchema board, HttpSession session);

}
