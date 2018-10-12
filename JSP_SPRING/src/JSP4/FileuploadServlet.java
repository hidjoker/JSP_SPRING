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

//+ ?ŒŒ?¼ ?—…ë¡œë“œ
//	- ?´?¼?´?–¸?Š¸ê°? ?›¹?„œë²„ë¡œ ? „?†¡?•œ ?ŒŒ?¼?„ ë°›ì•„?“¤?´?Š” ê²?
//	- ?ŒŒ?¼ ?—…ë¡œë“œ ?¼?´ë¸ŒëŸ¬ë¦¬ë?? ?™œ?š©?•œ?‹¤
//		1. commons-fileupload ?¼?´ë¸ŒëŸ¬ë¦?
//		2. COS ?¼?´ë¸ŒëŸ¬ë¦?
//
//+ commons-fileupload ?¼?´ë¸ŒëŸ¬ë¦?
//	- commons : Apache Project ì¤? ?•˜?‚˜
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

//+ <form> ?ƒœê·¸ì˜ ?¸ì½”ë”© ?„¤? •
//	** enctype ?†?„±?„ ?„¤? •?•˜? ¤ë©? post methodë¥? ?‚¬?š©?•œ?‹¤
//	- enctype="application/x-www-form-urlencoded"
//		<form> ?ƒœê·¸ì˜ ê¸°ë³¸ ?¸ì½”ë”© ë°©ì‹
//		submit ?•  ?°?´?„°ë¥? ì¿¼ë¦¬?Š¤?Š¸ë§? ?˜•?ƒœë¡? ë³??™˜?•´ì¤??‹¤
//		ex) ?age=123&name=Alice
//		 ë§Œì•½ ?´ ?¸ì½”ë”©ë°©ì‹?œ¼ë¡? file?„ ? „?†¡?•˜ë©? ?ŒŒ?¼?˜
//		?´ë¦„ë§Œ ? „?†¡?œ?‹¤(Stringë§? ? „?†¡?•˜ê¸? ?•Œë¬?)
//	- enctype="multipart/form-data"
//		?ŒŒ?¼?˜ ?‚´?š©?„ <form>?ƒœê·¸ë¡œ submit?•  ?ˆ˜ ?ˆ?„ë¡? ?•˜?Š” ë°©ì‹
//
//+ commons-fileuploadë¥? ?´?š©?•œ ?ŒŒ?¼?—…ë¡œë“œ ? ˆì°?
//	0. commons-fileupload ?¼?´ë¸ŒëŸ¬ë¦? ?„¤ì¹?
//	1. ?ŒŒ?¼ì²˜ë¦¬?— ?œ ?š¨?•œ  request ?¸ì§? ?™•?¸
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if( isMultipart ){
//			// encType="multipart/form-data"
//		}else{
//			// encType?´ "multipart/form-data"ê°? ?•„?‹Œ ê²½ìš°
//		}
//	2. ?—…ë¡œë“œ ?ŒŒ?¼?„ ì²˜ë¦¬?•˜?Š” ?•„?´?…œ ?Œ©?† ë¦? ?ƒ?„±
//		DiskFileItemFactory factory;
//	3. ?—…ë¡œë“œ ?•„?´?…œ?´ ? ?‹¹?ˆ ?‘?œ¼ë©? ë©”ëª¨ë¦¬ì—?„œ ì²˜ë¦¬
//		factory.setSizeThreshold(1MB);
//	4. ? ?‹¹?ˆ ?° ?•„?´?…œ?´ë©? ?„?‹œ?ŒŒ?¼?„ ë§Œë“¤?–´?„œ ì²˜ë¦¬(?””?Š¤?¬)
//		factory.setRepository( ?„?‹œ?´?” );
//	5. ?—…ë¡œë“œ ?—ˆ?š©ê¸°ì??— ë§ëŠ” ?š©?Ÿ‰?˜ ?ŒŒ?¼?´ë©? ?—…ë¡œë“œ ?ˆ˜?–‰
//		upload = new ServletFileUpload(factory)
//		upload.setSizeMax(10MB);
//	6. ?—…ë¡œë“œ ?°?´?„° ?ŒŒ?‹±(ì¶”ì¶œ) - ?„?‹œ?ŒŒ?¼ ?—…ë¡œë“œ
//		upload.parseRequest(request);
//	7. ?¼?•„?“œ ì²˜ë¦¬
//		7-1. ë¹ˆíŒŒ?¼(ë¹„ì •?ƒ?ŒŒ?¼)?´ ?—…ë¡œë“œ ?˜?—ˆ?„ ?•Œ ì²˜ë¦¬ ?•ˆ?•¨
//		7-2. form-data ?¼ ê²½ìš°
//		7-3. ?ŒŒ?¼ ?°?´?„°?¼ ê²½ìš°
//	7-3. ?„?‹œ ?ŒŒ?¼ë¡? ???¥?œ ?°?´?„°ë¥? ?‹¤? œ ê²½ë¡œ?— ???¥
//			write( File )
//		?„?‹œ ?ŒŒ?¼ë¡? ???¥?œ ?°?´?„°ë¥? ?‚­? œ
//			delete()
//		** ?‹¤? œ ê²½ë¡œ?— ???¥?•˜ë©? ê°™ì? ?´ë¦„ì˜ ?ŒŒ?¼?? ?®?–´?”Œ?›Œì§„ë‹¤
//		** ê°™ì? ?´ë¦„ì˜ ?ŒŒ?¼?„ ì²˜ë¦¬?•˜ê¸? ?œ„?•´ ?ŒŒ?¼ëª…ì„ ë³?ê²½í•´ì¤??‹¤
//		** ë³?ê²½ë˜?Š” ?ŒŒ?¼ ?´ë¦„ì? java.util.UUIDë¥? ?´?š©?•˜ë©? ì¢‹ë‹¤
//		** ?—…ë¡œë“œ?œ ?ŒŒ?¼?˜ ? •ë³´ë?? DB?— ê¸°ë¡?•´?‘ê³? ?™œ?š©?•œ?‹¤
//+ UUID, Universally Unique Identifier
//	- ë²”ìš©?  ê³ ìœ  ?‹ë³„ì
//	- java.util.UUID
//	- 32ê°œì˜ 16ì§„ìˆ˜?? 4ê°œì˜ '-'ë¡? ?´ë£¨ì–´ì§? ?‹ë³„ê°’
//	- ?˜•?‹ : 8ê°?-4ê°?-4ê°?-4ê°?-12ê°? (ê°? ?ë¦¿ìˆ˜?Š” 16ì§„ìˆ˜)
//	- ?˜ˆ?‹œ : bc4b96e9 - 9f85-402c-a849-839f9a9b9015
//	- ?‚¬?š©ë°©ë²•
//		1. UUID.randomUUID()ë¡? ?œ?¤ ?‹ë³„ìë¥? ?–»?Š”?‹¤
//		(UUID.randomUUID.toString()?œ¼ë¡? ë¬¸ì?—´ë¡? ?–»?Š” ê²ƒë„ ê°??Š¥)
//		2. ?–»?–´ì§? ?‹ë³„ì ë¬¸ì?—´?„ split("-")?œ¼ë¡? ?˜?¼?‚´ ?‚¬?š©?•œ?‹¤
//		ex)
//			String uniqueID = UUID.randomUUID().toString();
//			String uId_1 = uniqueID.split("-")[0]; //8?ë¦?
//			String uId_2 = uniqueId.split("-")[0]
//							+uniqueId.split("-")[1]; //12?ë¦?
//



@WebServlet("/file/upload.do")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?ŒŒ?¼ ?—…ë¡œë“œ form ?„?š°ê¸?
		RequestDispatcher rd = request.getRequestDispatcher("/file/fileUpload.jsp");
		rd.forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?—…ë¡œë“œ?œ ?ŒŒ?¼ ì²˜ë¦¬?•˜ê¸?
		
		//? „?†¡ ?ŒŒ?¼ë¯¸í„° ?•œê¸? ?¸ì½”ë”© ?„¤? • : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//?‘?‹µ ê°ì²´ MIME?„¤? • : HTML, ?•œê¸??¸ì½”ë”© UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		//?‘?‹µ ê°ì²´ ì¶œë ¥ ?Š¤?Š¸ë¦?
		PrintWriter out = response.getWriter();
		
		//?ŒŒ?¼ ?—…ë¡œë“œ ?‘?—… ?‹œ?‘ !!!
		
		// 1.?ŒŒ?¼?—…ë¡œë“œ?•œ ê±? ë§ëŠ”ì§? ?™•?¸
		//	enctype?´ multipart?¸ì§? ?™•?¸?•˜?Š” ë©”ì†Œ?“œ
		boolean isMultipart =ServletFileUpload.isMultipartContent(request);
		
		// 1-1. multipart/form-dataê°? ?•„?‹ ê²½ìš°
		if(!isMultipart) {
			out.println("<h1>encType?´ multipartê°? ?•„?‹˜!!</h1>");
			return;
		}
		
		// 1-2. multipart/form-data?¼ ê²½ìš°
		// ?ŒŒ?¼?´ ? „?†¡?˜?—ˆ?„ ê²½ìš°
		
		// 2. ?—…ë¡œë“œ ?ŒŒ?¼?„ ì²˜ë¦¬?•˜?Š” ?•„?´?…œ ?Œ©?† ë¦? ?ƒ?„±
		
		// ?””?Š¤?¬ ê¸°ë°˜?˜ ?ŒŒ?¼?•„?´?…œ ì²˜ë¦¬ API - DiskFileItemFactory
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		// 3. ?—…ë¡œë“œ ?•„?´?…œ?´ ? ?‹¹?ˆ ?‘?œ¼ë©? ë©”ëª¨ë¦¬ì—?„œ ì²˜ë¦¬
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem); //ë©”ëª¨ë¦¬ì²˜ë¦¬ì‚¬?´ì¦? ?„¤? •
		
		System.out.println(getServletContext().getRealPath("tmp"));
		
		// 4. ? ?‹¹?ˆ ?° ?•„?´?…œ?´ë©? ?„?‹œ?ŒŒ?¼?„ ë§Œë“¤?–´?„œ ì²˜ë¦¬(?””?Š¤?¬)
		factory.setRepository(new File(getServletContext().getRealPath("tmp")));
		
		// 5. ?—…ë¡œë“œ ?—ˆ?š©ê¸°ì??— ë§ëŠ” ?š©?Ÿ‰?˜ ?ŒŒ?¼?´ë©? ?—…ë¡œë“œ ?ˆ˜?–‰
		long maxFile = 10 * 1024 * 1024 ; //10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //?—…ë¡œë“œ ?š©?Ÿ‰ ? œ?•œ ?„¤? •
		
		// 6. ?—…ë¡œë“œ ?°?´?„° ?ŒŒ?‹±(ì¶”ì¶œ) - ?„?‹œ?ŒŒ?¼ ?—…ë¡œë“œ
		List<FileItem> items = null;
		
		try {
			//?š”ì²?ê°ì²´ request?—?„œ ? „?‹¬ ?°?´?„° ì¶”ì¶œ?•˜ê¸?
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. ?¼?•„?“œ ì²˜ë¦¬
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			// ë¹ˆíŒŒ?¼(ë¹„ì •?ƒ?ŒŒ?¼)?´ ?—…ë¡œë“œ ?˜?—ˆ?„ ?•Œ ì²˜ë¦¬ ?•ˆ?•¨
			if(item.getSize() <= 0) continue;
			
			if(item.isFormField()) {
				// form-data ?¼ ê²½ìš°
				// ?‚¤=ê°? ?Œ?œ¼ë¡? ? „?‹¬?œ ?°?´?„°?¼ ê²½ìš°
				
				out.println("?¼ ?•„?“œ : "+item.getFieldName()
				+", ê°? : "+item.getString());
				
				if( item.getFieldName().equals("title")) {				
				}
				
			}else {
				
				// java.util.UUID
				UUID uid = UUID.randomUUID();
				System.out.println(uid);
				String u = uid.toString().split("-")[0];
				System.out.println(u);
				
				// ?•„?š”?•œ ì¶”ê? ì²˜ë¦¬
				// ?°?´?„°ë² ì´?Š¤?— ?—…ë¡œë“œ?•œ ?ŒŒ?¼?˜ ? •ë³´ë?? ê¸°ë¡?•´?‘”?‹¤
				//
				// ?—…ë¡œë“œ?ŒŒ?¼ PK
				// ?›ë³? ?ŒŒ?¼ëª?
				// ???¥ ?ŒŒ?—´ëª?(UUIDê°? ? ?š©?œ ?ŒŒ?¼ëª?)
				// ?—…ë¡œë“œ?•œ ?‚¬?Œ(userId)
				// ?—…ë¡œë“œ?•œ ?‹œê°?(?ƒ?µ ê°??Š¥)
				// ê²Œì‹œê¸? ë²ˆí˜¸(ì²¨ë??ŒŒ?¼?¼ ê²½ìš°)
				
				// ?ŒŒ?¼ ?°?´?„°?¼ ê²½ìš°
				File up = new File(
						getServletContext().getRealPath("upload"),item.getName()+"_"+u);
//				System.out.println(up);
//				System.out.println(up.exists());
				
				try {
					// realPath?— ì§?? •?•œ ?ŒŒ?¼ë¡? ê¸°ë¡?•˜ê¸?(?‹¤? œ ?—…ë¡œë“œ)
					item.write(up);
					item.delete(); //?„?‹œ?ŒŒ?¼ ?‚­? œ?•˜ê¸?
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
}
