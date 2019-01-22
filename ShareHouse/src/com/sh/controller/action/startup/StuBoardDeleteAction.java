package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;

public class StuBoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bodNum = request.getParameter("bodNum");
		
		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		sDAO.deleteStuBoard(bodNum);
		
		new StuBoardListFormAction().execute(request, response);
		
	}

}
