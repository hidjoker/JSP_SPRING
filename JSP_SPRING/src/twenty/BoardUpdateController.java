package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.Board;
import board.service.BoardServiceImpl;

@WebServlet("/board/update.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		
		BoardServiceImpl service = new BoardServiceImpl();
		
		Board board = service.viewBoard(boardno);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/board/update.jsp")
			.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardServiceImpl service =  new BoardServiceImpl();
		
		Board board = new Board();
		System.out.println((Integer)request.getAttribute("boardno"));
		board.setBoardno((Integer)request.getAttribute("boardno"));
		board.setTitle(title);
		board.setContent(content);
	
		
		service.updateBoard(board);
		
		response.sendRedirect("/board/pagingList.do");

	}

}
