package com.sh.controller.action.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.EplCommentVO;
import com.sh.vo.StuBoardVO;
import com.sh.vo.StuCommentVO;

public class stuCommentInsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		System.out.println("bodNum : "+ bodNum);
		String memId = request.getParameter("memId");
		String commContents = request.getParameter("commContents");
		
		StuCommentVO stuVO = new StuCommentVO();
		stuVO.setBodNum(bodNum);
		stuVO.setMemberId(memId);
		stuVO.setCommContents(commContents);
		
		StuBoardDAO stuDao = StuBoardDAO.getInstance();
		stuDao.insertComment(stuVO);
		
		
		new StuBoardView().execute(request, response);
		
	}

}
