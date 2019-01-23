package com.sh.controller.action.epl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;

import com.sh.vo.EplBoardVO;


public class EplBoardListFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "epl/boardListForm.jsp";
		
		EplBoardDAO elbDao = EplBoardDAO.getInstnace();
		ArrayList<EplBoardVO> list = elbDao.eplBoardList();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
