package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;

public class InsertStuBoardAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/StuServlet?command=stuBoardList";

		String BodNum = request.getParameter("BodNum");
		String BodTitle = request.getParameter("BodTitle");
		String BodContents = request.getParameter("BodContents");
/*		String MemberId = request.getParameter("MemberId");
		String AdminId = request.getParameter("AdminId");*/
		
		System.out.println("BodNum :" + BodNum );
		System.out.println("BodTitle :" + BodTitle );
		System.out.println("BodContents :" + BodContents );
/*		System.out.println("MemberId :" + MemberId );
		System.out.println("AdminId :" + AdminId );*/
		
		StuBoardVO stuVO = new StuBoardVO();
		stuVO.setBodNum(BodNum);
		stuVO.setBodTitle(BodTitle);
		stuVO.setBodContents(BodContents);
/*		stuVO.setMemberId(MemberId);
		stuVO.setAdminId(AdminId);*/
		
		StuBoardDAO stuDAO = StuBoardDAO.getInstance();
		stuDAO.insertStuBoard(stuVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
