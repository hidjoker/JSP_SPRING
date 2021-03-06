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
		
		// ?μ²?κ°μ²΄ ?κΈ? ?Έμ½λ© : UTF-8 ?€? 
		request.setCharacterEncoding("UTF-8");
		
		// ??΅κ°μ²΄ λ¬Έμ?? ?€? (+?Έμ½λ©)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //??΅?€?Έλ¦?
		
		out.println("<h1>?Έ? ? λ³? ??Έ?κΈ?</h1>");
		out.println("<hr>");
		
		// ?Έ? κ°μ²΄ ??±
		HttpSession session = request.getSession();
		
		//?Έ? ? λ³? ?»κΈ?
		String data = (String) session.getAttribute("test");
		
		// ?Έ? ? λ³? μΆλ ₯?κΈ?(?΄?Ό?΄?Έ?Έ ?λ©΄μ λ³΄μ΄κ²? ?κΈ?)		
		out.println("?Έ? ? λ³? : "+ data);
		out.println(
				"<h1><a href='createSession.do'>?Έ???±</a></h1>");
		out.println(
				"<h1><a href='deleteSession.do'>?Έ??­? </a></h1>");
				
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
