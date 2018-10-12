package JSP5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// loginForm ?ùÑ?ö∞Í∏?
		
		request.getRequestDispatcher("/login/loginForm.jsp")
			.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login Ï≤òÎ¶¨
		
		// ?†Ñ?ã¨ ?åå?ùºÎØ∏ÌÑ∞ ?ñªÍ∏?
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		System.out.println("[TEST] id : "+id+",pw="+pw);


		// Î°úÍ∑∏?ù∏ Ï≤òÎ¶¨1.
//		String url = "";
//		
//		// Î°úÍ∑∏?ù∏ ?†ïÎ≥? ?ù∏Ï¶?
//		if("abc".equals(id)&&"123".equals(pw)) {
//			//Î°úÍ∑∏?ù∏ ?Ñ±Í≥? - loginSuccess.jsp Î≥¥Ïó¨Ï£ºÍ∏∞
//			url = "loginSuccess";
//			// Î°úÍ∑∏?ù∏ ?ÉÅ?Éú?†ïÎ≥? ???û• - ?Ñ∏?Öò
//			request.getSession().setAttribute("login", true);
//			request.getSession().setAttribute("id", id);
//		}else {
//			//Î°úÍ∑∏?ù∏ ?ã§?å® - loginFail.jsp Î≥¥Ïó¨Ï£ºÍ∏∞
//			url = "loginFail";
//			
//			// Î°úÍ∑∏?ù∏ ?ÉÅ?Éú?†ïÎ≥? ???û• - ?Ñ∏?Öò
//			request.getSession().setAttribute("login", false);
//		}
//		
//		request.getRequestDispatcher("/login/"+url+".jsp")
//			.forward(request, response);
		
		
		// Î°úÍ∑∏?ù∏ Ï≤òÎ¶¨2.		
		// Î°úÍ∑∏?ù∏ ?†ïÎ≥? ?ù∏Ï¶?
		if("abc".equals(id)&&"123".equals(pw)) {
			// Î°úÍ∑∏?ù∏ ?ÉÅ?Éú?†ïÎ≥? ???û• - ?Ñ∏?Öò
			request.getSession().setAttribute("login", true);
			request.getSession().setAttribute("id", id);
		}else {
			// Î°úÍ∑∏?ù∏ ?ÉÅ?Éú?†ïÎ≥? ???û• - ?Ñ∏?Öò
			request.getSession().setAttribute("login", false);
		}
		
		request.getRequestDispatcher("/login/loginProc.jsp")
			.forward(request, response);
		
	}

}
