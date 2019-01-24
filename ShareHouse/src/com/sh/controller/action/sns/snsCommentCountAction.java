package com.sh.controller.action.sns;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsCommentDAO;

public class snsCommentCountAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String COMMNUM = request.getParameter("COMMNUM");
		
		
		snsCommentDAO commDao = snsCommentDAO.getInstance();
		try {
			commDao.getCount(COMMNUM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
