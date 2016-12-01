package com.ktdsuniv.instructor.project.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.service.ProjectService;

import common.constants.Session;
import project.schema.ProjectsSchema;
import user.schema.UsersSchema;

public class ProjectServiceImpl implements ProjectService{

	private ProjectBiz projectBiz;
	private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}

	@Override
	public void addProject(ProjectsSchema project) {
		project.setCreatedDate(new Date());
		projectBiz.addProject(project);
	}

	@Override
	public List<ProjectsSchema> getAllProjects() {
		
		return projectBiz.getAllProjects();
	}

	@Override
	public ProjectsSchema getProjectBy(String id) {
		return projectBiz.getProjectBy(id);
	}

	@Override
	public boolean deleteProject(String id, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		
		ProjectsSchema project = projectBiz.getProjectBy(id);
		logger.info("세션 아이디" + user.getId());
		logger.info("프로젝트 유저 아이디"+project.getUser().getId());
		if(user.getId().equals(project.getUser().getId())) {
			return projectBiz.deleteProject(id);
		}
		return false;
	}

	@Override
	public boolean modifyProject(String id, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		
		ProjectsSchema project = projectBiz.getProjectBy(id);
		if(user.getId().equals(project.getUser().getId())) {
			return projectBiz.modifyProject(id);
		}
		return false;
	}
	
}
