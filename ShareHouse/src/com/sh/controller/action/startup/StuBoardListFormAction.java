package com.sh.controller.action.startup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;
import com.sh.vo.StuNoticeVO;

import util.Paging;

public class StuBoardListFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/startup/stuBoardList.jsp";
		
		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		
		//펭징
		  Paging paging = new Paging(10, 1);
	      int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));

	      System.out.println("pageNum : " + pageNum);
	      
	      paging.setPageNum(pageNum); //현재 보고 있는 페이지
	      
	      sDAO.selectNoticeRowCount(paging); //전체 게시글 수 (전체 게시글 / 10(보여즐 글의 수) => paging
	      
	      List<StuBoardVO> noticeList = sDAO.selectAllNoticesPerPage(paging);
	      
	      System.out.println("noticeList.size() " +noticeList.size());

	      //List<NoticeVO> noticeList = nDao.selectAllNotices();
	      
	      request.setAttribute("noticeList", noticeList);
	      request.setAttribute("paging", paging);
	      
	      System.out.println(noticeList);
		//페이징
	      
	/*	ArrayList<StuBoardVO> StuBoardList = sDAO.selectAllStuBoard();
		request.setAttribute("StuBoardList", StuBoardList);
		*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
