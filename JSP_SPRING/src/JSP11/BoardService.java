package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardService {

	// κ²μκΈ? λ¦¬μ€?Έ μ‘°ν
	public List getList();

	// μ΄? κ²μκΈ? ?
	public int getTotal();
	
	// ??΄μ§? λ¦¬μ€?Έ μ‘°ν
	public List getPagingList(Paging paging);
	
	// κ²μκΈ? ??±
	public void addBoard(Board board);
	
}











