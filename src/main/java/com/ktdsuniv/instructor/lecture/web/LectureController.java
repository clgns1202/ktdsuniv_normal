package com.ktdsuniv.instructor.lecture.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.lecture.service.LectureService;

import common.constants.Session;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public class LectureController {

	private LectureService lectureService;
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	
	/*
	 * 강의 신청을 위해 강의 리스트를 가져온다.
	 */
	@RequestMapping("/lecture/list")
	public ModelAndView viewLectureList(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO lectureList = lectureService.getLectureList(search);
		
		PageExplorer explorer = new ClassicPageExplorer(lectureList.getPager());
		String pager = explorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("lectureList", lectureList);
		view.addObject("paging", pager);
		view.setViewName("lecture/list");
		return view;
	}
	
	@RequestMapping("/lecture/detail/{lectureId}")
	public ModelAndView viewDetailLecture(@PathVariable String lectureId, HttpSession session){
		ModelAndView view = new ModelAndView();
		UsersSchema user = new UsersSchema();
		user.setUserName("test");
		session.setAttribute(Session.USER, user);
		LecturesSchema lecture = lectureService.getDetailLecture(lectureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/detail");
		return view;
	}
	
	@RequestMapping("/lecture/apply/{lectureId}")
	public ModelAndView doApplylecture(@PathVariable String lectureId, HttpSession session){
		ModelAndView view = new ModelAndView();
		UsersSchema user = new UsersSchema();
		user.setUserName("test");
		session.setAttribute(Session.USER, user);
		boolean isSuccess= lectureService.doApplyLecture(lectureId, session);
		view.setViewName("redirect:/lecture/detail/"+lectureId);
		return view;
	}
	
	@RequestMapping("/lecture/applyCancel/{lectureId}")
	public ModelAndView doApplyCancleLecture(@PathVariable String lectureId, HttpSession session){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = lectureService.doApplyCancleLecture(lectureId, session);
		view.setViewName("redirect:/lecture/detail/"+lectureId);
		return view;
	}
	
	
}
