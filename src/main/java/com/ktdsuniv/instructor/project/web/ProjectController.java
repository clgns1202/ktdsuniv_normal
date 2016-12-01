package com.ktdsuniv.instructor.project.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.lecture.service.LectureService;
import com.ktdsuniv.instructor.project.service.ProjectService;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import project.schema.ProjectsSchema;
import user.schema.UsersSchema;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private ProjectService projectService;
	private LectureService lectureService;
	private UserService userService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	
	
	@RequestMapping("/")
	public ModelAndView viewProjectPage(){
		ModelAndView view = new ModelAndView();

		List<ProjectsSchema> projects = projectService.getAllProjects();
		view.addObject("projects", projects);
		view.setViewName("/project/project");
		return view;
	}
	@RequestMapping("/addProject")
	public ModelAndView viewAddProjectPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/project/addProject");
		
		return view;
	}
	@RequestMapping("/doAddProject")
	public String doAddProjectAction(ProjectsSchema project){
		projectService.addProject(project);
		
		return "redirect:/project/";
	}
	@RequestMapping("/detailProject/{id}")
	public ModelAndView viewDetialProjectPage(@PathVariable String id){
		ModelAndView view = new ModelAndView();
		
		ProjectsSchema projectVO = projectService.getProjectBy(id);
		
		view.setViewName("/project/detailProject");
		view.addObject("projectVO", projectVO);
		
		return view;
	}
	@RequestMapping("/modifyProject/{id}")
	public ModelAndView viewModifyProjectPage(@PathVariable String id, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		ProjectsSchema project = projectService.getProjectBy(id);
		
		UsersSchema user = new UsersSchema();
		user.setAddress("test");
		user.setId("test");
		
		view.setViewName("/project/modifyProject");
		if(user.getId().equals(project.getUser().getId())) {
			view.addObject("projectVO", project);
		}
		
		return view;
	}
	@RequestMapping("/doModifyProject/{id}")
	public String doModifyProjectAction(@PathVariable String id, HttpSession session){
		UsersSchema user = new UsersSchema();
		user.setAddress("test");
		user.setId("test");
		
		session.setAttribute(Session.USER, user);
		projectService.modifyProject(id, session);
		
		return "redirect:/project/";
	}
	@RequestMapping("/doDeleteProject/{id}")
	public String doAddProjectAction(@PathVariable String id, HttpSession session){
		
		UsersSchema user = new UsersSchema();
		user.setAddress("test");
		user.setId("test");
		
		session.setAttribute(Session.USER, user);
		
		projectService.deleteProject(id, session);
		
		
		return "redirect:/project/";
	}
	
	
}
