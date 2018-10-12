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

@WebServlet("/board/list.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Í≤åÏãúÍ∏? Ï°∞Ìöå Í≤∞Í≥º
		List<Board> boardList = boardService.getList();

		// JSP?óê ?†Ñ?ã¨?ï† MODEL Ï≤òÎ¶¨
		request.setAttribute("boardList", boardList);
		
		// ?è¨?õå?î©
		request.getRequestDispatcher("/board/list.jsp")
			.forward(request, response);
		
	}
	
	
}









