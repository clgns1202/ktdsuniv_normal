package com.ktdsuniv.instructor.board.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniv.instructor.board.service.ReplyService;

import board.schema.RepliesSchema;
import common.constants.Session;
import user.schema.UsersSchema;

@Controller
public class ReplyController {

	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping("/addReply/{boardId}")
	@ResponseBody
	public List<RepliesSchema> doAddReply(@PathVariable String boardId, RepliesSchema reply, HttpSession session) {
		UsersSchema users = (UsersSchema) session.getAttribute(Session.USER);
		reply.setUser(users);
		reply.getBoard().setId(boardId);
		boolean isSuccess = replyService.addReply(reply);
		return getAllReply(boardId);
	}

	@RequestMapping("/reply/{boardId}")
	@ResponseBody
	private List<RepliesSchema> getAllReply(String boardId) {
		List<RepliesSchema> replies = replyService.getAllReply(boardId);
		return replies;
	}
	
	@RequestMapping("/modifyReply/{replyId}")
	@ResponseBody
	public List<RepliesSchema> modifyReply(@PathVariable String replyId, RepliesSchema reply) {
		reply.setId(replyId);
		reply = replyService.getReplyForModify(replyId);
		
		return getAllReply(reply.getBoard().getId());
	}
	
	@RequestMapping("/deleteReply/{replyId}")
	@ResponseBody
	public List<RepliesSchema> deleteReply(@PathVariable String replyId, HttpSession session) {
		RepliesSchema reply = new RepliesSchema();
		reply.setId(replyId);
		UsersSchema user = (UsersSchema) session.getAttribute(Session.USER);
		reply.setUser(user);
		boolean isSuccess = replyService.deleteReply(replyId,session);
		return getAllReply(reply.getBoard().getId());
	}

}
