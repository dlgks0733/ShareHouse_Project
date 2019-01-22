package com.sh.controller.action.mlb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbBoardDAO;
import com.sh.vo.MlbBoardVO;

public class MlbBoardInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
	  //String memId
	  //String adminId
		
		
		MlbBoardVO mlbVo = new MlbBoardVO();
		mlbVo.setBodTitle(title);
		mlbVo.setBodContents(contents);
		
		System.out.println("mlbVo : "+mlbVo);
		
		MlbBoardDAO mlbDao = MlbBoardDAO.getInstance();
		mlbDao.insertMlbBoard(mlbVo);
		
		//목록 화면으로 이동
		new MlbBoardListFormAction().execute(request, response);
		
		
	}

}
