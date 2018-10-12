package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardDao {
	
	// board ?��?���? ?���? 조회
	public List selectAll();
	
	
	// �? 게시�? ?�� 조회
	public int selectCntAll();
	
	// ?��?���? 리스?�� 조회
	public List selectPagingList(Paging paging);
	
	// 게시�? ?��?��
	public void insertBoard(Board board);
	
}















