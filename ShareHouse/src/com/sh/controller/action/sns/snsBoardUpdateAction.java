package com.sh.controller.action.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.controller.action.sns.snsBoardListFormAction;
import com.sh.dao.snsBoardDAO;
import com.sh.vo.sns.snsBoardVO;

public class snsBoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
		
		snsBoardVO snsVo = new snsBoardVO();
		
		snsVo.setBodNum(bodNum);
		snsVo.setBodTitle(bodTitle);
		snsVo.setBodContents(bodContents);
		
		snsBoardDAO snsDao = snsBoardDAO.getInstance();
		snsDao.updatesnsBoard(snsVo);
		
		new snsBoardListFormAction().execute(request, response);
		
		
		
		
	}

}
