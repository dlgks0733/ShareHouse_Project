package com.sh.controller.action.startup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;

public class StuBoardListFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/startup/stuBoardList.jsp";
		
		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		
		ArrayList<StuBoardVO> StuBoardList = sDAO.selectAllStuBoard();
		request.setAttribute("StuBoardList", StuBoardList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
