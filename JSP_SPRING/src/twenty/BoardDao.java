package board.dao;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardDao {
	
	// board 테이블 전체 조회
	public List selectAll();
	
	
	// 총 게시글 수 조회
	public int selectCntAll();
	
	// 페이징 리스트 조회
	public List selectPagingList(Paging paging);
	
	// 게시글 작성
	public void insertBoard(Board board);
	
	// 게시글 확인
	public Board viewBoard(int boardno);
	
	// 게시글 수정
	public void updateBoard(Board board);
	
	
}















