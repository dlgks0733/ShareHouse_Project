package com.sh.controller.action.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsGalBoardDAO;
import com.sh.dao.snsImageFileDAO;

public class snsGalBoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String galNum = request.getParameter("galNum");
		
		snsImageFileDAO imgsnsDao = snsImageFileDAO.getInstance();
		imgsnsDao.deletesnsImage(galNum);
		snsGalBoardDAO snsDao = snsGalBoardDAO.getInstance();
		snsDao.deleteGalBoard(galNum);
		
		new snsGalBoardListFormAction().execute(request, response);
		
		
	}

}
