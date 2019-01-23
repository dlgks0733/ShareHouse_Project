package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuNoticeDAO;
import com.sh.vo.StuNoticeVO;

public class StuNoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nocTitle = request.getParameter("nocTitle");
		String nocContents = request.getParameter("nocContents");
		
		StuNoticeVO stuVO = new StuNoticeVO();
		
		stuVO.setNocTitle(nocTitle);
		stuVO.setNocContents(nocContents);
		
		System.out.println(stuVO);
		StuNoticeDAO sDAO = StuNoticeDAO.getInstance();
		
		sDAO.insertNotice(stuVO);
		
		new StuNoticeListFormAction().execute(request, response);
		
	}

}
