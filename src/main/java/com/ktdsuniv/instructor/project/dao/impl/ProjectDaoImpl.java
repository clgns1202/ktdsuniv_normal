package com.ktdsuniv.instructor.project.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.instructor.project.dao.ProjectDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import project.schema.ProjectsSchema;

public class ProjectDaoImpl extends MongoTemplateSupport implements ProjectDao {

	private Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
	
	@Override
	public void addProject(ProjectsSchema project) {
		getMongo().save(project);
	}

		
		@Override
		public List<ProjectsSchema> getAllProjects(String lectureId) {
			Criteria name = new Criteria("_id");
			name.is(lectureId);
			Query query = new Query(name);
			LecturesSchema lecture = getMongo().findOne(query, LecturesSchema.class);
			
			
			Criteria criteria = new Criteria("lecture.lectureName");
			criteria.is(lecture.getLectureName());
			
			Query query2 = new Query(criteria);
			
			return getMongo().find(query2, ProjectsSchema.class, "projects");
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

