package com.sh.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.controller.action.Action;
import com.sh.dao.MemberDAO;
import com.sh.vo.MemberVO;


public class LoginFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String url = "login.jsp";
		
		//아이디와 비밀번호 가져오기
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		System.out.println(userid + " : LoginFormAction.java에 저장된 아이디");
		
		//db에서 아이디,비번	확인하기 
		MemberDAO mDao=MemberDAO.getInstance();
		int result = mDao.userCheck(userid,  pwd); //1:로그인 성공, 0:비번불일치, -1:아이디 불일치
		System.out.println(result+" : userCheck()를 사용하여 아이디 확인하기"+"\n"+"1:로그인 성공, 0:비번불일치, -1:아이디 불일치");

		if(result ==1){
			MemberVO mVo=mDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",mVo); //로그인 성공시 세션에 로그인 정보 저장
			
			
			request.setAttribute("message", "로그인에 성공했습니다.");
			url="index.jsp";
			
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다");
			url = "login.jsp";
		}else if(result == -1){
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			mDao.getMember("memberID");
			url ="login.jsp";		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
		
		

