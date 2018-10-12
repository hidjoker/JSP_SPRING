package JSP5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/viewSession.do")
public class ViewSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ?š”ì²?ê°ì²´ ?•œê¸? ?¸ì½”ë”© : UTF-8 ?„¤? •
		request.setCharacterEncoding("UTF-8");
		
		// ?‘?‹µê°ì²´ ë¬¸ì„œ?˜•?‹ ?„¤? •(+?¸ì½”ë”©)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //?‘?‹µ?Š¤?Š¸ë¦?
		
		out.println("<h1>?„¸?…˜ ? •ë³? ?™•?¸?•˜ê¸?</h1>");
		out.println("<hr>");
		
		// ?„¸?…˜ ê°ì²´ ?ƒ?„±
		HttpSession session = request.getSession();
		
		//?„¸?…˜ ? •ë³? ?–»ê¸?
		String data = (String) session.getAttribute("test");
		
		// ?„¸?…˜ ? •ë³? ì¶œë ¥?•˜ê¸?(?´?¼?´?–¸?Š¸ ?™”ë©´ì— ë³´ì´ê²? ?•˜ê¸?)		
		out.println("?„¸?…˜ ? •ë³? : "+ data);
		out.println(
				"<h1><a href='createSession.do'>?„¸?…˜?ƒ?„±</a></h1>");
		out.println(
				"<h1><a href='deleteSession.do'>?„¸?…˜?‚­? œ</a></h1>");
				
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
