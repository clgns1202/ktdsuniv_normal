package com.ktdsuniv.instructor.user.web;

import javax.servlet.http.HttpSession;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.user.service.UserService;

import user.schema.UsersSchema;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("/user/myInfo")
	public ModelAndView viewMypage(HttpSession session){
		
		ModelAndView view = new ModelAndView();
		UsersSchema user = userService.getUserInfo(session);
		
		
		view.setViewName("/user/myInfo");
		view.addObject("user",user);

		return view;
	}
		
	@RequestMapping("/signUp")
	public ModelAndView viewSignUpPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/signUp");
		return view;
	}	
	
	@RequestMapping("/doSignUp")
	public String doSignUpAction(UsersSchema user){
		userService.signUp(user);
		
		return "redirect:/signIn";
	}
	
	@RequestMapping("/signIn")
	public ModelAndView viewSignInpage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("user/signIn");
		return view;
	}
	
	@RequestMapping("/doSignIn")
	public String doSignInAction(UsersSchema user, HttpSession session){
		
		userService.signIn(user, session);
		return "redirect:/main";
		
	}
	
	@RequestMapping("/signOut")
	public String doSignOutAction(HttpSession session){
		session.invalidate();
		return "user/signIn";
	}
	

	
	
	
}
