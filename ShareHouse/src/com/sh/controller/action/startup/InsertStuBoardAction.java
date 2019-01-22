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


		
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
/*		String MemberId = request.getParameter("MemberId");
		String AdminId = request.getParameter("AdminId");*/
		
		
		System.out.println("bodTitle :" + bodTitle );
		System.out.println("bodContents :" + bodContents );
/*		System.out.println("MemberId :" + MemberId );
		System.out.println("AdminId :" + AdminId );*/
		
		StuBoardVO stuVO = new StuBoardVO();
		
		stuVO.setBodTitle(bodTitle);
		stuVO.setBodContents(bodContents);
/*		stuVO.setMemberId(MemberId);
		stuVO.setAdminId(AdminId);*/
		
		StuBoardDAO stuDAO = StuBoardDAO.getInstance();
		stuDAO.insertStuBoard(stuVO);
		
		new StuBoardListFormAction().execute(request, response);
		
	}
}
