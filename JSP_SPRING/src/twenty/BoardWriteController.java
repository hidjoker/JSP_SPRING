package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.Board;
import board.service.BoardServiceImpl;


@WebServlet("/board/write.do")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		session.setAttribute("writer","테스트작성자");
		
		request.getRequestDispatcher("/board/write.jsp")
			.forward(request, response);
						
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = (String)request.getSession().getAttribute("writer");
		
		BoardServiceImpl service =  new BoardServiceImpl();
		
		Board board = new Board();
		board.setBoardno(service.getTotal()+1);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setHit(0);
		board.setRecommend(0);
		
		service.addBoard(board);
		
		response.sendRedirect("/board/pagingList.do");
		
	}

}
