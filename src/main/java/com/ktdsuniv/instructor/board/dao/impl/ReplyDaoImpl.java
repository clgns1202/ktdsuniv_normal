package com.ktdsuniv.instructor.board.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.instructor.board.dao.ReplyDao;

import board.schema.RepliesSchema;
import common.support.mongo.MongoTemplateSupport;
import common.util.DateUtil;

public class ReplyDaoImpl extends MongoTemplateSupport implements ReplyDao {

	@Override
	public int addReply(RepliesSchema reply) {
		Criteria criteria = new Criteria("_id");
		criteria.is(reply.getBoard().getId());
		
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.push("replies", reply);
		
		getMongo().updateFirst(query, update, "boards");
		getMongo().insert(reply);
		
		return 0;
	}

	@Override
	public List<RepliesSchema> getAllReply(String boardId) {
		
		Criteria criteria = new Criteria("boardId");
		criteria.regex(boardId);
		
		Query query = new Query(criteria);
		
		return getMongo().find(query, RepliesSchema.class);
	}
	
	@Override
	public RepliesSchema getReplyForModify(String replyId) {
		RepliesSchema reply = new RepliesSchema();
		reply.setId(replyId);
		
		Criteria criteria = new Criteria("replyId");
		criteria.is(replyId);
		
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.set("reply", reply);
		getMongo().updateFirst(query, update, "repies");
		
		return getMongo().findOne(query, RepliesSchema.class, "replies");
	}

}
