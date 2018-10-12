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
		
		// ?���?객체 ?���? ?��코딩 : UTF-8 ?��?��
		request.setCharacterEncoding("UTF-8");
		
		// ?��?��객체 문서?��?�� ?��?��(+?��코딩)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //?��?��?��?���?
		
		out.println("<h1>?��?�� ?���? ?��?��</h1>");
		out.println("<hr>");
		
		// ?��?�� ?��?��
		HttpSession session = request.getSession();
		session.setAttribute("test", "Apple");
		
		out.println(
				"<h1><a href='viewSession.do'>?��?��?��?��</a></h1>");
		
//		// LOGIN ?���? ?��?��?��?���?
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
		
//		// LOGIN ?���? DTO?�� ?���?
//		User user = new User();
//		user.setUserId(userId);
//		user.setUserPw(userPw);
//		
//		// JDBC(dao)�? ?��?��?�� 로그?�� ?���?
//		if( dao.login(user)) {
//			//로그?�� ?���?
//			session.setAttribute("login", true);
//			session.setAttribute("loginId", user.getUserId());
//		} else {
//			// 로그?�� ?��?��
//		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
