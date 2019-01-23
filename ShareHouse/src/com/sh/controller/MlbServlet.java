package com.sh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sh.controller.action.mlb.MlbGalBoardInsertAction;
import com.sh.vo.MlbGalBoardVO;
import com.sh.vo.MlbImageFileVO;

/**
 * Servlet implementation class MlbServlet
 */
@WebServlet("/mlb")
public class MlbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MlbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		System.out.println("MlbServlet에서 요청을 받음을 확인 : " + command);

		if (command == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("loginForm")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("fileInsert")) {
			
			ServletContext context = getServletContext();
			System.out.println("context: " + context.getContextPath());
			
			String path = context.getRealPath("mlbFile");
			
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
			String galTitle = multi.getParameter("galTitle");
			String fileName = multi.getFilesystemName("fileName");
			String galContents = multi.getParameter("galContents");
			
			
			MlbGalBoardVO mlbVo = new MlbGalBoardVO();
			mlbVo.setGalTitle(galTitle);
			mlbVo.setGalContents(galContents);
			
			MlbImageFileVO imgMlbVo = new MlbImageFileVO();
			imgMlbVo.setFileName(fileName);
			
			
			System.out.println("path: "+ path);
			System.out.println("fileName: "+ fileName);
			
			System.out.println("mlbVo: "  + mlbVo);
			System.out.println("imgMlbVo: "  + imgMlbVo);
			
			request.setAttribute("mlbVo", mlbVo);
			request.setAttribute("imgMlbVo", imgMlbVo);
			
			new MlbGalBoardInsertAction().execute(request, response);
			
			
//			int maxSize = 1024*1024*20;
//			String root = request.getSession().getServletContext().getRealPath("/");
//			String savePath = root + "mlbFile";
//			String fileName = "";
//			String newFileName = "";
//			
//			int read = 0;
//			byte[] buf = new byte[1024];
//			FileInputStream fin = null;
//			FileOutputStream fout = null;
//			long currentTime = System.currentTimeMillis();
//			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
//			
//			try {
//				MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
//				
//				//전송받은 parameter의 한글깨짐 방지
//				String galTitle = multi.getParameter("galTitle");
//				galTitle = new String(galTitle.getBytes("8859_1"), "UTF-8");
//				String galContents = multi.getParameter("galContents");
//				galContents = new String(galContents.getBytes("8859_1"), "UTF-8");
//				
//				//파일 업로드
//				fileName = multi.getFilesystemName("fileName");
//				
//				
//
//				//실제 저장할 파일명(ex: 20140819151221.zip)
//				newFileName = simDf.format(new Date(currentTime)) + "." + fileName.substring(fileName.lastIndexOf(".")+1);
//				
//				//업로드된 파일 객체 생성
//				File oldFile = new File(savePath + fileName);
//				
//				//실제 저장될 파일 객체 생성
//				File newFile = new File(savePath + newFileName);
//				
//				if(!oldFile.renameTo(newFile)) {
//					
//					buf = new byte[1024];
//					fin = new FileInputStream(oldFile);
//					fout = new FileOutputStream(newFile);
//					read = 0;
//					
//					while((read=fin.read(buf,0,buf.length)) != -1) {
//						fout.write(buf, 0, read);
//					}
//					
//					
//					
//					fin.close();
//					fout.close();
//					oldFile.delete();
//					
//				}
//			}	catch (Exception e) {
//					e.printStackTrace();
//			} finally {
//				new MlbGalBoardInsertAction().execute(request, response);
//			}
//			
				
			
			
			
		}
		else {
			MlbActionFactory af = MlbActionFactory.getInstance();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
