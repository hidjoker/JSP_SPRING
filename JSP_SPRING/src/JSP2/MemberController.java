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
		 
		//joinForm ?ùÑ?ö∞Í∏?
		request.getRequestDispatcher("/view/member/joinForm.jsp")
			.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ?öîÏ≤? ?åå?ùºÎØ∏ÌÑ∞ member Í∞ùÏ≤¥?óê ?ã¥Í∏?
		Member member = new Member();
		member.setUserId(request.getParameter("userId"));
		member.setNick(request.getParameter("nick"));
		member.setEmail(request.getParameter("email"));
		
		// DAOÎ•? ?ù¥?ö©?ïú ?öå?õêÍ∞??ûÖ Ï≤òÎ¶¨
		MemberDao dao = new MemberDaoImpl();
		boolean result = dao.join(member);
		
		// VIEW?óê Í≤∞Í≥ºÍ∞? ?†Ñ?ã¨
		request.setAttribute("result", result);
		request.getRequestDispatcher("/view/member/result.jsp")
			.forward(request, response);
		
	}
}
