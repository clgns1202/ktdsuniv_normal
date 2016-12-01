package com.ktdsuniv.instructor.project.biz;

import java.util.List;

import project.schema.ProjectsSchema;

public interface ProjectBiz {

	public void addProject(ProjectsSchema project);

	public List<ProjectsSchema> getAllProjects();

	public ProjectsSchema getProjectBy(String id);

	public boolean deleteProject(String id);

	public boolean modifyProject(String id);

}
