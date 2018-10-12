package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardDao {
	
	// board ?…Œ?´ë¸? ? „ì²? ì¡°íšŒ
	public List selectAll();
	
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜ ì¡°íšŒ
	public int selectCntAll();
	
	// ?˜?´ì§? ë¦¬ìŠ¤?Š¸ ì¡°íšŒ
	public List selectPagingList(Paging paging);
	
	// ê²Œì‹œê¸? ?‘?„±
	public void insertBoard(Board board);
	
}















