package com.ktdsuniv.normalpage.board.dao;

import java.util.List;

import board.schema.BoardsSchema;
import user.schema.UsersSchema;

public interface BoardDao {

	public void addStudyNote(BoardsSchema board);

	public BoardsSchema getIdBoardBy(String id);

	public List<BoardsSchema> getMyStudyNote(UsersSchema user);

}
