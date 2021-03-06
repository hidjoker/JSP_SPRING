package JSP11;

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

		// ??¬ ??΄μ§? 
		String param = request.getParameter("curPage");
		
		int curPage = 0;
		if( !"".equals(param) && param != null ) {
			curPage = Integer.parseInt(
				request.getParameter("curPage") );
		}
		
		// μ΄? κ²μκΈ? ?
		int totalCount = boardService.getTotal();

		// Paging Class κ³μ°?κΈ?
		Paging paging = new Paging(totalCount, curPage);
		
//		System.out.println(paging);


		// κ²μκΈ? μ‘°ν κ²°κ³Ό
		List<Board> boardList = boardService.getPagingList(paging);

		// JSP? ? ?¬?  MODEL μ²λ¦¬
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging",paging);
		
		// ?¬??©
		request.getRequestDispatcher("/board/list.jsp")
			.forward(request, response);
		
	}
}









