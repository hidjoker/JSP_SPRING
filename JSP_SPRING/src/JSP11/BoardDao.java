package JSP11;

import java.util.List;

import board.dto.Board;
import board.util.Paging;

public interface BoardDao {
	
	// board ??΄λΈ? ? μ²? μ‘°ν
	public List selectAll();
	
	
	// μ΄? κ²μκΈ? ? μ‘°ν
	public int selectCntAll();
	
	// ??΄μ§? λ¦¬μ€?Έ μ‘°ν
	public List selectPagingList(Paging paging);
	
	// κ²μκΈ? ??±
	public void insertBoard(Board board);
	
}















