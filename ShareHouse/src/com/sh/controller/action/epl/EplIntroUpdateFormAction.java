package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplIntroductionDAO;
import com.sh.vo.EplIntroductionVO;

public class EplIntroUpdateFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "epl/introUpdateForm.jsp";
		
		String adminId = request.getParameter("adminId");
		System.out.println(adminId);
		
		EplIntroductionDAO eplDao = EplIntroductionDAO.getInstance();
		EplIntroductionVO eplVo = eplDao.eplIntroView(adminId);
		request.setAttribute("eplVo", eplVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
