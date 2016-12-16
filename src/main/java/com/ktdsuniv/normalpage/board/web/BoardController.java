package com.ktdsuniv.normalpage.board.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.normalpage.board.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
}
