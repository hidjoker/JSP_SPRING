package JSP4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//+ ?��?�� ?��로드
//	- ?��?��?��?��?���? ?��?��버로 ?��?��?�� ?��?��?�� 받아?��?��?�� �?
//	- ?��?�� ?��로드 ?��?��브러리�?? ?��?��?��?��
//		1. commons-fileupload ?��?��브러�?
//		2. COS ?��?��브러�?
//
//+ commons-fileupload ?��?��브러�?
//	- commons : Apache Project �? ?��?��
//		( www.apache.org )
//	- Apache Commons Fileupload
//		http://commons.apache.org/proper/commons-fileupload/
//	- Apache Commons IO
//		http://commons.apache.org/proper/commons-io/
//+ API Docs
//	- Commons-Fileupload API Docs
//	http://commons.apache.org/proper/commons-fileupload/javadocs/api-release/index.html
//	- Commons-IO API Docs
//	http://commons.apache.org/proper/commons-io/javadocs/api-release/index.html

//+ <form> ?��그의 ?��코딩 ?��?��
//	** enctype ?��?��?�� ?��?��?��?���? post method�? ?��?��?��?��
//	- enctype="application/x-www-form-urlencoded"
//		<form> ?��그의 기본 ?��코딩 방식
//		submit ?�� ?��?��?���? 쿼리?��?���? ?��?���? �??��?���??��
//		ex) ?age=123&name=Alice
//		 만약 ?�� ?��코딩방식?���? file?�� ?��?��?���? ?��?��?��
//		?��름만 ?��?��?��?��(String�? ?��?��?���? ?���?)
//	- enctype="multipart/form-data"
//		?��?��?�� ?��?��?�� <form>?��그로 submit?�� ?�� ?��?���? ?��?�� 방식
//
//+ commons-fileupload�? ?��?��?�� ?��?��?��로드 ?���?
//	0. commons-fileupload ?��?��브러�? ?���?
//	1. ?��?��처리?�� ?��?��?��  request ?���? ?��?��
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if( isMultipart ){
//			// encType="multipart/form-data"
//		}else{
//			// encType?�� "multipart/form-data"�? ?��?�� 경우
//		}
//	2. ?��로드 ?��?��?�� 처리?��?�� ?��?��?�� ?��?���? ?��?��
//		DiskFileItemFactory factory;
//	3. ?��로드 ?��?��?��?�� ?��?��?�� ?��?���? 메모리에?�� 처리
//		factory.setSizeThreshold(1MB);
//	4. ?��?��?�� ?�� ?��?��?��?���? ?��?��?��?��?�� 만들?��?�� 처리(?��?��?��)
//		factory.setRepository( ?��?��?��?�� );
//	5. ?��로드 ?��?��기�??�� 맞는 ?��?��?�� ?��?��?���? ?��로드 ?��?��
//		upload = new ServletFileUpload(factory)
//		upload.setSizeMax(10MB);
//	6. ?��로드 ?��?��?�� ?��?��(추출) - ?��?��?��?�� ?��로드
//		upload.parseRequest(request);
//	7. ?��?��?�� 처리
//		7-1. 빈파?��(비정?��?��?��)?�� ?��로드 ?��?��?�� ?�� 처리 ?��?��
//		7-2. form-data ?�� 경우
//		7-3. ?��?�� ?��?��?��?�� 경우
//	7-3. ?��?�� ?��?���? ???��?�� ?��?��?���? ?��?�� 경로?�� ???��
//			write( File )
//		?��?�� ?��?���? ???��?�� ?��?��?���? ?��?��
//			delete()
//		** ?��?�� 경로?�� ???��?���? 같�? ?��름의 ?��?��?? ?��?��?��?��진다
//		** 같�? ?��름의 ?��?��?�� 처리?���? ?��?�� ?��?��명을 �?경해�??��
//		** �?경되?�� ?��?�� ?��름�? java.util.UUID�? ?��?��?���? 좋다
//		** ?��로드?�� ?��?��?�� ?��보�?? DB?�� 기록?��?���? ?��?��?��?��
//+ UUID, Universally Unique Identifier
//	- 범용?�� 고유 ?��별자
//	- java.util.UUID
//	- 32개의 16진수?? 4개의 '-'�? ?��루어�? ?��별값
//	- ?��?�� : 8�?-4�?-4�?-4�?-12�? (�? ?��릿수?�� 16진수)
//	- ?��?�� : bc4b96e9 - 9f85-402c-a849-839f9a9b9015
//	- ?��?��방법
//		1. UUID.randomUUID()�? ?��?�� ?��별자�? ?��?��?��
//		(UUID.randomUUID.toString()?���? 문자?���? ?��?�� 것도 �??��)
//		2. ?��?���? ?��별자 문자?��?�� split("-")?���? ?��?��?�� ?��?��?��?��
//		ex)
//			String uniqueID = UUID.randomUUID().toString();
//			String uId_1 = uniqueID.split("-")[0]; //8?���?
//			String uId_2 = uniqueId.split("-")[0]
//							+uniqueId.split("-")[1]; //12?���?
//



@WebServlet("/file/upload.do")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?��?�� ?��로드 form ?��?���?
		RequestDispatcher rd = request.getRequestDispatcher("/file/fileUpload.jsp");
		rd.forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?��로드?�� ?��?�� 처리?���?
		
		//?��?�� ?��?��미터 ?���? ?��코딩 ?��?�� : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//?��?�� 객체 MIME?��?�� : HTML, ?���??��코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		//?��?�� 객체 출력 ?��?���?
		PrintWriter out = response.getWriter();
		
		//?��?�� ?��로드 ?��?�� ?��?�� !!!
		
		// 1.?��?��?��로드?�� �? 맞는�? ?��?��
		//	enctype?�� multipart?���? ?��?��?��?�� 메소?��
		boolean isMultipart =ServletFileUpload.isMultipartContent(request);
		
		// 1-1. multipart/form-data�? ?��?�� 경우
		if(!isMultipart) {
			out.println("<h1>encType?�� multipart�? ?��?��!!</h1>");
			return;
		}
		
		// 1-2. multipart/form-data?�� 경우
		// ?��?��?�� ?��?��?��?��?�� 경우
		
		// 2. ?��로드 ?��?��?�� 처리?��?�� ?��?��?�� ?��?���? ?��?��
		
		// ?��?��?�� 기반?�� ?��?��?��?��?�� 처리 API - DiskFileItemFactory
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		// 3. ?��로드 ?��?��?��?�� ?��?��?�� ?��?���? 메모리에?�� 처리
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem); //메모리처리사?���? ?��?��
		
		System.out.println(getServletContext().getRealPath("tmp"));
		
		// 4. ?��?��?�� ?�� ?��?��?��?���? ?��?��?��?��?�� 만들?��?�� 처리(?��?��?��)
		factory.setRepository(new File(getServletContext().getRealPath("tmp")));
		
		// 5. ?��로드 ?��?��기�??�� 맞는 ?��?��?�� ?��?��?���? ?��로드 ?��?��
		long maxFile = 10 * 1024 * 1024 ; //10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //?��로드 ?��?�� ?��?�� ?��?��
		
		// 6. ?��로드 ?��?��?�� ?��?��(추출) - ?��?��?��?�� ?��로드
		List<FileItem> items = null;
		
		try {
			//?���?객체 request?��?�� ?��?�� ?��?��?�� 추출?���?
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. ?��?��?�� 처리
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			// 빈파?��(비정?��?��?��)?�� ?��로드 ?��?��?�� ?�� 처리 ?��?��
			if(item.getSize() <= 0) continue;
			
			if(item.isFormField()) {
				// form-data ?�� 경우
				// ?��=�? ?��?���? ?��?��?�� ?��?��?��?�� 경우
				
				out.println("?�� ?��?�� : "+item.getFieldName()
				+", �? : "+item.getString());
				
				if( item.getFieldName().equals("title")) {				
				}
				
			}else {
				
				// java.util.UUID
				UUID uid = UUID.randomUUID();
				System.out.println(uid);
				String u = uid.toString().split("-")[0];
				System.out.println(u);
				
				// ?��?��?�� 추�? 처리
				// ?��?��?��베이?��?�� ?��로드?�� ?��?��?�� ?��보�?? 기록?��?��?��
				//
				// ?��로드?��?�� PK
				// ?���? ?��?���?
				// ???�� ?��?���?(UUID�? ?��?��?�� ?��?���?)
				// ?��로드?�� ?��?��(userId)
				// ?��로드?�� ?���?(?��?�� �??��)
				// 게시�? 번호(첨�??��?��?�� 경우)
				
				// ?��?�� ?��?��?��?�� 경우
				File up = new File(
						getServletContext().getRealPath("upload"),item.getName()+"_"+u);
//				System.out.println(up);
//				System.out.println(up.exists());
				
				try {
					// realPath?�� �??��?�� ?��?���? 기록?���?(?��?�� ?��로드)
					item.write(up);
					item.delete(); //?��?��?��?�� ?��?��?���?
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
}
