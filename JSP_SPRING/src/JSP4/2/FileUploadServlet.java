package file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

//+ <form> 태그의 인코딩 설정
//	** enctype 속성을 설정하려면 post method를 사용한다
//	- enctype="application/x-www-form-urlencoded"
//		<form> 태그의 기본 인코딩 방식
//		submit 할 데이터를 쿼리스트링 형태로 변환해준다
//		ex) ?age=123&name=Alice
//		 만약 이 인코딩방식으로 file을 전송하면 파일의
//		이름만 전송된다(String만 전송하기 때문)
//	- enctype="multipart/form-data"
//		파일의 내용을 <form>태그로 submit할 수 있도록 하는 방식
//
//+ commons-fileupload를 이용한 파일업로드 절차
//	0. commons-fileupload 라이브러리 설치
//	1. 파일처리에 유효한  request 인지 확인
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if( isMultipart ){
//			// encType="multipart/form-data"
//		}else{
//			// encType이 "multipart/form-data"가 아닌 경우
//		}
//	2. 업로드 파일을 처리하는 아이템 팩토리 생성
//		DiskFileItemFactory factory;
//	3. 업로드 아이템이 적당히 작으면 메모리에서 처리
//		factory.setSizeThreshold(1MB);
//	4. 적당히 큰 아이템이면 임시파일을 만들어서 처리(디스크)
//		factory.setRepository( 임시폴더 );
//	5. 업로드 허용기준에 맞는 용량의 파일이면 업로드 수행
//		upload = new ServletFileUpload(factory)
//		upload.setSizeMax(10MB);
//	6. 업로드 데이터 파싱(추출) - 임시파일 업로드
//		upload.parseRequest(request);
//	7. 폼필드 처리
//		7-1. 빈파일(비정상파일)이 업로드 되었을 때 처리 안함
//		7-2. form-data 일 경우
//		7-3. 파일 데이터일 경우
//	7-3. 임시 파일로 저장된 데이터를 실제 경로에 저장
//			write( File )
//		임시 파일로 저장된 데이터를 삭제
//			delete()
//		** 실제 경로에 저장하면 같은 이름의 파일은 덮어씌워진다
//		** 같은 이름의 파일을 처리하기 위해 파일명을 변경해준다
//		** 변경되는 파일 이름은 java.util.UUID를 이용하면 좋다
//		** 업로드된 파일의 정보를 DB에 기록해두고 활용한다
//+ UUID, Universally Unique Identifier
//	- 범용적 고유 식별자
//	- java.util.UUID
//	- 32개의 16진수와 4개의 '-'로 이루어진 식별값
//	- 형식 : 8개-4개-4개-4개-12개 (각 자릿수는 16진수)
//	- 예시 : bc4b96e9 - 9f85-402c-a849-839f9a9b9015
//	- 사용방법
//		1. UUID.randomUUID()로 랜덤 식별자를 얻는다
//		(UUID.randomUUID.toString()으로 문자열로 얻는 것도 가능)
//		2. 얻어진 식별자 문자열을 split("-")으로 잘라내 사용한다
//		ex)
//			String uniqueID = UUID.randomUUID().toString();
//			String uId_1 = uniqueID.split("-")[0]; //8자리
//			String uId_2 = uniqueId.split("-")[0]
//							+uniqueId.split("-")[1]; //12자리



@WebServlet("/file/upload_cos.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/fileUpload.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HTTP 요청/응답 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 응답객체 출력 스트림
		PrintWriter out = response.getWriter();
		
		//--- MultipartRequest 생성자 매개변수 준비 ---
		// 1. HttpServletRequest request 
		//		따로 준비할 필요 없음(doPost메소드가 가지고 있음)
		// 2. String saveDirectory
		//		서버의 실제 경로로 지정한다
		
		//서블릿 컨텍스트, 서블릿의 파일시스템 정보를 가지고 있음
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");
		// 3. int MaxPostSize
		//		업로드 제한 용량을 바이트단위로 지정한다
		int maxPostSize = 10 * 1024 * 1024; //10MB
		
		// 4. String encoding
		//		업로드 정보 인코딩 방식 지정
		String encoding = "UTF-8";
		
		// 5. FileRenamePolicy policy
		//		파일이름이 중복되었을 때 처리하는 방식을 지정한다
		FileRenamePolicy policy
			= new DefaultFileRenamePolicy();
		//---------------------------------------
		
		// MultipartRequest 생성
		//  파일업로드 관리하는 클래스
		MultipartRequest mul = new MultipartRequest(
				request,
				saveDirectory,
				maxPostSize,
				encoding,
				policy);	
	}
}
