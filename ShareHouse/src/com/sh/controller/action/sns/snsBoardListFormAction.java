package com.sh.controller.action.sns;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsBoardDAO;
import com.sh.vo.sns.snsBoardVO;

public class snsBoardListFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "sns/boardListForm.jsp";
		
		snsBoardDAO snsDao = snsBoardDAO.getInstance();
		ArrayList<snsBoardVO> list = snsDao.snsBoardList();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}