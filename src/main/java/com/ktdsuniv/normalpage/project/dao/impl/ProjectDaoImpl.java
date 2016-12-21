package com.ktdsuniv.normalpage.project.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.normalpage.project.dao.ProjectDao;

import common.support.mongo.MongoTemplateSupport;
import project.schema.ProjectsSchema;

public class ProjectDaoImpl extends MongoTemplateSupport implements ProjectDao {

	private Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
	
	@Override
	public void addProject(ProjectsSchema project) {
		getMongo().save(project);
	}

		
		@Override
		public List<ProjectsSchema> getAllProjects() {
			return getMongo().findAll(ProjectsSchema.class);
		}


		@Override
		public ProjectsSchema getProjectBy(String id) {
			return getMongo().findById(id, ProjectsSchema.class,"projects");
		}


		@Override
		public int deleteProject(String id) {
			Query query = new Query(new Criteria("_id").is(id));
			logger.info("프로젝트 아이디!!" + id);
			getMongo().remove(query, "projects");
			return 1;
		}


	@Override
	public void modifyProject(ProjectsSchema project) {
		Criteria criteria = new Criteria("_id");
		criteria.is(project.getId());

		Query query = new Query(criteria);

		ProjectsSchema originalSchema = getMongo().findOne(query, ProjectsSchema.class);
		originalSchema.setProjectName(project.getProjectName());
		originalSchema.setProjectInfo(project.getProjectInfo());
		originalSchema.setCreatedDate(project.getCreatedDate());

		getMongo().save(originalSchema);

	}

}

