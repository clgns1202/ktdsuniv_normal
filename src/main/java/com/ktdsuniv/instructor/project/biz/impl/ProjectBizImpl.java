package com.ktdsuniv.instructor.project.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.dao.ProjectDao;

import project.schema.ProjectsSchema;

public class ProjectBizImpl implements ProjectBiz {

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
	public List<ProjectsSchema> getAllProjects() {
		return projectDao.getAllProjects();
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
	public boolean modifyProject(String id) {
		return projectDao.modifyProject(id) > 0;
	}



	
}
