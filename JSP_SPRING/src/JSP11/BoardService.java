package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardService {

	// ê²Œì‹œê¸? ë¦¬ìŠ¤?Š¸ ì¡°íšŒ
	public List getList();

	// ì´? ê²Œì‹œê¸? ?ˆ˜
	public int getTotal();
	
	// ?˜?´ì§? ë¦¬ìŠ¤?Š¸ ì¡°íšŒ
	public List getPagingList(Paging paging);
	
	// ê²Œì‹œê¸? ?‘?„±
	public void addBoard(Board board);
	
}











