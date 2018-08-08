package one_Teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// request ?š”ì²?ê°ì²´?—?„œ ? „?‹¬ ?ŒŒ?¼ë¯¸í„° êº¼ë‚´ê¸?
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// ì½˜ì†”ë¡? ?™•?¸?•˜ê¸?
		System.out.println("ID : " + userId);
		System.out.println("PW : " + userPw);
		
		//?‘?‹µ ?°?´?„° ?–‘?‹ ?„¤? •?•˜ê¸?(?¸ì½”ë”© ?¬?•¨)
		response.setContentType("text/html;charset=UTF-8");
		
		//?‘?‹µ ?°?´?„° ?ƒ?„±?•˜ê¸?
		response.getWriter()
			.append("<h1>? „?‹¬ë°›ì? ?°?´?„°</h1>")
			.append("<hr>")
			.append("<h3>?•„?´?”” : "+userId+"</h3>")
			.append("<h3>?Œ¨?Š¤?›Œ?“œ : "+userPw+"</h3>");
		
	}
}











