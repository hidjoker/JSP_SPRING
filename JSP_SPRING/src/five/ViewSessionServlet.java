package session;

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
		
		// 요청객체 한글 인코딩 : UTF-8 설정
		request.setCharacterEncoding("UTF-8");
		
		// 응답객체 문서형식 설정(+인코딩)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //응답스트림
		
		out.println("<h1>세션 정보 확인하기</h1>");
		out.println("<hr>");
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		//세션 정보 얻기
		String data = (String) session.getAttribute("test");
		
		// 세션 정보 출력하기(클라이언트 화면에 보이게 하기)		
		out.println("세션 정보 : "+ data);
		out.println(
				"<h1><a href='createSession.do'>세션생성</a></h1>");
		out.println(
				"<h1><a href='deleteSession.do'>세션삭제</a></h1>");
				
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
