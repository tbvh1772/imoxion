package com.imoxion.service;


import java.io.IOException;
import java.util.List;

import com.imoxion.domain.BoardVo;

public interface BoardService {
	//글리스트
	public List<BoardVo> getBoardList() throws IOException;

	//글입력
	public void insertBoard(BoardVo boardVo) throws IOException;

	//글삭제
	public void delBoard(int no) throws IOException;
	
	//글보기
	public BoardVo getBoardView(int no) throws IOException;
	 
	//글수정
	public void getUpdate(BoardVo boardVo) throws IOException; 
}
