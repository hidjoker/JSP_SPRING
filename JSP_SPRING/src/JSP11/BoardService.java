package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardService {

	// 게시�? 리스?�� 조회
	public List getList();

	// �? 게시�? ?��
	public int getTotal();
	
	// ?��?���? 리스?�� 조회
	public List getPagingList(Paging paging);
	
	// 게시�? ?��?��
	public void addBoard(Board board);
	
}











