package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbBoardDAO;
import com.sh.vo.MlbBoardVO;

public class MlbBoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		String bodTitle = request.getParameter("bodTitle");
		String bodContents = request.getParameter("bodContents");
		
		MlbBoardVO mlbVo = new MlbBoardVO();
		
		mlbVo.setBodNum(bodNum);
		mlbVo.setBodTitle(bodTitle);
		mlbVo.setBodContents(bodContents);
		
		MlbBoardDAO mlbDao = MlbBoardDAO.getInstance();
		mlbDao.updateMlbBoard(mlbVo);
		
		new MlbBoardListFormAction().execute(request, response);
		
		
		
		
	}

}
