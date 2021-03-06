package com.ktdsuniv.normalpage.board.biz;

import java.util.List;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardBiz {

	public void addStudyNote(BoardsSchema board);

	public BoardsSchema getIdBoardBy(String id);

	public List<BoardsSchema> getMyStudyNote(UsersSchema user);
	
	public boolean addDailyReport(BoardsSchema board);

	public List<BoardsSchema> dailyReportsList(UsersSchema user);

	public BoardsSchema dailyReportDetail(String boardId);

	public boolean dailyReportDelete(String boardId);


}
