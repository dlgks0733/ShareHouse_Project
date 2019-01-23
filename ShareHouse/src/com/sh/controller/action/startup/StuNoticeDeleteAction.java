package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuNoticeDAO;

public class StuNoticeDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nocNum = request.getParameter("nocNum");
		
		StuNoticeDAO sDAO = StuNoticeDAO.getInstance();
		sDAO.noticeDelete(nocNum);
		
		new StuNoticeListFormAction().execute(request, response);
		
	}

}
