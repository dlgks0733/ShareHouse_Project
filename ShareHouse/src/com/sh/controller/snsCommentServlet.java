package com.sh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/comment.do")
public class snsCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public snsCommentServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 입력 문자 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//사용자 응답 웹페이지 문자 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		
		
	}

}
