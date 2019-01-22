package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;

public class StuBoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
/*		String MemberId = request.getParameter("MemberId");
		request.setAttribute(MemberId, "MemberId");
		String AdminId = request.getParameter("AdminId");
		request.setAttribute(AdminId, "AdminId");*/
/*		System.out.println("MemberId :" + MemberId );
		System.out.println("AdminId :" + AdminId );*/
		
		StuBoardVO stuVO = new StuBoardVO();
		StuBoardDAO stuDAO = StuBoardDAO.getInstance();
		
		stuVO.setBodNum(bodNum);
		stuVO.setBodTitle(bodTitle);
		stuVO.setBodContents(bodContents);
		System.out.println(stuVO);
/*		stuVO.setMemberId(MemberId);
		stuVO.setAdminId(AdminId);*/
		
		stuDAO.updateStuBoard(stuVO);
		
		new StuBoardListFormAction().execute(request, response);
		
		
	}

}
