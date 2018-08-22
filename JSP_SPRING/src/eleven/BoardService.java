package board.service;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardService {

	// 게시글 리스트 조회
	public List getList();

	// 총 게시글 수
	public int getTotal();
	
	// 페이징 리스트 조회
	public List getPagingList(Paging paging);
	
	// 게시글 작성
	public void addBoard(Board board);
	
}











