package com.ktdsuniv.normalpage.project.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import lecture.schema.LecturesSchema;
import project.schema.ProjectsSchema;
import user.schema.UsersSchema;

public interface ProjectDao {

	public void addProject(ProjectsSchema project);

	public List<ProjectsSchema> getAllProjects(String lectureId);

	public ProjectsSchema getProjectBy(String id);

	public int deleteProject(String id);


	public void modifyProject(ProjectsSchema project);

	public LecturesSchema getAllUserName(String lectureId);





}
