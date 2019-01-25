package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;

public class StuCommentUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commNum = request.getParameter("commNum");
		String commContents;
		
		StuBoardDAO stuDao = StuBoardDAO.getInstance();
		
		
		
	}

}
