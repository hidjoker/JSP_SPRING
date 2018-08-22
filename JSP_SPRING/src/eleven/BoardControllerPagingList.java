package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import board.util.Paging;

@WebServlet("/board/pagingList.do")
public class BoardControllerPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 현재 페이지 
		String param = request.getParameter("curPage");
		
		int curPage = 0;
		if( !"".equals(param) && param != null ) {
			curPage = Integer.parseInt(
				request.getParameter("curPage") );
		}
		
		// 총 게시글 수
		int totalCount = boardService.getTotal();

		// Paging Class 계산하기
		Paging paging = new Paging(totalCount, curPage);
		
//		System.out.println(paging);


		// 게시글 조회 결과
		List<Board> boardList = boardService.getPagingList(paging);

		// JSP에 전달할 MODEL 처리
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging",paging);
		
		// 포워딩
		request.getRequestDispatcher("/board/list.jsp")
			.forward(request, response);
		
	}
}









