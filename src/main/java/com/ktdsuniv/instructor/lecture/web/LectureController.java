package com.ktdsuniv.instructor.lecture.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniv.instructor.lecture.service.LectureService;

import lecture.schema.LecturesSchema;
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
	private Logger logger = LoggerFactory.getLogger(LectureController.class);
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@RequestMapping("/doLecturesForAndroid")
	@ResponseBody
	public List<LecturesSchema> doLectureForAndroid(@RequestParam String userId/*UsersSchema user*/){
		logger.debug("=========================================="+userId);
		List<LecturesSchema> lectureList = lectureService.getLecturesByUserId(userId);
		return lectureList;
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
	public ModelAndView viewDetailLecture(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLecture(lectureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/detail");
		return view;
	}
	
	@RequestMapping("/lecture/apply/{lectureId}")
	public ModelAndView doApplylecture(@PathVariable String lectureId, HttpSession session){
		ModelAndView view = new ModelAndView();
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
