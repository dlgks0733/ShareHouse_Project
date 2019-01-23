package com.sh.controller.action.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsBoardDAO;

public class snsBoardDeleteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		
		snsBoardDAO snsDao = snsBoardDAO.getInstance();
		snsDao.deletesnsBoard(bodNum);
		
		new snsBoardListFormAction().execute(request, response);
		
		
		
	}
}
