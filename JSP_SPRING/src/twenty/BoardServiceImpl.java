package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dto.Board;
import board.util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	@Override
	public int getTotal() {
		return boardDao.selectCntAll();
	}

	@Override
	public List getPagingList(Paging paging) {
		return boardDao.selectPagingList(paging);
	}
	

	@Override
	public void addBoard(Board board) {
		boardDao.insertBoard(board);				
	}

	@Override
	public Board viewBoard(int boardno) {
		return boardDao.viewBoard(boardno);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
}













