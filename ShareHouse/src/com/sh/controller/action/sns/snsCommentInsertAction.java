package com.sh.controller.action.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.snsCommentDAO;
import com.sh.vo.sns.snsCommentVO;


public class snsCommentInsertAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String COMMNUM = request.getParameter("COMMNUM");
		String COMMCONTENTS = request.getParameter("COMMCONTENTS");
		String COMMDATE = request.getParameter("COMMDATE");
		String BODNUM = request.getParameter("BODNUM");
		String MEMBERID = request.getParameter("MEMBERID");

		snsCommentVO commVo = new snsCommentVO();
		commVo.setCOMMNUM(COMMNUM);
		commVo.setCOMMCONTENTS(COMMCONTENTS);
		commVo.setCOMMDATE(COMMDATE);
		commVo.setBODNUM(BODNUM);
		commVo.setMEMBERID(MEMBERID);
		
		snsCommentDAO commDao = snsCommentDAO.getInstance();
		commDao.insertComment(commVo);
		
		
	}
}
