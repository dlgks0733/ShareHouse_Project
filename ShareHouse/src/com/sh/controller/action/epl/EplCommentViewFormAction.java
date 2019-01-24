package com.sh.controller.action.epl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;
import com.sh.vo.EplCommentVO;

public class EplCommentViewFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//지워도됨
//		String url = "epl/boardViewForm.jsp";
//		
//		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
////		ArrayList<EplCommentVO> list = eplDao.eplCommentList();
//		
//		request.setAttribute("list", list);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
		
		
		
	}

}
