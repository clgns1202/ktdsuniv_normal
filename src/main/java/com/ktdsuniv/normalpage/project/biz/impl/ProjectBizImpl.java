package com.ktdsuniv.normalpage.project.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.normalpage.project.biz.ProjectBiz;
import com.ktdsuniv.normalpage.project.dao.ProjectDao;

import lecture.schema.LecturesSchema;
import project.schema.ProjectsSchema;

public class ProjectBizImpl implements ProjectBiz {

	private Logger logger = LoggerFactory.getLogger(ProjectBizImpl.class);
	private ProjectDao projectDao;
	
	public void setProjectDao(ProjectDao projectDao) {
				
		this.projectDao = projectDao;
	}

	@Override
	public void addProject(ProjectsSchema project) {
		String message = project.getProjectInfo();
		message = message.replaceAll("\n", "<br/>");
		message = message.replaceAll("\n", "");
		project.setProjectInfo(message);
		
	
		
		projectDao.addProject(project);
	}

	@Override
	public List<ProjectsSchema> getAllProjects(String lectureId) {
	
		return projectDao.getAllProjects(lectureId);
	}

	@Override
	public ProjectsSchema getProjectBy(String id) {
		return projectDao.getProjectBy(id);
	}

	@Override
	public boolean deleteProject(String id) {
		return projectDao.deleteProject(id) > 0;
	}

	@Override
	public void modifyProject(ProjectsSchema project) {


		
		
		String message = project.getProjectInfo();
		message = message.replaceAll("\n", "<br/>");
		message = message.replaceAll("\n", "");
		project.setProjectInfo(message);
		
		projectDao.modifyProject(project);
	}

	@Override
	public LecturesSchema getAllUserName(String lectureId) {
		return projectDao.getAllUserName(lectureId);
	}





	
}
