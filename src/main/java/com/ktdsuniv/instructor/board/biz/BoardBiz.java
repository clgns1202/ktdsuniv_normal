package com.ktdsuniv.instructor.board.biz;

import java.util.List;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardBiz {

	public boolean addDailyReport(BoardsSchema board);

	public List<BoardsSchema> dailyReportsList(UsersSchema user);

	public BoardsSchema dailyReportDetail(String boardId);

	public boolean dailyReportDelete(String boardId);

	public void addStudyNote(BoardsSchema board);

}
