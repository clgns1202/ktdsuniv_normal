package com.ktdsuniv.instructor.board.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.board.biz.ReplyBiz;
import com.ktdsuniv.instructor.board.dao.ReplyDao;

import board.schema.RepliesSchema;

public class ReplyBizImpl implements ReplyBiz {

	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public boolean addReply(RepliesSchema reply) {
		return replyDao.addReply(reply) > 0;
	}

	@Override
	public List<RepliesSchema> getAllReply(String boardId) {
		return replyDao.getAllReply(boardId);
	}
	
	@Override
	public RepliesSchema getReplyForModify(String replyId) {
		return replyDao.getReplyForModify(replyId);
	}
}
