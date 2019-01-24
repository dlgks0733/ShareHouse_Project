package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;

import com.sh.vo.EplBoardVO;


public class EplBoardUpdateFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "epl/boardUpdateForm.jsp";
		
		String bodNum = request.getParameter("bodNum");
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		EplBoardVO eplVo = eplDao.eplBoardView(bodNum);
		request.setAttribute("eplVo", eplVo);		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
