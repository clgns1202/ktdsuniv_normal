package com.ktdsuniv.instructor.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import project.schema.ProjectsSchema;

public interface ProjectService {

	public void addProject(ProjectsSchema project, HttpSession session, String lectureId);

	public List<ProjectsSchema> getAllProjects(String lectureId);

	public ProjectsSchema getProjectBy(String id);

	public boolean deleteProject(String id, HttpSession session);

	public void modifyProject(ProjectsSchema project);

}
