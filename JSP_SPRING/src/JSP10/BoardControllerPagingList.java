package JSP10;

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
		
		
		// ??¬ ??΄μ§?
		String param = request.getParameter("curPage");
		
		int curPage = 0;
		if(!"".equals(param) && param != null) {
			curPage = Integer.parseInt(
					request.getParameter("curPage")
			);
		}
		
		// μ΄? κ²μκΈ? ?
		int totalCount = new BoardService().getTotal();
		
		//paging class κ³μ°?κΈ?
		Paging paging = new Paging(totalCount, curPage);
		System.out.println(paging);
	}

}
