package file;

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

//+ 파일 업로드
//	- 클라이언트가 웹서버로 전송한 파일을 받아들이는 것
//	- 파일 업로드 라이브러리를 활용한다
//		1. commons-fileupload 라이브러리
//		2. COS 라이브러리
//
//+ commons-fileupload 라이브러리
//	- commons : Apache Project 중 하나
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
//



@WebServlet("/file/upload.do")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 업로드 form 띄우기
		RequestDispatcher rd = request.getRequestDispatcher("/file/fileUpload.jsp");
		rd.forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드된 파일 처리하기
		
		//전송 파라미터 한글 인코딩 설정 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//응답 객체 MIME설정 : HTML, 한글인코딩 UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		//응답 객체 출력 스트림
		PrintWriter out = response.getWriter();
		
		//파일 업로드 작업 시작 !!!
		
		// 1.파일업로드한 거 맞는지 확인
		//	enctype이 multipart인지 확인하는 메소드
		boolean isMultipart =ServletFileUpload.isMultipartContent(request);
		
		// 1-1. multipart/form-data가 아닐 경우
		if(!isMultipart) {
			out.println("<h1>encType이 multipart가 아님!!</h1>");
			return;
		}
		
		// 1-2. multipart/form-data일 경우
		// 파일이 전송되었을 경우
		
		// 2. 업로드 파일을 처리하는 아이템 팩토리 생성
		
		// 디스크 기반의 파일아이템 처리 API - DiskFileItemFactory
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		// 3. 업로드 아이템이 적당히 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem); //메모리처리사이즈 설정
		
		System.out.println(getServletContext().getRealPath("tmp"));
		
		// 4. 적당히 큰 아이템이면 임시파일을 만들어서 처리(디스크)
		factory.setRepository(new File(getServletContext().getRealPath("tmp")));
		
		// 5. 업로드 허용기준에 맞는 용량의 파일이면 업로드 수행
		long maxFile = 10 * 1024 * 1024 ; //10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //업로드 용량 제한 설정
		
		// 6. 업로드 데이터 파싱(추출) - 임시파일 업로드
		List<FileItem> items = null;
		
		try {
			//요청객체 request에서 전달 데이터 추출하기
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. 폼필드 처리
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			// 빈파일(비정상파일)이 업로드 되었을 때 처리 안함
			if(item.getSize() <= 0) continue;
			
			if(item.isFormField()) {
				// form-data 일 경우
				// 키=값 쌍으로 전달된 데이터일 경우
				
				out.println("폼 필드 : "+item.getFieldName()
				+", 값 : "+item.getString());
				
				if( item.getFieldName().equals("title")) {				
				}
				
			}else {
				
				// java.util.UUID
				UUID uid = UUID.randomUUID();
				System.out.println(uid);
				String u = uid.toString().split("-")[0];
				System.out.println(u);
				
				// 필요한 추가 처리
				// 데이터베이스에 업로드한 파일의 정보를 기록해둔다
				//
				// 업로드파일 PK
				// 원본 파일명
				// 저장 파열명(UUID가 적용된 파일명)
				// 업로드한 사람(userId)
				// 업로드한 시간(생략 가능)
				// 게시글 번호(첨부파일일 경우)
				
				// 파일 데이터일 경우
				File up = new File(
						getServletContext().getRealPath("upload"),item.getName()+"_"+u);
//				System.out.println(up);
//				System.out.println(up.exists());
				
				try {
					// realPath에 지정한 파일로 기록하기(실제 업로드)
					item.write(up);
					item.delete(); //임시파일 삭제하기
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
}
