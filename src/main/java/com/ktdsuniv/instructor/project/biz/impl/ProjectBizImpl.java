package com.ktdsuniv.instructor.project.biz.impl;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.dao.ProjectDao;

import project.schema.ProjectsSchema;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

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
		projectDao.modifyProject(project);
	}





	
}
