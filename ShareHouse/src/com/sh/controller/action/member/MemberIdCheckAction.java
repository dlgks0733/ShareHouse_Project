package com.sh.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MemberDAO;

public class MemberIdCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "popup.jsp";
		
		String memId = request.getParameter("memId");
		request.setAttribute("memId", memId);
		
		MemberDAO memDao = MemberDAO.getInstance();
		int result = memDao.confirmID(memId);
		request.setAttribute("result", result);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
