package com.sh.controller.action.startup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;

public class StuBoardView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/startup/boardView.jsp";

		String bodNum = request.getParameter("bodNum");

		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		
		StuBoardVO bodList =  sDAO.selectOneBoardByBodNum(bodNum);
		request.setAttribute("bodNum", bodNum);
		System.out.println(bodList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
