package com.sh.controller.action.epl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.EplIntroductionDAO;
import com.sh.vo.EplIntroductionVO;

public class EplIntroUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String intClubname = request.getParameter("intClubname");
		String intContents = request.getParameter("intContents");
		String intHistory = request.getParameter("intHistory");
		String intName = request.getParameter("intName");
		String intId = request.getParameter("intId");
		
		EplIntroductionVO eplVo = new EplIntroductionVO();
		
		eplVo.setIntClubname(intClubname);
		eplVo.setIntContents(intContents);
		eplVo.setIntHistory(intHistory);
		eplVo.setIntName(intName);
		eplVo.setIntId(intId);
		
		EplIntroductionDAO eplDao = EplIntroductionDAO.getInstance();
		eplDao.updateEplIntro(eplVo);
		
		new EplIntroViewFormAction().execute(request, response);
		
		
		
	}

}
