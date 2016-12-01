package com.ktdsuniv.instructor.project.dao;

import java.util.List;

import project.schema.ProjectsSchema;

public interface ProjectDao {

	public void addProject(ProjectsSchema project);

	public List<ProjectsSchema> getAllProjects();

	public ProjectsSchema getProjectBy(String id);

	public int deleteProject(String id);

	public int modifyProject(String id);





}
