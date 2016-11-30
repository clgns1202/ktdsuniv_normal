package com.ktdsuniv.instructor.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.user.service.UserService;

import user.schema.UsersSchema;

@Controller
public class UserController {

	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("/myPage")
	public ModelAndView viewMypage(HttpSession session){
		
		ModelAndView view = new ModelAndView();
		UsersSchema user = userService.getUserInfo(session);
		view.setViewName("/user/myInfo");
		view.addObject("user",user);

		return view;
		
		
	}
}
