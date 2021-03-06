package com.ktdsuniv.normalpage.user.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.normalpage.lecture.service.LectureService;
import com.ktdsuniv.normalpage.user.service.UserService;

import common.constants.Session;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	private LectureService lectureService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}

	@RequestMapping("/test")
	public String test() {
		return "/test";
	}

	@RequestMapping("/user/myInfo")
	public ModelAndView viewMypage(HttpSession session) {

		ModelAndView view = new ModelAndView();
		UsersSchema user = userService.getUserInfo(session);

		view.setViewName("/myInfo/myInfo");
		view.addObject("user", user);

		return view;
	}

	@RequestMapping("/signUp")
	public ModelAndView viewSignUpPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/signUp");
		return view;
	}

	@RequestMapping("/doSignUp")
	public String doSignUpAction(UsersSchema user) {
		userService.signUp(user);

		return "redirect:/signIn";
	}
	
	@RequestMapping("/doSignInForAndroid")
	@ResponseBody
	public UsersSchema doSignUpAction(UsersSchema user, HttpSession session){
		UsersSchema userInfo = userService.signInForAndroid(user, session);
		return userInfo;
	}
	
	
	@RequestMapping("/signIn")
	public ModelAndView viewSignInpage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("user/signIn");
		return view;
	}

	@RequestMapping("/doSignIn")
	public String doSignInAction(UsersSchema user, HttpSession session) {

		userService.signIn(user, session);
		return "redirect:/user/myInfo";

	}

	@RequestMapping("/signOut")
	public String doSignOutAction(HttpSession session) {
		session.invalidate();
		return "user/signIn";
	}

	@RequestMapping("/user/userInfo/viewUserModifyPage")
	public ModelAndView viewUserModifyPage(HttpSession session) {
		UsersSchema user = userService.getUserInfo(session);
		ModelAndView view = new ModelAndView();
		view.setViewName("/myInfo/userInfoModify");
		view.addObject("user", user);
		return view;
	}

	@RequestMapping("/user/userInfo")
	public ModelAndView viewUserInfoPage(HttpSession session) {

		UsersSchema user = userService.getUserInfo(session);
		List<LecturesSchema> lectures = userService.findLectureNameByLectureId(user);
		logger.debug("=============== 유저정보" + user.getUserId());
		ModelAndView view = new ModelAndView();
		view.setViewName("/myInfo/userInfo");
		view.addObject("user", user);
		view.addObject("lectures", lectures);
		return view;
	}

	@RequestMapping("/user/doUserInfoModify")
	public String doModifyUserInfoAction(UsersSchema user) {
		boolean modifyResult = userService.doModifyUserInfoAction(user);
		if (modifyResult) {
			return "redirect:/user/userInfo";
		}
		return "redirect:/user/viewUserModifyPage?errorCode=1";
	}

	@RequestMapping("/user/userPassword")
	public String viewUserPasswordConfirm() {
		return "/myInfo/userPassword";
	}

	@RequestMapping("/user/userPasswordConfirm")
	@ResponseBody
	public boolean doUserPasswordConfirm(@RequestParam String userPassword, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		user.setUserPassword(userPassword);
		boolean isSuccess = userService.signIn(user, session);
		return isSuccess;
	}

	@RequestMapping("/user/userPasswordModify")
	@ResponseBody
	public boolean doUserPasswordModify(@RequestParam String userPassword, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		user.setUserPassword(userPassword);
		boolean isSuccess = userService.userPasswordModify(user);
		return isSuccess;
	}

	@RequestMapping("/user/userLecture")
	public ModelAndView viewLecturePage(HttpSession session) {

		List<LecturesSchema> lectures = userService.getUserLecture(session);

		ModelAndView view = new ModelAndView();
		view.setViewName("/myInfo/userLecture");
		view.addObject("lectures", lectures);
		return view;
	}
	
	@RequestMapping("/user/lectureInfo")
	@ResponseBody
	public LecturesSchema getLectureInfo(HttpSession session){
		List<LecturesSchema> lectures = userService.getUserLecture(session);
		if(lectures.size() != 0 && lectures != null){
			return lectures.get(0);
		}else{
			return null;
		}
	}

	@RequestMapping("/user/userInfo/withDrawal")
	public String userWithdrawal() {
		return "/myInfo/userWithdrawal";
	}

	@RequestMapping("/user/doUserWithdrawal")
	public String doUserWithDrawal(HttpSession session) {

		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);

		boolean isSuccess = userService.doDeleteUser(user);

		if (isSuccess == true) {
			return "redirect:/signIn";
		} else {
			return "redirect:/user/withDrawal?errorCode=1";
		}
	}

	@RequestMapping("/user/myLectureInfo/{lectureId}")
	public ModelAndView myLectureInfo(@PathVariable String lectureId,HttpSession session){
		UsersSchema user = (UsersSchema)session.getAttribute(Session.USER);
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLecture(lectureId);
		view.setViewName("/myInfo/myLectureInfo");
		view.addObject("lecture",lecture);
		view.addObject("user",user);
		return view;
		
	}
	
	
}
