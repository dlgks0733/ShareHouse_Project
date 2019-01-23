package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuNoticeDAO;
import com.sh.vo.StuNoticeVO;

public class StuNoticeUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nocNum = request.getParameter("nocNum");
		String nocTitle = request.getParameter("nocTitle");
		String nocContents = request.getParameter("nocContents");
		
		StuNoticeVO stuVO = new StuNoticeVO();
		StuNoticeDAO sDAO = StuNoticeDAO.getInstance();
		
		stuVO.setNocNum(nocNum);
		stuVO.setNocTitle(nocTitle);
		stuVO.setNocContents(nocContents);
		
		sDAO.noticeUpdate(stuVO);
		
		new StuNoticeListFormAction().execute(request, response);
		
		
	}

}
