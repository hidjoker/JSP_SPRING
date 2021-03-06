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

//+ ??ผ ?๋ก๋
//	- ?ด?ผ?ด?ธ?ธ๊ฐ? ?น?๋ฒ๋ก ? ?ก? ??ผ? ๋ฐ์?ค?ด? ๊ฒ?
//	- ??ผ ?๋ก๋ ?ผ?ด๋ธ๋ฌ๋ฆฌ๋?? ??ฉ??ค
//		1. commons-fileupload ?ผ?ด๋ธ๋ฌ๋ฆ?
//		2. COS ?ผ?ด๋ธ๋ฌ๋ฆ?
//
//+ commons-fileupload ?ผ?ด๋ธ๋ฌ๋ฆ?
//	- commons : Apache Project ์ค? ??
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

//+ <form> ?๊ทธ์ ?ธ์ฝ๋ฉ ?ค? 
//	** enctype ??ฑ? ?ค? ?? ค๋ฉ? post method๋ฅ? ?ฌ?ฉ??ค
//	- enctype="application/x-www-form-urlencoded"
//		<form> ?๊ทธ์ ๊ธฐ๋ณธ ?ธ์ฝ๋ฉ ๋ฐฉ์
//		submit ?  ?ฐ?ด?ฐ๋ฅ? ์ฟผ๋ฆฌ?ค?ธ๋ง? ??๋ก? ๋ณ???ด์ค??ค
//		ex) ?age=123&name=Alice
//		 ๋ง์ฝ ?ด ?ธ์ฝ๋ฉ๋ฐฉ์?ผ๋ก? file? ? ?ก?๋ฉ? ??ผ?
//		?ด๋ฆ๋ง ? ?ก??ค(String๋ง? ? ?ก?๊ธ? ?๋ฌ?)
//	- enctype="multipart/form-data"
//		??ผ? ?ด?ฉ? <form>?๊ทธ๋ก submit?  ? ??๋ก? ?? ๋ฐฉ์
//
//+ commons-fileupload๋ฅ? ?ด?ฉ? ??ผ?๋ก๋ ? ์ฐ?
//	0. commons-fileupload ?ผ?ด๋ธ๋ฌ๋ฆ? ?ค์น?
//	1. ??ผ์ฒ๋ฆฌ? ? ?จ?  request ?ธ์ง? ??ธ
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if( isMultipart ){
//			// encType="multipart/form-data"
//		}else{
//			// encType?ด "multipart/form-data"๊ฐ? ?? ๊ฒฝ์ฐ
//		}
//	2. ?๋ก๋ ??ผ? ์ฒ๋ฆฌ?? ??ด? ?ฉ? ๋ฆ? ??ฑ
//		DiskFileItemFactory factory;
//	3. ?๋ก๋ ??ด??ด ? ?น? ??ผ๋ฉ? ๋ฉ๋ชจ๋ฆฌ์? ์ฒ๋ฆฌ
//		factory.setSizeThreshold(1MB);
//	4. ? ?น? ?ฐ ??ด??ด๋ฉ? ????ผ? ๋ง๋ค?ด? ์ฒ๋ฆฌ(??ค?ฌ)
//		factory.setRepository( ???ด? );
//	5. ?๋ก๋ ??ฉ๊ธฐ์?? ๋ง๋ ?ฉ?? ??ผ?ด๋ฉ? ?๋ก๋ ??
//		upload = new ServletFileUpload(factory)
//		upload.setSizeMax(10MB);
//	6. ?๋ก๋ ?ฐ?ด?ฐ ??ฑ(์ถ์ถ) - ????ผ ?๋ก๋
//		upload.parseRequest(request);
//	7. ?ผ?? ์ฒ๋ฆฌ
//		7-1. ๋นํ?ผ(๋น์ ???ผ)?ด ?๋ก๋ ??? ? ์ฒ๋ฆฌ ??จ
//		7-2. form-data ?ผ ๊ฒฝ์ฐ
//		7-3. ??ผ ?ฐ?ด?ฐ?ผ ๊ฒฝ์ฐ
//	7-3. ?? ??ผ๋ก? ???ฅ? ?ฐ?ด?ฐ๋ฅ? ?ค?  ๊ฒฝ๋ก? ???ฅ
//			write( File )
//		?? ??ผ๋ก? ???ฅ? ?ฐ?ด?ฐ๋ฅ? ?ญ? 
//			delete()
//		** ?ค?  ๊ฒฝ๋ก? ???ฅ?๋ฉ? ๊ฐ์? ?ด๋ฆ์ ??ผ?? ?ฎ?ด??์ง๋ค
//		** ๊ฐ์? ?ด๋ฆ์ ??ผ? ์ฒ๋ฆฌ?๊ธ? ??ด ??ผ๋ช์ ๋ณ?๊ฒฝํด์ค??ค
//		** ๋ณ?๊ฒฝ๋? ??ผ ?ด๋ฆ์? java.util.UUID๋ฅ? ?ด?ฉ?๋ฉ? ์ข๋ค
//		** ?๋ก๋? ??ผ? ? ๋ณด๋?? DB? ๊ธฐ๋ก?ด?๊ณ? ??ฉ??ค
//+ UUID, Universally Unique Identifier
//	- ๋ฒ์ฉ?  ๊ณ ์  ?๋ณ์
//	- java.util.UUID
//	- 32๊ฐ์ 16์ง์?? 4๊ฐ์ '-'๋ก? ?ด๋ฃจ์ด์ง? ?๋ณ๊ฐ
//	- ?? : 8๊ฐ?-4๊ฐ?-4๊ฐ?-4๊ฐ?-12๊ฐ? (๊ฐ? ?๋ฆฟ์? 16์ง์)
//	- ?? : bc4b96e9 - 9f85-402c-a849-839f9a9b9015
//	- ?ฌ?ฉ๋ฐฉ๋ฒ
//		1. UUID.randomUUID()๋ก? ??ค ?๋ณ์๋ฅ? ?ป??ค
//		(UUID.randomUUID.toString()?ผ๋ก? ๋ฌธ์?ด๋ก? ?ป? ๊ฒ๋ ๊ฐ??ฅ)
//		2. ?ป?ด์ง? ?๋ณ์ ๋ฌธ์?ด? split("-")?ผ๋ก? ??ผ?ด ?ฌ?ฉ??ค
//		ex)
//			String uniqueID = UUID.randomUUID().toString();
//			String uId_1 = uniqueID.split("-")[0]; //8?๋ฆ?
//			String uId_2 = uniqueId.split("-")[0]
//							+uniqueId.split("-")[1]; //12?๋ฆ?
//



@WebServlet("/file/upload.do")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//??ผ ?๋ก๋ form ??ฐ๊ธ?
		RequestDispatcher rd = request.getRequestDispatcher("/file/fileUpload.jsp");
		rd.forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?๋ก๋? ??ผ ์ฒ๋ฆฌ?๊ธ?
		
		//? ?ก ??ผ๋ฏธํฐ ?๊ธ? ?ธ์ฝ๋ฉ ?ค?  : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//??ต ๊ฐ์ฒด MIME?ค?  : HTML, ?๊ธ??ธ์ฝ๋ฉ UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		//??ต ๊ฐ์ฒด ์ถ๋ ฅ ?ค?ธ๋ฆ?
		PrintWriter out = response.getWriter();
		
		//??ผ ?๋ก๋ ?? ?? !!!
		
		// 1.??ผ?๋ก๋? ๊ฑ? ๋ง๋์ง? ??ธ
		//	enctype?ด multipart?ธ์ง? ??ธ?? ๋ฉ์?
		boolean isMultipart =ServletFileUpload.isMultipartContent(request);
		
		// 1-1. multipart/form-data๊ฐ? ?? ๊ฒฝ์ฐ
		if(!isMultipart) {
			out.println("<h1>encType?ด multipart๊ฐ? ??!!</h1>");
			return;
		}
		
		// 1-2. multipart/form-data?ผ ๊ฒฝ์ฐ
		// ??ผ?ด ? ?ก??? ๊ฒฝ์ฐ
		
		// 2. ?๋ก๋ ??ผ? ์ฒ๋ฆฌ?? ??ด? ?ฉ? ๋ฆ? ??ฑ
		
		// ??ค?ฌ ๊ธฐ๋ฐ? ??ผ??ด? ์ฒ๋ฆฌ API - DiskFileItemFactory
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		// 3. ?๋ก๋ ??ด??ด ? ?น? ??ผ๋ฉ? ๋ฉ๋ชจ๋ฆฌ์? ์ฒ๋ฆฌ
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem); //๋ฉ๋ชจ๋ฆฌ์ฒ๋ฆฌ์ฌ?ด์ฆ? ?ค? 
		
		System.out.println(getServletContext().getRealPath("tmp"));
		
		// 4. ? ?น? ?ฐ ??ด??ด๋ฉ? ????ผ? ๋ง๋ค?ด? ์ฒ๋ฆฌ(??ค?ฌ)
		factory.setRepository(new File(getServletContext().getRealPath("tmp")));
		
		// 5. ?๋ก๋ ??ฉ๊ธฐ์?? ๋ง๋ ?ฉ?? ??ผ?ด๋ฉ? ?๋ก๋ ??
		long maxFile = 10 * 1024 * 1024 ; //10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //?๋ก๋ ?ฉ? ? ? ?ค? 
		
		// 6. ?๋ก๋ ?ฐ?ด?ฐ ??ฑ(์ถ์ถ) - ????ผ ?๋ก๋
		List<FileItem> items = null;
		
		try {
			//?์ฒ?๊ฐ์ฒด request?? ? ?ฌ ?ฐ?ด?ฐ ์ถ์ถ?๊ธ?
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. ?ผ?? ์ฒ๋ฆฌ
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			// ๋นํ?ผ(๋น์ ???ผ)?ด ?๋ก๋ ??? ? ์ฒ๋ฆฌ ??จ
			if(item.getSize() <= 0) continue;
			
			if(item.isFormField()) {
				// form-data ?ผ ๊ฒฝ์ฐ
				// ?ค=๊ฐ? ??ผ๋ก? ? ?ฌ? ?ฐ?ด?ฐ?ผ ๊ฒฝ์ฐ
				
				out.println("?ผ ?? : "+item.getFieldName()
				+", ๊ฐ? : "+item.getString());
				
				if( item.getFieldName().equals("title")) {				
				}
				
			}else {
				
				// java.util.UUID
				UUID uid = UUID.randomUUID();
				System.out.println(uid);
				String u = uid.toString().split("-")[0];
				System.out.println(u);
				
				// ??? ์ถ๊? ์ฒ๋ฆฌ
				// ?ฐ?ด?ฐ๋ฒ ์ด?ค? ?๋ก๋? ??ผ? ? ๋ณด๋?? ๊ธฐ๋ก?ด??ค
				//
				// ?๋ก๋??ผ PK
				// ?๋ณ? ??ผ๋ช?
				// ???ฅ ??ด๋ช?(UUID๊ฐ? ? ?ฉ? ??ผ๋ช?)
				// ?๋ก๋? ?ฌ?(userId)
				// ?๋ก๋? ?๊ฐ?(??ต ๊ฐ??ฅ)
				// ๊ฒ์๊ธ? ๋ฒํธ(์ฒจ๋???ผ?ผ ๊ฒฝ์ฐ)
				
				// ??ผ ?ฐ?ด?ฐ?ผ ๊ฒฝ์ฐ
				File up = new File(
						getServletContext().getRealPath("upload"),item.getName()+"_"+u);
//				System.out.println(up);
//				System.out.println(up.exists());
				
				try {
					// realPath? ์ง?? ? ??ผ๋ก? ๊ธฐ๋ก?๊ธ?(?ค?  ?๋ก๋)
					item.write(up);
					item.delete(); //????ผ ?ญ? ?๊ธ?
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
}
