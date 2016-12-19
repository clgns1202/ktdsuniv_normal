package com.ktdsuniv.instructor.board.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.board.service.BoardService;

import board.schema.BoardsSchema;
import common.constants.Session;
import user.schema.UsersSchema;

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
		
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		board.setUser(user);
		boolean isSuccess = boardService.addDailyReport(board);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/dailyReport/list");
		return view;
		
	}
	
	@RequestMapping("/dailyReport/list")
	public ModelAndView viewDailyReportsListPage(HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		List<BoardsSchema> boards = boardService.dailyReportsList(user);
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/dailyReport/list");
		view.addObject("boards", boards);
		return view;
	}
	
	@RequestMapping("/dailyReport/detail/{boardId}")
	public ModelAndView viewDailyReportsDetailPage(@PathVariable String boardId) {

		BoardsSchema boards = boardService.dailyReportDetail(boardId);
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/dailyReport/detail");
		view.addObject("boards", boards);
		return view;
	}
	
	@RequestMapping("/dailyReport/doDelete/{boardId}")
	public String doDailyReportDeleteAction(@PathVariable String boardId) {
		boolean isSuccess = boardService.doDailyReportDelete(boardId);
		return "redirect:/dailyReport/list";
	}
}
