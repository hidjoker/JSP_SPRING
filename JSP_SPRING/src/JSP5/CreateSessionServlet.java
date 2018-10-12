package JSP5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/createSession.do")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ?š”ì²?ê°ì²´ ?•œê¸? ?¸ì½”ë”© : UTF-8 ?„¤? •
		request.setCharacterEncoding("UTF-8");
		
		// ?‘?‹µê°ì²´ ë¬¸ì„œ?˜•?‹ ?„¤? •(+?¸ì½”ë”©)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //?‘?‹µ?Š¤?Š¸ë¦?
		
		out.println("<h1>?„¸?…˜ ? •ë³? ?ƒ?„±</h1>");
		out.println("<hr>");
		
		// ?„¸?…˜ ?ƒ?„±
		HttpSession session = request.getSession();
		session.setAttribute("test", "Apple");
		
		out.println(
				"<h1><a href='viewSession.do'>?„¸?…˜?™•?¸</a></h1>");
		
//		// LOGIN ? •ë³? ? „?‹¬?œ?‹¤ë©?
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
		
//		// LOGIN ? •ë³? DTO?— ?‹´ê¸?
//		User user = new User();
//		user.setUserId(userId);
//		user.setUserPw(userPw);
//		
//		// JDBC(dao)ë¥? ?´?š©?•œ ë¡œê·¸?¸ ?¸ì¦?
//		if( dao.login(user)) {
//			//ë¡œê·¸?¸ ?„±ê³?
//			session.setAttribute("login", true);
//			session.setAttribute("loginId", user.getUserId());
//		} else {
//			// ë¡œê·¸?¸ ?‹¤?Œ¨
//		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
