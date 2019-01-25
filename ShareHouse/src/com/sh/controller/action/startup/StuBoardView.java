package com.sh.controller.action.startup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;
import com.sh.dao.StuBoardDAO;
import com.sh.vo.StuBoardVO;
import com.sh.vo.StuCommentVO;

public class StuBoardView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "startup/boardView.jsp";
		
		int commentChk = 0;
		
		String bodNum = request.getParameter("bodNum");
		request.setAttribute("bodNum", bodNum);
		
		StuBoardDAO sDAO = StuBoardDAO.getInstance();
		StuBoardDAO.getInstance().updateHits(bodNum);
		
		ArrayList<StuCommentVO> commList = sDAO.stuCommentList(bodNum);
		request.setAttribute("commList", commList);
		
		if(commList.size() != 0) {
			commentChk = 1;
			request.setAttribute("commentChk", commentChk);
		} else {
			commentChk = -1;
			request.setAttribute("commentChk", commentChk);
		}
		
		StuBoardVO bodList =  sDAO.selectOneBoardByBodNum(bodNum);
		request.setAttribute("bodList", bodList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
