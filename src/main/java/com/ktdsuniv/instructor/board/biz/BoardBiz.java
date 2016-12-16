package com.ktdsuniv.instructor.board.biz;

import javax.servlet.http.HttpSession;

import board.schema.BoardsSchema;

public interface BoardBiz {

	public boolean addDailyReport(BoardsSchema board, String userId);


}
