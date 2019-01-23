package com.sh.controller.action.sns;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.CommentDAO;
import com.sh.vo.sns.snsCommentVO;

public class snsCommentWriteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		CommentDAO dao = CommentDAO.getInstance();
		snsCommentVO comment = new snsCommentVO();
        
        // 파리미터 값을 가져온다.
        String COMMCONTENTS = request.getParameter("COMMCONTENTS");
        
        comment.setCOMMCONTENTS(COMMCONTENTS);
        
        boolean result = dao.insertComment(comment);
 
        if(result){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("1");
            out.close();
        }
            
        return;

	}
}
