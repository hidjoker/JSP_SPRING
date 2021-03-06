package JSP5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/deleteSession.do")
public class DeleteSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ?μ²?κ°μ²΄ ?κΈ? ?Έμ½λ© : UTF-8 ?€? 
		request.setCharacterEncoding("UTF-8");
		
		// ??΅κ°μ²΄ λ¬Έμ?? ?€? (+?Έμ½λ©)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //??΅?€?Έλ¦?
		
		out.println("<h1>?Έ? ? λ³? ??±</h1>");
		out.println("<hr>");
		
		// ?Έ? κ°μ²΄ ??±
		HttpSession session = request.getSession();
		
		// ?Έ? ?­?  ?κΈ?
		session.invalidate();
		
		out.println(
				"<h1><a href='createSession.do'>?Έ???±</a></h1>");
		out.println(
				"<h1><a href='viewSession.do'>?Έ???Έ</a></h1>");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
