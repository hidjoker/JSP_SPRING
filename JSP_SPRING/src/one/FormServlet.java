package one;

//+ ?‘?„±?•œ ?„œë¸”ë¦¿(.java) ?´?˜?Š¤ ?´?”(ê²½ë¡œ)
//	- ?›Œ?¬?Š¤?˜?´?Š¤/?”„ë¡œì ?Š¸/src/
//
//+ ì»´íŒŒ?¼ ê²°ê³¼(ë°”ì´?Š¸ì½”ë“œ, .class) ?ŒŒ?¼ ?´?”(ê²½ë¡œ)
//	- ?›Œ?¬?Š¤?˜?´?Š¤/?”„ë¡œì ?Š¸/build/classes/
//
//+ ?„œë²? ?—…ë¡œë“œ ?´?”(ê²½ë¡œ)
//	-C:\Users\
//     user2\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ServletEx\WEB-INF\classes\
//
//+ ? „?‹¬ ?ŒŒ?¼ë¯¸í„° ?•œê¸?(UTF-8) ì²˜ë¦¬ ?„¤? •?•˜ê¸?
//	- GET method
//		Server?„¤? •?—?„œ server.xml ?ŒŒ?¼?˜ <Connector>
//		?— URIEncoding="UTF-8" ?•­ëª©ì„ ì¶”ê??•œ?‹¤
//		?„œë²„ì˜ portë¥? ?¬?•¨?•˜ê³? ?ˆ?Š” <Connector> ?ƒœê·¸ì— ?„¤? •
//		?š”ì²? URI?— ?¬?•¨?œ ?•œê¸??„ UTF-8ë¡? ì²˜ë¦¬?˜?„ë¡? ?•˜?Š” ?„¤? •
//	<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443"/>
//
//	- POST method
//		?š”ì²? ê°ì²´ë¥? ?‚¬?š©?•˜ê¸? ? „?— ?¸ì½”ë”©?„ UTF-8ë¡? ?„¤? •?•œ?‹¤
//		request.setCharacterEncoding("UTF-8");
//		** ?•„?ŒŒì¹? ?›¹ ?„œë²„ëŠ” ?‚´ë¶? ?¸ì½”ë”©?„ ISO-8859-1ë¡? ?‚¬?š©?•œ?‹¤
//		** ?•œê¸??´ ?›¹ ?„œë²„ë?? ?†µê³¼í•  ?•Œ ISO-8859-1 ë°©ì‹?œ¼ë¡?
//		  ?‚˜?ˆ„?–´ì§?ê²? ?œ?‹¤
//		** ?•œê¸? ?°?´?„°ë¥? ?‚¬?š©?•˜ê¸? ? „?— UTF-8 ?¸ì½”ë”©?œ¼ë¡? ?‹¤?‹œ
//		  ?•©?„±?•œ?‹¤ë©? ?›ë³? ?°?´?„°ë¥? ?™•?¸?•  ?ˆ˜ ?ˆê²Œëœ?‹¤


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//request ?š”ì²?ê°ì²´?—?„œ ? „?‹¬ ?ŒŒ?¼ë¯¸í„° êº¼ë‚´ê¸?
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// ì½˜ì†”ë¡? ?™•?¸?•˜ê¸?
		System.out.println("ID : "+userId);
		System.out.println("PW : "+userPw);
		
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
