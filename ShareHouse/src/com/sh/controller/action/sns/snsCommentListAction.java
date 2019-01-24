package com.sh.controller.action.sns;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsCommentDAO;
import com.sh.vo.sns.snsCommentVO;

public class snsCommentListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("BODNUM");
		
		
		snsCommentDAO snsCommDao = snsCommentDAO.getInstance();
		ArrayList<snsCommentVO> snsCommList = snsCommDao.getCommentList(bodNum);
		if(snsCommList.size() > 0) request.setAttribute("commentList", snsCommList);
	}

}
