package com.ktdsuniv.normalpage.board.service.impl;

import com.ktdsuniv.normalpage.board.biz.ReplyBiz;
import com.ktdsuniv.normalpage.board.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
}
