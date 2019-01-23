package com.sh.controller.action.startup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuBoardDAO;
import com.sh.dao.StuNoticeDAO;
import com.sh.vo.StuNoticeVO;

public class StuNoticeViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/startup/noticeView.jsp";
		
		String nocNum = request.getParameter("nocNum");
		
		StuNoticeDAO sDAO = StuNoticeDAO.getInstance();
		
		StuNoticeVO noclist = sDAO.nocNumlist(nocNum);
		request.setAttribute("nocNum", nocNum);
		request.setAttribute("noclist", noclist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
