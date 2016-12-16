package com.ktdsuniv.normalpage.board.service.impl;

import com.ktdsuniv.normalpage.board.biz.BoardBiz;
import com.ktdsuniv.normalpage.board.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
}
