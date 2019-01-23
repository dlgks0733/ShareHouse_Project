package com.sh.controller.action.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.controller.action.sns.snsBoardListFormAction;
import com.sh.dao.snsBoardDAO;
import com.sh.vo.sns.snsBoardVO;

public class snsBoardInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
	  //String memId
	  //String adminId
		
		snsBoardVO snsVo = new snsBoardVO();
		snsVo.setBodTitle(bodTitle);
		snsVo.setBodContents(bodContents);
		
		
		snsBoardDAO snsDao = snsBoardDAO.getInstance();
		snsDao.insertsnsBoard(snsVo);
		
		//목록 화면으로 이동
		new snsBoardListFormAction().execute(request, response);
		
		
	}}
