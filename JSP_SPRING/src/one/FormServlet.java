package one;

//+ ??±? ?λΈλ¦Ώ(.java) ?΄??€ ?΄?(κ²½λ‘)
//	- ??¬?€??΄?€/?λ‘μ ?Έ/src/
//
//+ μ»΄ν?Ό κ²°κ³Ό(λ°μ΄?Έμ½λ, .class) ??Ό ?΄?(κ²½λ‘)
//	- ??¬?€??΄?€/?λ‘μ ?Έ/build/classes/
//
//+ ?λ²? ?λ‘λ ?΄?(κ²½λ‘)
//	-C:\Users\
//     user2\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ServletEx\WEB-INF\classes\
//
//+ ? ?¬ ??Όλ―Έν° ?κΈ?(UTF-8) μ²λ¦¬ ?€? ?κΈ?
//	- GET method
//		Server?€? ?? server.xml ??Ό? <Connector>
//		? URIEncoding="UTF-8" ?­λͺ©μ μΆκ???€
//		?λ²μ portλ₯? ?¬?¨?κ³? ?? <Connector> ?κ·Έμ ?€? 
//		?μ²? URI? ?¬?¨? ?κΈ?? UTF-8λ‘? μ²λ¦¬??λ‘? ?? ?€? 
//	<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443"/>
//
//	- POST method
//		?μ²? κ°μ²΄λ₯? ?¬?©?κΈ? ? ? ?Έμ½λ©? UTF-8λ‘? ?€? ??€
//		request.setCharacterEncoding("UTF-8");
//		** ??μΉ? ?Ή ?λ²λ ?΄λΆ? ?Έμ½λ©? ISO-8859-1λ‘? ?¬?©??€
//		** ?κΈ??΄ ?Ή ?λ²λ?? ?΅κ³Όν  ? ISO-8859-1 λ°©μ?Όλ‘?
//		  ???΄μ§?κ²? ??€
//		** ?κΈ? ?°?΄?°λ₯? ?¬?©?κΈ? ? ? UTF-8 ?Έμ½λ©?Όλ‘? ?€?
//		  ?©?±??€λ©? ?λ³? ?°?΄?°λ₯? ??Έ?  ? ?κ²λ?€


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
		
		//request ?μ²?κ°μ²΄?? ? ?¬ ??Όλ―Έν° κΊΌλ΄κΈ?
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// μ½μλ‘? ??Έ?κΈ?
		System.out.println("ID : "+userId);
		System.out.println("PW : "+userPw);
		
		//??΅ ?°?΄?° ?? ?€? ?κΈ?(?Έμ½λ© ?¬?¨)
		response.setContentType("text/html;charset=UTF-8");
		
		//??΅ ?°?΄?° ??±?κΈ?
		response.getWriter()
			.append("<h1>? ?¬λ°μ? ?°?΄?°</h1>")
			.append("<hr>")
			.append("<h3>??΄? : "+userId+"</h3>")
			.append("<h3>?¨?€?? : "+userPw+"</h3>");
		
	}

}
