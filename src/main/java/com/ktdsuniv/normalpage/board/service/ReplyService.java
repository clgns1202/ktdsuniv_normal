package com.ktdsuniv.normalpage.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import board.schema.RepliesSchema;

public interface ReplyService {

	public boolean addReply(RepliesSchema reply);

	public List<RepliesSchema> getAllReply(String boardId);

	public RepliesSchema getReplyForModify(String replyId);

	public boolean deleteReply(String replyId, HttpSession session);
	
}
