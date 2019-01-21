package com.sh.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MemberDAO;
import com.sh.vo.MemberVO;

public class InsertMemberAction	implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "index.jsp";
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		
		MemberVO memVo = new MemberVO();
		memVo.setMemberId(memId);
		memVo.setMemberPwd(memPwd);
		memVo.setMemberName(memName);
		
		System.out.println(memVo);
		
		MemberDAO memDao = MemberDAO.getInstance();
		memDao.insertMember(memVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
