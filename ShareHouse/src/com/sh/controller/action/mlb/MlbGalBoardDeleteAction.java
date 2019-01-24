package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbGalBoardDAO;
import com.sh.dao.MlbImageFileDAO;

public class MlbGalBoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String galNum = request.getParameter("galNum");
		
		MlbImageFileDAO imgMlbDao = MlbImageFileDAO.getInstance();
		imgMlbDao.deleteMlbImage(galNum);
		MlbGalBoardDAO mlbDao = MlbGalBoardDAO.getInstance();
		mlbDao.deleteGalBoard(galNum);
		
		new MlbGalBoardListFormAction().execute(request, response);
		
		
	}

}
