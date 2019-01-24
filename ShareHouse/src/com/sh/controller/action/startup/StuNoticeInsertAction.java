package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.StuNocFileDAO;
import com.sh.dao.StuNoticeDAO;
import com.sh.vo.StuNocFileVO;
import com.sh.vo.StuNoticeVO;

public class StuNoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StuNoticeDAO sDAO = StuNoticeDAO.getInstance();
		StuNocFileDAO stuDAO = StuNocFileDAO.getInstance();
		
		StuNoticeVO stuVO = (StuNoticeVO) request.getAttribute("stuVO");
		StuNocFileVO fileStuVO = (StuNocFileVO) request.getAttribute("fileStuVO");
			
		stuDAO.nocFileInsert(fileStuVO);
		sDAO.insertNotice(stuVO);
		
		new StuNoticeListFormAction().execute(request, response);
		
	}

}
