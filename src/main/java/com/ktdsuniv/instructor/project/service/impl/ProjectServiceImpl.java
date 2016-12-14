package com.ktdsuniv.instructor.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.service.ProjectService;

import common.constants.Session;
import common.mongo.biz.CommonBiz;
import lecture.schema.LecturesSchema;
import project.schema.ProjectsSchema;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public class ProjectServiceImpl implements ProjectService{

	private ProjectBiz projectBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

	private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}

	@Override
	public void addProject(ProjectsSchema project, HttpSession session, String lectureId) {
		project.setCreatedDate(new Date());
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		project.setUser(user);
		LecturesSchema lecture = commonBiz.getMongoById("_id", lectureId, LecturesSchema.class);
		project.setLecture(lecture);
		logger.debug("�봽濡쒖젥�듃�쑀���젙蹂�"+user);
	/*	
		TeamsSchema teams = new TeamsSchema();
		List<UsersSchema> users = new ArrayList<UsersSchema>();
		
		for (UsersSchema usersSchema : users) {
			if (usersSchema.getUserName() == user.getUserName() ){
				project.setTeam(teams);
			}
		}*/
		
		projectBiz.addProject(project);
	}

	@Override
	public List<ProjectsSchema> getAllProjects(String lectureId) {
		
		return projectBiz.getAllProjects(lectureId);
	}

	@Override
	public ProjectsSchema getProjectBy(String id) {
		return projectBiz.getProjectBy(id);
	}

	@Override
	public boolean deleteProject(String id, HttpSession session) {
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		
		ProjectsSchema project = projectBiz.getProjectBy(id);
		logger.info("�꽭�뀡 �븘�씠�뵒" + user.getId());
		logger.info("�봽濡쒖젥�듃 �쑀�� �븘�씠�뵒"+project.getUser().getId());
		if(user.getId().equals(project.getUser().getId())) {
			return projectBiz.deleteProject(id);
		}
		return false;
	}

	@Override
	public void modifyProject(ProjectsSchema project) {
		project.setCreatedDate(new Date());
		projectBiz.modifyProject(project);
	}

	
	
}
