package session;

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
		
		// 요청객체 한글 인코딩 : UTF-8 설정
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //응답스트림
		
		out.println("<h1>세션 정보 생성</h1>");
		out.println("<hr>");
		
		// 세션 생성
		HttpSession session = request.getSession();
		session.setAttribute("test", "Apple");
		
		out.println(
				"<h1><a href='viewSession.do'>세션확인</a></h1>");
		
//		// LOGIN 정보 전달된다면
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
		
//		// LOGIN 정보 DTO에 담기
//		User user = new User();
//		user.setUserId(userId);
//		user.setUserPw(userPw);
//		
//		// JDBC(dao)를 이용한 로그인 인증
//		if( dao.login(user)) {
//			//로그인 성공
//			session.setAttribute("login", true);
//			session.setAttribute("loginId", user.getUserId());
//		} else {
//			// 로그인 실패
//		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
