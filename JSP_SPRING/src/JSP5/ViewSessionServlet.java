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
		
		// ?���?객체 ?���? ?��코딩 : UTF-8 ?��?��
		request.setCharacterEncoding("UTF-8");
		
		// ?��?��객체 문서?��?�� ?��?��(+?��코딩)
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //?��?��?��?���?
		
		out.println("<h1>?��?�� ?���? ?��?��?���?</h1>");
		out.println("<hr>");
		
		// ?��?�� 객체 ?��?��
		HttpSession session = request.getSession();
		
		//?��?�� ?���? ?���?
		String data = (String) session.getAttribute("test");
		
		// ?��?�� ?���? 출력?���?(?��?��?��?��?�� ?��면에 보이�? ?���?)		
		out.println("?��?�� ?���? : "+ data);
		out.println(
				"<h1><a href='createSession.do'>?��?��?��?��</a></h1>");
		out.println(
				"<h1><a href='deleteSession.do'>?��?��?��?��</a></h1>");
				
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
