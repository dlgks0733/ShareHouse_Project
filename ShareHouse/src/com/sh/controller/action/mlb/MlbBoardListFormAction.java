package com.sh.controller.action.mlb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbBoardDAO;
import com.sh.vo.MlbBoardVO;

public class MlbBoardListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "mlb/boardListForm.jsp";
		
		MlbBoardDAO mlbDao = MlbBoardDAO.getInstance();
		ArrayList<MlbBoardVO> list = mlbDao.mlbBoardList();
		
		request.setAttribute("list", list);
		System.out.println(list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
