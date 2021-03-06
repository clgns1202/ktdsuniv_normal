package com.ktdsuniv.instructor.board.dao;

import java.util.List;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardDao {

	public int addDailyReport(BoardsSchema board);

	public List<BoardsSchema> dailyReportsList(UsersSchema user);

	public BoardsSchema dailyReportDetail(String boardId);

	public int dailyReportDelete(String boardId);


	public void addStudyNote(BoardsSchema board);

}
