package com.sh.controller.action.epl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;

import com.sh.vo.EplBoardVO;
import com.sh.vo.EplCommentVO;


public class EplBoardViewFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "epl/boardViewForm.jsp";
		
		String bodNum = request.getParameter("bodNum");
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		EplBoardDAO.getInstnace().updateHits(bodNum);

		//댓글 불러오는 기능
		ArrayList<EplCommentVO> list = eplDao.eplCommentList(bodNum);
		
		request.setAttribute("list", list);
		
		EplBoardVO eplVo = eplDao.eplBoardView(bodNum);
		request.setAttribute("eplVo", eplVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	
	}

}
