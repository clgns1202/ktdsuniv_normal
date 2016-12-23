package com.ktdsuniv.normalpage.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.normalpage.board.biz.ReplyBiz;
import com.ktdsuniv.normalpage.board.service.ReplyService;

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

	@Override
	public boolean deleteReply(String replyId, HttpSession session) {
		return replyBiz.deleteReply(replyId);
	}
	
}
