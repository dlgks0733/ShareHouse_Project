package com.sh.controller.action.sns;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsBoardDAO;
import com.sh.vo.sns.snsBoardVO;

public class snsBoardViewFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "sns/boardViewForm.jsp";
		
		String bodNum = request.getParameter("bodNum");
		
		snsBoardDAO snsDao = snsBoardDAO.getInstance();
		snsBoardVO snsVo = snsDao.snsBoardView(bodNum);
		request.setAttribute("snsVo", snsVo);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		



		
	
	}
	
	
	
}