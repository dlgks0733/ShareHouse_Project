package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sh.vo.sns.snsCommentVO;

import util.DBManager;

public class snsCommentDAO extends DBManager{
	
	
	
	 	private Connection conn;
	    private PreparedStatement pstmt;
	    private ResultSet rs;
	    
	    private static snsCommentDAO instance;
	    
	    private snsCommentDAO(){}
	    public static snsCommentDAO getInstance(){
	        if(instance==null)
	            instance=new snsCommentDAO();
	        return instance;
	    }
	    
	    // 시퀀스를 가져온다.
	    public int getSeq() 
	    {
	        int result = 1;
	        try {
	            conn = getConnection();
	            
	            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
	            StringBuffer sql = new StringBuffer();
	            sql.append("SELECT SNS_COMMNUM_SEQ.NEXTVAL FROM DUAL");
	 
	            pstmt = conn.prepareStatement(sql.toString());
	            rs = pstmt.executeQuery(); // 쿼리 실행
	 
	            if (rs.next())    result = rs.getInt(1);
	 
	        } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	 
	        close();
	        return result;
	    } // end getSeq
	    
	    
	    // 댓글 등록
	    public boolean insertComment(snsCommentVO comment)
	    {
	        boolean result = false;
	        
	        try {
	            conn = getConnection();
	 
	            // 자동 커밋을 false로 한다.
	            conn.setAutoCommit(false);
	            
	            StringBuffer sql = new StringBuffer();
	            sql.append("INSERT INTO BOARD_COMMENT");
	            sql.append(" (COMMNUM, COMMCONTENTS, COMMDATE, BODNUM, MEMBERID)");
	            sql.append(" VALUES(?,?,sysdate,?,?)");
	    
	            pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setString(1, comment.getCOMMNUM());
	            pstmt.setString(2, comment.getCOMMCONTENTS());
	            pstmt.setString(3, comment.getCOMMDATE());
	            pstmt.setString(4, comment.getBODNUM());
	            pstmt.setString(5, comment.getMEMBERID());

	            int flag = pstmt.executeUpdate();
	            if(flag > 0){
	                result = true;
	                conn.commit(); // 완료시 커밋
	            }
	            
	        } catch (Exception e) {
	            try {
	                conn.rollback(); // 오류시 롤백
	            } catch (SQLException sqle) {
	                sqle.printStackTrace();
	            } 
	            e.printStackTrace();
	            throw new RuntimeException(e.getMessage());
	        }
	        
	        close();
	        return result;    
	    } // end boardInsert();    
	    
	    // 댓글 목록 가져오기
	    public ArrayList<snsCommentVO> getCommentList(String bODNUM)
	    {
	        ArrayList<snsCommentVO> list = new ArrayList<snsCommentVO>();
	        
	        try {
	            conn = getConnection();
	            
	            /* 댓글의 페이지 처리를 하고싶다면 이 쿼리를 사용하면 된다.
	             * SELECT * FROM
	             *            (SELECT  ROWNUM AS rnum,
	             *                   data.*
	             *             FROM
	             *                   (SELECT LEVEL,
	             *                           COMMENT_NUM,
	             *                             COMMENT_BOARD,
	             *                           COMMENT_ID,
	             *                           COMMENT_DATE,
	             *                           COMMENT_PARENT,
	             *                           COMMENT_CONTENT
	             *                    FROM BOARD_COMMENT
	             *                    WHERE COMMENT_BOARD = ?
	             *                   START WITH COMMENT_PARENT = 0
	             *                   CONNECT BY PRIOR COMMENT_NUM = COMMENT_PARENT) 
	             *              data)
	             *    WHERE rnum>=? and rnum<=? ;
	             */
	            
	            StringBuffer sql = new StringBuffer();
	            sql.append("    SELECT COMMNUM, COMMCONTENTS, COMMDATE,");
	            sql.append("            BODNUM, MEMBERID, COMMENT_PARENT");
	            sql.append("    FROM TBL_SNS_COMMENT");
	            sql.append("    WHERE BODNUM = ?");      
	            
	            pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setString(1, bODNUM);
	            
	            rs = pstmt.executeQuery();
	            while(rs.next())
	            {
	            	snsCommentVO comment = new snsCommentVO();
	                comment.setCOMMNUM(rs.getString("COMMNUM"));
	                comment.setCOMMCONTENTS(rs.getString("COMMCONTENTS"));
	                comment.setCOMMDATE(rs.getString("COMMDATE"));
	                comment.setBODNUM(rs.getString("BODNUM"));
	                comment.setMEMBERID(rs.getString("MEMBERID"));
	                list.add(comment);
	            }
	                
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e.getMessage());
	        }
	        
	        close();
	        return list;
	    } // end getCommentList
	    
	    
	    //댓글 개수구하기
	    public int getCount(String COMMNUM) throws SQLException {
	    	String sql="select count(*) form TBL_SNS_COMMENT where MEMBERID = ?";
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setString(1,  COMMNUM);
	    	rs = pstmt.executeQuery();
	    	int cnt = 0;
	    	if(rs.next()) {
	    		cnt = rs.getInt(1);
	    	}
	    	pstmt.close();
	    	return cnt;
	    }
	    
	    // DB 자원해제
	    private void close()
	    {
	        try {
	            if ( pstmt != null ){ pstmt.close(); pstmt=null; }
	            if ( conn != null ){ conn.close(); conn=null;    }
	        } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	    } // end close() 


}
