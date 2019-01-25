package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;

public class StuCommentDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commNum = request.getParameter("commNum");
		StuBoardDAO stuDao = StuBoardDAO.getInstance();
		stuDao.stuCommentDelete(commNum);
		
		new StuBoardView().execute(request, response);
		
		
	}

}
