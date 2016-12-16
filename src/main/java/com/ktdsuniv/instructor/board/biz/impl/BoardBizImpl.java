package com.ktdsuniv.instructor.board.biz.impl;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.dao.BoardDao;

import board.schema.BoardsSchema;

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
	
}
