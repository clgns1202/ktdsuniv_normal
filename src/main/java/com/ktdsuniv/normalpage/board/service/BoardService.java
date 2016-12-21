package com.ktdsuniv.normalpage.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import board.schema.BoardsSchema;

public interface BoardService {

	public void addStudyNote(BoardsSchema board, HttpSession session);

	public BoardsSchema getIdBoardBy(String id);

	public List<BoardsSchema> getMyStudyNote(HttpSession session);

}
