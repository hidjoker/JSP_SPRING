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
		// loginForm ?��?���?
		
		request.getRequestDispatcher("/login/loginForm.jsp")
			.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 처리
		
		// ?��?�� ?��?��미터 ?���?
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		System.out.println("[TEST] id : "+id+",pw="+pw);


		// 로그?�� 처리1.
//		String url = "";
//		
//		// 로그?�� ?���? ?���?
//		if("abc".equals(id)&&"123".equals(pw)) {
//			//로그?�� ?���? - loginSuccess.jsp 보여주기
//			url = "loginSuccess";
//			// 로그?�� ?��?��?���? ???�� - ?��?��
//			request.getSession().setAttribute("login", true);
//			request.getSession().setAttribute("id", id);
//		}else {
//			//로그?�� ?��?�� - loginFail.jsp 보여주기
//			url = "loginFail";
//			
//			// 로그?�� ?��?��?���? ???�� - ?��?��
//			request.getSession().setAttribute("login", false);
//		}
//		
//		request.getRequestDispatcher("/login/"+url+".jsp")
//			.forward(request, response);
		
		
		// 로그?�� 처리2.		
		// 로그?�� ?���? ?���?
		if("abc".equals(id)&&"123".equals(pw)) {
			// 로그?�� ?��?��?���? ???�� - ?��?��
			request.getSession().setAttribute("login", true);
			request.getSession().setAttribute("id", id);
		}else {
			// 로그?�� ?��?��?���? ???�� - ?��?��
			request.getSession().setAttribute("login", false);
		}
		
		request.getRequestDispatcher("/login/loginProc.jsp")
			.forward(request, response);
		
	}

}
