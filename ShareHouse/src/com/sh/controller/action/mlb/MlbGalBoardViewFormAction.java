package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbGalBoardDAO;
import com.sh.vo.MlbGalBoardVO;

public class MlbGalBoardViewFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "mlb/galBoardViewForm.jsp";
		
		String galNum = request.getParameter("galNum");
		request.setAttribute("galNum", galNum);
		
		MlbGalBoardDAO mlbDao = MlbGalBoardDAO.getInstance();
		MlbGalBoardVO mlbVo = new MlbGalBoardVO();
		mlbVo = mlbDao.mlbGalBoardView(galNum);
		request.setAttribute("mlbVo", mlbVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
