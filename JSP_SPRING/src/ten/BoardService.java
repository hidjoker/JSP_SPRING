package board.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.dao.BoardDao;
import board.dto.Board;
import board.util.Paging;

public class BoardService {

	public HttpServletRequest getList(HttpServletRequest request){
		
		System.out.println("서비스진입!");
		BoardDao dao = new BoardDao();
		List<Board> list = new ArrayList<>();
		
		list = dao.selectAll();
		request.setAttribute("list", list);
		
		return request;
		
	}
	
	public int getTotal() {
		BoardDao dao = new BoardDao();
		return dao.selectCntAll();
		
	}
	
	public List<Board> getPagingList(Paging paging) {
		
		BoardDao dao = new BoardDao();
		
		return dao.selectPagingList(paging);
				
	};
	
}
