package com.ktdsuniv.normalpage.board.dao;

import java.util.List;

import board.schema.RepliesSchema;

public interface ReplyDao {

	public int addReply(RepliesSchema reply);

	public List<RepliesSchema> getAllReply(String boardId);

	public RepliesSchema getReplyForModify(String replyId);

	public int deleteReply(String replyId);
	
}
