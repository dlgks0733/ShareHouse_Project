package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbBoardDAO;
import com.sh.vo.MlbBoardVO;

public class MlbBoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mlb/boardUpdateForm.jsp";
		
		String bodNum = request.getParameter("bodNum");
		
		MlbBoardDAO mlbDao = MlbBoardDAO.getInstance();
		MlbBoardVO mlbVo = mlbDao.mlbBoardView(bodNum);
		request.setAttribute("mlbVo", mlbVo);		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
