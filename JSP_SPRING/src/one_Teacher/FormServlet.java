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
		
		// request ?���?객체?��?�� ?��?�� ?��?��미터 꺼내�?
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// 콘솔�? ?��?��?���?
		System.out.println("ID : " + userId);
		System.out.println("PW : " + userPw);
		
		//?��?�� ?��?��?�� ?��?�� ?��?��?���?(?��코딩 ?��?��)
		response.setContentType("text/html;charset=UTF-8");
		
		//?��?�� ?��?��?�� ?��?��?���?
		response.getWriter()
			.append("<h1>?��?��받�? ?��?��?��</h1>")
			.append("<hr>")
			.append("<h3>?��?��?�� : "+userId+"</h3>")
			.append("<h3>?��?��?��?�� : "+userPw+"</h3>");
		
	}
}











