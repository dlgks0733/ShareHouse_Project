package com.sh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sh.controller.action.Action;
import com.sh.controller.action.startup.StuNoticeInsertAction;
import com.sh.vo.StuNocFileVO;
import com.sh.vo.StuNoticeVO;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/stu")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		System.out.println("StuServlet에서 요청을 받음을 확인 : " + command);

		if (command == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("loginForm")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("nocfileInsert")) {

			request.setCharacterEncoding("UTF-8");

/*			   // 10Mbyte 제한
			   int maxSize  = 1024*1024*20;      

			   // 웹서버 컨테이너 경로
			   String root = request.getSession().getServletContext().getRealPath("stuFile");

			   // 파일 저장 경로(ex : /home/tour/web/ROOT/upload)
			   String savePath = root + "upload";

			   // 업로드 파일명
			   String fileName = "";

			   // 실제 저장할 파일명
			   String newFileName = "";



			   int read = 0;
			   byte[] buf = new byte[1024];
			   FileInputStream fin = null;
			   FileOutputStream fout = null;
			   long currentTime = System.currentTimeMillis();  
			   SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");  

			   try{

			      MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			      
			      // 전송받은 parameter의 한글깨짐 방지
			      String title = multi.getParameter("title");
			      title = new String(title.getBytes("8859_1"), "UTF-8");

			      // 파일업로드
			      fileName = multi.getFilesystemName("uploadFile");

			      // 실제 저장할 파일명(ex : 20140819151221.zip)
			      newFileName = simDf.format(new Date(currentTime)) +"."+ fileName.substring(fileName.lastIndexOf(".")+1);

			      
			      // 업로드된 파일 객체 생성
			      File oldFile = new File(savePath + fileName);

			      
			      // 실제 저장될 파일 객체 생성
			      File newFile = new File(savePath + newFileName);
			      

			      // 파일명 rename
			      if(!oldFile.renameTo(newFile)){

			         // rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제

			         buf = new byte[1024];
			         fin = new FileInputStream(oldFile);
			         fout = new FileOutputStream(newFile);
			         read = 0;
			         while((read=fin.read(buf,0,buf.length))!=-1){
			            fout.write(buf, 0, read);
			         }
			         
			         fin.close();
			         fout.close();
			         oldFile.delete();
			      }   

			   }catch(Exception e){
			      e.printStackTrace();
			   } finally {
				   new StuNoticeInsertAction().execute(request, response);
			}*/
			ServletContext context = getServletContext();
			String path = context.getRealPath("stuFile");   
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
			String nocTitle = multi.getParameter("nocTitle");
			String fileName = multi.getFilesystemName("fileName");
			String nocContents = multi.getParameter("nocContents");
			
			//갤러리 정보를 저장후 돌려받기
			StuNoticeVO stuVO = new StuNoticeVO();
			stuVO.setNocTitle(nocTitle);
			stuVO.setNocContents(nocContents);
			
			StuNocFileVO fileStuVO = new StuNocFileVO();
			fileStuVO.setFileName(fileName);
			
			request.setAttribute("stuVO", stuVO);
			request.setAttribute("fileStuVO", fileStuVO);
			
			new StuNoticeInsertAction().execute(request, response);
		}
		else {
			StuActionFactory af = StuActionFactory.getInstance();
			Action action = af.getAction(command);

			if (action != null) {
				action.execute(request, response);
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
