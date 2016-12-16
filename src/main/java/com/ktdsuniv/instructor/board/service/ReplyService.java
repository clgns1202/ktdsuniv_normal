package com.ktdsuniv.instructor.board.service;

import java.util.List;

import board.schema.RepliesSchema;

public interface ReplyService {

	public boolean addReply(RepliesSchema reply);

	public List<RepliesSchema> getAllReply(String boardId);

	public RepliesSchema getReplyForModify(String replyId);


}
