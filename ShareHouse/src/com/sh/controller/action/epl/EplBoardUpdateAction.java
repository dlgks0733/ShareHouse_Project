package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;

import com.sh.dao.EplBoardDAO;

import com.sh.vo.EplBoardVO;


public class EplBoardUpdateAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
		
		EplBoardVO eplVo = new EplBoardVO();
		
		eplVo.setBodNum(bodNum);
		eplVo.setBodTitle(bodTitle);
		eplVo.setBodContents(bodContents);
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		eplDao.updateEplBoard(eplVo);
		
		new EplBoardListFormAction().execute(request, response);
		
		
		
		
	}

}
