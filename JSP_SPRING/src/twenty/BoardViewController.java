package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.Board;
import board.service.BoardServiceImpl;


@WebServlet("/board/view.do")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		System.out.println(boardno);
		BoardServiceImpl service = new BoardServiceImpl();
		Board board = service.viewBoard(boardno);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/board/view.jsp")
			.forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
