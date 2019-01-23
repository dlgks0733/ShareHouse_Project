package com.sh.controller.action.epl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplIntroductionDAO;
import com.sh.vo.EplIntroductionVO;

public class EplIntroViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "epl/introductionForm.jsp";
		
		EplIntroductionDAO eplDao = EplIntroductionDAO.getInstance();
		ArrayList<EplIntroductionVO> list = eplDao.eplIntroList();
		
		request.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
		
}
