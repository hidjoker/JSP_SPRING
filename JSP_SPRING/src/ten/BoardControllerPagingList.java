package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.util.Paging;


@WebServlet("/board/pagingList.do")
public class BoardControllerPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 현재 페이지
		String param = request.getParameter("curPage");
		
		int curPage = 0;
		if(!"".equals(param) && param != null) {
			curPage = Integer.parseInt(
					request.getParameter("curPage")
			);
		}
		
		// 총 게시글 수
		int totalCount = new BoardService().getTotal();
		
		//paging class 계산하기
		Paging paging = new Paging(totalCount, curPage);
		System.out.println(paging);
	}

}
