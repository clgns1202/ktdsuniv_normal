package com.ktdsuniv.instructor.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.board.service.BoardService;

import board.schema.BoardsSchema;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/studyNote/write")
	public ModelAndView viewStudyNoteWritePage(HttpSession session) {
		ModelAndView view = new ModelAndView();
		view.setViewName("studyNote/write");
		return view;
	}
	
	@RequestMapping("/studyNote/doWrite")
	public String doWriteStudyNoteAction(BoardsSchema board, HttpSession session){
		boardService.addStudyNote(board,session);
		return "redirect:list";
	}
	
	/**
	 * 
	 * @return
	 
	@RequestMapping("/studyNote/list")
	public ModelAndView viewStudyNotelistPage() {
	}
	*/
}
