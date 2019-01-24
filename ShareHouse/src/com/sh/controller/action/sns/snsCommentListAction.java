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
		
		String BODNUM = request.getParameter("BODNUM");
		
		
		snsCommentDAO commDao = snsCommentDAO.getInstance();
		ArrayList<snsCommentVO> commentList = commDao.getCommentList(BODNUM);
		if(commentList.size() > 0) request.setAttribute("commentList", commentList);
	}

}
