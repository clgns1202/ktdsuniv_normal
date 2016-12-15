package com.ktdsuniv.instructor.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/writeStudyNote")
	public ModelAndView viewAddStudyNotePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("studyNote/writeStudyNote");
		return view;
	}
	
}
