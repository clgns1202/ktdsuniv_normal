package com.ktdsuniv.instructor.board.service.impl;

import java.util.List;

import com.ktdsuniv.instructor.board.biz.ReplyBiz;
import com.ktdsuniv.instructor.board.service.ReplyService;

import board.schema.RepliesSchema;

public class ReplyServiceImpl implements ReplyService {

	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}

	@Override
	public boolean addReply(RepliesSchema reply) {
		return replyBiz.addReply(reply);
	}

	@Override
	public List<RepliesSchema> getAllReply(String boardId) {
		return replyBiz.getAllReply(boardId);
	}
	
	@Override
	public RepliesSchema getReplyForModify(String replyId) {
		RepliesSchema reply = new RepliesSchema();
		String comment = reply.getComment();
		comment.replaceAll("<br/>", "\n");
		
		reply.setComment(comment);
		return replyBiz.getReplyForModify(replyId);
	}
	
}
