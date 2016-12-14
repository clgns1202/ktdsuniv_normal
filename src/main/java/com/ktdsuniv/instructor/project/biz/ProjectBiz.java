package com.ktdsuniv.instructor.project.biz;

import java.util.List;

import project.schema.ProjectsSchema;
import user.schema.UsersSchema;

public interface ProjectBiz {

	public void addProject(ProjectsSchema project);

	public List<ProjectsSchema> getAllProjects(String lectureId);

	public ProjectsSchema getProjectBy(String id);

	public boolean deleteProject(String id);

	public void modifyProject(ProjectsSchema project);

}
