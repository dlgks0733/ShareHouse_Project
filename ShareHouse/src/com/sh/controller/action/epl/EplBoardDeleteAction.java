package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;

import com.sh.dao.EplBoardDAO;


public class EplBoardDeleteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		eplDao.deleteEplBoard(bodNum);
		
		new EplBoardListFormAction().execute(request, response);
		
		
		
	}


}
