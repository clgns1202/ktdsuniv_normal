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
	
}
