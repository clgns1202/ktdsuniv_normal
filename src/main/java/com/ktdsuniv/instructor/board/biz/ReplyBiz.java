package com.ktdsuniv.instructor.board.biz;

import java.util.List;

import board.schema.RepliesSchema;

public interface ReplyBiz {

	public boolean addReply(RepliesSchema reply);

	public List<RepliesSchema> getAllReply(String boardId);

	public RepliesSchema getReplyForModify(String replyId);


}
