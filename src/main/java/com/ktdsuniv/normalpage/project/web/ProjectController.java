package com.ktdsuniv.normalpage.project.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.normalpage.lecture.service.LectureService;
import com.ktdsuniv.normalpage.project.service.ProjectService;
import com.ktdsuniv.normalpage.user.service.UserService;

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
	public String doAddProjectAction(ProjectsSchema project, HttpSession session){
		projectService.addProject(project,session);
		
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
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		
		ProjectsSchema project = projectService.getProjectBy(id);
		
		view.setViewName("/project/modifyProject");
		if(user.getId().equals(project.getUser().getId())) {
			view.addObject("projectVO", project);
		}
		
		return view;
	}
	@RequestMapping("/doModifyProject/{id}")
	public String doModifyProjectAction(ProjectsSchema project){
		
		projectService.modifyProject(project);
		
		return "redirect:/project/";
	}
	@RequestMapping("/doDeleteProject/{id}")
	public String doAddProjectAction(@PathVariable String id, HttpSession session){
		
		projectService.deleteProject(id, session);
		
		
		return "redirect:/project/";
	}
	
	
}
