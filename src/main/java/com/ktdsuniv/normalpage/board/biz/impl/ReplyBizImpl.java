package com.ktdsuniv.normalpage.board.biz.impl;

import com.ktdsuniv.normalpage.board.biz.ReplyBiz;
import com.ktdsuniv.normalpage.board.dao.ReplyDao;

public class ReplyBizImpl implements ReplyBiz {

	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
}
