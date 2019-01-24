package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplBoardDAO;
import com.sh.vo.EplCommentVO;

public class EplCommentInsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bodNum = request.getParameter("bodNum");
		String memberId = request.getParameter("memberId");
		String commContents = request.getParameter("commContents");
		String commDate = request.getParameter("commDate");
		
		EplCommentVO eplVo = new EplCommentVO();
		eplVo.setBodNum(bodNum);
		eplVo.setMemberId(memberId);
		eplVo.setCommContents(commContents);
		eplVo.setCommDate(commDate);
		
		System.out.println(memberId);
		
		EplBoardDAO eplDao = EplBoardDAO.getInstnace();
		eplDao.insertComment(eplVo);
		
		new EplBoardViewFormAction().execute(request, response);
		
	}

}
