package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;

import com.sh.dao.EplBoardDAO;

import com.sh.vo.EplBoardVO;


public class EplBoardInsertAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
	  //String memId
	  //String adminId
		
		EplBoardVO eplVo = new EplBoardVO();
		eplVo.setBodTitle(bodTitle);
		eplVo.setBodContents(bodContents);
		
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		eplDao.insertEplBoard(eplVo);
		
		//목록 화면으로 이동
		new EplBoardListFormAction().execute(request, response);
		
		
	}

}
