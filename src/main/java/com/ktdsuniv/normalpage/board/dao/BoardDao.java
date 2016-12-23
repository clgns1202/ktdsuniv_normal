package com.ktdsuniv.normalpage.board.dao;

import java.util.List;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardDao {

	public void addStudyNote(BoardsSchema board);

	public BoardsSchema getIdBoardBy(String id);

	public List<BoardsSchema> getMyStudyNote(UsersSchema user);
	
	public int addDailyReport(BoardsSchema board);

	public List<BoardsSchema> dailyReportsList(UsersSchema user);

	public BoardsSchema dailyReportDetail(String boardId);

	public int dailyReportDelete(String boardId);
	
	


}
