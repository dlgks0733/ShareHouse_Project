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

public class StuBoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/startup/boardUpdate.jsp";
		
		String bodNum = request.getParameter("bodNum");
		
		request.setAttribute("bodNum", bodNum);
		System.out.println("bodNum : " + bodNum);
		
		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		
		StuBoardVO bodList =  sDAO.selectOneBoardByBodNum(bodNum);
		
		request.setAttribute("bodList", bodList);
		System.out.println(bodList);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
