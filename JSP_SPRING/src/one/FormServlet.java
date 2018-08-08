package one;

//+ ?��?��?�� ?��블릿(.java) ?��?��?�� ?��?��(경로)
//	- ?��?��?��?��?��?��/?��로젝?��/src/
//
//+ 컴파?�� 결과(바이?��코드, .class) ?��?�� ?��?��(경로)
//	- ?��?��?��?��?��?��/?��로젝?��/build/classes/
//
//+ ?���? ?��로드 ?��?��(경로)
//	-C:\Users\
//     user2\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ServletEx\WEB-INF\classes\
//
//+ ?��?�� ?��?��미터 ?���?(UTF-8) 처리 ?��?��?���?
//	- GET method
//		Server?��?��?��?�� server.xml ?��?��?�� <Connector>
//		?�� URIEncoding="UTF-8" ?��목을 추�??��?��
//		?��버의 port�? ?��?��?���? ?��?�� <Connector> ?��그에 ?��?��
//		?���? URI?�� ?��?��?�� ?���??�� UTF-8�? 처리?��?���? ?��?�� ?��?��
//	<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443"/>
//
//	- POST method
//		?���? 객체�? ?��?��?���? ?��?�� ?��코딩?�� UTF-8�? ?��?��?��?��
//		request.setCharacterEncoding("UTF-8");
//		** ?��?���? ?�� ?��버는 ?���? ?��코딩?�� ISO-8859-1�? ?��?��?��?��
//		** ?���??�� ?�� ?��버�?? ?��과할 ?�� ISO-8859-1 방식?���?
//		  ?��?��?���?�? ?��?��
//		** ?���? ?��?��?���? ?��?��?���? ?��?�� UTF-8 ?��코딩?���? ?��?��
//		  ?��?��?��?���? ?���? ?��?��?���? ?��?��?�� ?�� ?��게된?��


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
		
		//request ?���?객체?��?�� ?��?�� ?��?��미터 꺼내�?
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// 콘솔�? ?��?��?���?
		System.out.println("ID : "+userId);
		System.out.println("PW : "+userPw);
		
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
