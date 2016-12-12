package com.ktdsuniv.instructor.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.board.service.BoardService;

import board.schema.BoardsSchema;

@Controller
public class BoardController {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/dailyReport/addDailyReport")
	public String addDailyReportsPage() {
		return "dailyReport/addDailyReport";
	}
	
	@RequestMapping("/dailyReport/doAddDailyReport")
	public ModelAndView doAddDailyReportsAction(BoardsSchema board, HttpSession session) {
		
		boolean isSuccess = boardService.addDailyReport(board, session);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/dailyReport/list");
		return view;
		
	}
	
}
