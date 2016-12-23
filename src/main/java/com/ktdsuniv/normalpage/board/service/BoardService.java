package com.ktdsuniv.normalpage.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardService {

	public void addStudyNote(BoardsSchema board, HttpSession session);

	public BoardsSchema getIdBoardBy(String id);

	public List<BoardsSchema> getMyStudyNote(HttpSession session);
	
	public boolean addDailyReport(BoardsSchema board);

	public List<BoardsSchema> dailyReportsList(UsersSchema user);

	public BoardsSchema dailyReportDetail(String boardId);

	public boolean doDailyReportDelete(String boardId);


}
