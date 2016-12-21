package com.ktdsuniv.normalpage.board.biz.impl;

<<<<<<< HEAD:src/main/java/com/ktdsuniv/instructor/board/biz/impl/ReplyBizImpl.java
import java.util.List;

import com.ktdsuniv.instructor.board.biz.ReplyBiz;
import com.ktdsuniv.instructor.board.dao.ReplyDao;
=======
import com.ktdsuniv.normalpage.board.biz.ReplyBiz;
import com.ktdsuniv.normalpage.board.dao.ReplyDao;
>>>>>>> 21e4e7984a26d28351f31b91d858b65c304d1acb:src/main/java/com/ktdsuniv/normalpage/board/biz/impl/ReplyBizImpl.java

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
	
	@Override
	public boolean deleteReply(String replyId) {
		return replyDao.deleteReply(replyId) > 0;
	}
}
