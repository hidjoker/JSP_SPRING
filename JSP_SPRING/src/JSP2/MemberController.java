package JSP2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//joinForm ??°κΈ?
		request.getRequestDispatcher("/view/member/joinForm.jsp")
			.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ?μ²? ??Όλ―Έν° member κ°μ²΄? ?΄κΈ?
		Member member = new Member();
		member.setUserId(request.getParameter("userId"));
		member.setNick(request.getParameter("nick"));
		member.setEmail(request.getParameter("email"));
		
		// DAOλ₯? ?΄?©? ??κ°?? μ²λ¦¬
		MemberDao dao = new MemberDaoImpl();
		boolean result = dao.join(member);
		
		// VIEW? κ²°κ³Όκ°? ? ?¬
		request.setAttribute("result", result);
		request.getRequestDispatcher("/view/member/result.jsp")
			.forward(request, response);
		
	}
}
