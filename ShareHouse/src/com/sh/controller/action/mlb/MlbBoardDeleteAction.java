package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbBoardDAO;

public class MlbBoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		
		MlbBoardDAO mlbDao = MlbBoardDAO.getInstance();
		mlbDao.deleteMlbBoard(bodNum);
		
		new MlbBoardListFormAction().execute(request, response);
		
		
		
	}

}
