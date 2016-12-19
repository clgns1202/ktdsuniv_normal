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
import lecture.schema.LecturesSchema;
import project.schema.ProjectsSchema;
import project.schema.TeamsSchema;
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
	
	
	
	@RequestMapping("/{lectureId}")
	public ModelAndView viewProjectPage(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();

		List<ProjectsSchema> projects = projectService.getAllProjects(lectureId);
		view.addObject("projects", projects);
		view.addObject("lectureId",lectureId);
		view.setViewName("/project/project");
		return view;
	}
	@RequestMapping("/addProject/{lectureId}")
	public ModelAndView viewAddProjectPage(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lectures = projectService.getAllUserName(lectureId);
		
		view.addObject("lectureId",lectureId);
		view.addObject("lectures",lectures);
		view.setViewName("/project/addProject");
		
		//List<TeamsSchema> teams = projectService.getAllTeams();
		
		return view;
	}
	@RequestMapping("/doAddProject/{lectureId}")
	public String doAddProjectAction(ProjectsSchema project, HttpSession session, @PathVariable String lectureId){
		projectService.addProject(project,session, lectureId);
		
		return "redirect:/project/{lectureId}";
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
	public String doModifyProjectAction(ProjectsSchema project, @PathVariable String id, HttpSession session){
		
		projectService.modifyProject(project, id, session);
		
		return "redirect:/project/{id}";
	}
	@RequestMapping("/doDeleteProject/{id}/{lectureId}")
	public String doAddProjectAction(@PathVariable String id, HttpSession session, @PathVariable String lectureId){
		
		
		projectService.deleteProject(id, session);
		
		
		return "redirect:/project/{lectureId}";
	}
	
	
}
