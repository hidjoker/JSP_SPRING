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
		
		// ?μ²?κ°μ²΄ ?κΈ? ?Έμ½λ© : UTF-8 ?€? 
		request.setCharacterEncoding("UTF-8");
		
		// ??΅κ°μ²΄ λ¬Έμ?? ?€? (+?Έμ½λ©)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //??΅?€?Έλ¦?
		
		out.println("<h1>?Έ? ? λ³? ??±</h1>");
		out.println("<hr>");
		
		// ?Έ? ??±
		HttpSession session = request.getSession();
		session.setAttribute("test", "Apple");
		
		out.println(
				"<h1><a href='viewSession.do'>?Έ???Έ</a></h1>");
		
//		// LOGIN ? λ³? ? ?¬??€λ©?
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
		
//		// LOGIN ? λ³? DTO? ?΄κΈ?
//		User user = new User();
//		user.setUserId(userId);
//		user.setUserPw(userPw);
//		
//		// JDBC(dao)λ₯? ?΄?©? λ‘κ·Έ?Έ ?Έμ¦?
//		if( dao.login(user)) {
//			//λ‘κ·Έ?Έ ?±κ³?
//			session.setAttribute("login", true);
//			session.setAttribute("loginId", user.getUserId());
//		} else {
//			// λ‘κ·Έ?Έ ?€?¨
//		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
