package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;


import com.sh.vo.StuBoardVO;

import util.DBManager;

public class StuBoardDAO extends DBManager{
	private StuBoardDAO() {
	}
	
	private static StuBoardDAO instance = new StuBoardDAO();
	
	public static StuBoardDAO getInstance() {
		return instance;
	}
		// 게시판 목록
	public ArrayList<StuBoardVO> selectAllStuBoard(){
		
		String sql = "SELECT * FROM TBL_STU_BOARD";
		
		ArrayList<StuBoardVO> list = new ArrayList<StuBoardVO>();
		
	    Connection conn = getConnection();
	    PreparedStatement psmt;
	    ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				StuBoardVO stuVO = new StuBoardVO();
				
				stuVO.setBodNum(rs.getString("bodNum"));
				stuVO.setBodTitle(rs.getString("bodTitle"));
				stuVO.setBodHits(rs.getInt("bodHits"));
				stuVO.setBodDate(rs.getDate("bodDate"));

				
				
				list.add(stuVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
		// 게시판 글 등록
	   public void insertStuBoard(StuBoardVO stuVO) {
		     
		      String sql = "INSERT INTO TBL_STU_BOARD(BODNUM, BODTITLE, BODCONTENTS)"
		      		+ "VALUES(STU_BODNUM_SEQ.nextval, ? , ?)";
		 

		      Connection conn = getConnection();
		      PreparedStatement psmt;
		      

		      try {

		    	 psmt = conn.prepareStatement(sql);
		    	 
		    	 
		    	 psmt.setString(1, stuVO.getBodTitle());
		    	 psmt.setString(2, stuVO.getBodContents());
/*		    	 psmt.setString(3, stuVO.getMemberId());
		    	 psmt.setString(4, stuVO.getAdminId());*/
		    	 psmt.executeUpdate(); 
		    	 
		   }catch (SQLException e){
			   e.printStackTrace();
		   }finally {
			   dbClose();
		   }
		}
	   //조회수 늘어나는거
	   public void updateHits(String BodNum) {
		   
		   String sql = "UPDATE TBL_STU_BOARD SET BODHITS = BODHITS +1 WHERE BODNUM = ?";
		   
		   Connection conn = getConnection();
		   PreparedStatement psmt;
		   
		   try {
			   
			   
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BodNum);
			
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		   
	   }
	   // 게시판 글 상세 내용 보기 글번호로 찾아온다.
	  public StuBoardVO selectOneBoardByBodNum(String BodNum) {
		  String sql = "SELECT * FROM TBL_STU_BOARD WHERE BODNUM = ?";
		  
		  StuBoardVO stuVO  = null;
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  ResultSet rs = null;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BodNum);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				stuVO = new StuBoardVO();
				
				stuVO.setBodNum(rs.getString("bodNum"));
				stuVO.setBodTitle(rs.getString("bodTitle"));
				stuVO.setBodContents(rs.getString("bodContents"));
				stuVO.setBodHits(rs.getInt("bodHits"));
				stuVO.setBodDate(rs.getDate("bodDate"));
				stuVO.setMemberId(rs.getString("memberId"));
				stuVO.setAdminId(rs.getString("adminId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		  return stuVO;  
	  }
	  
	  public void updateStuBoard(StuBoardVO stuVO) {
		  String sql = "UPDATE TBL_STU_BOARD SET BODTITLE = ?"
		  									  + "BODCONTENTS = ?"
		  									  + "WHERE BODNUM = ?";
		  
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stuVO.getBodTitle());
			psmt.setString(2, stuVO.getBodContents());
			psmt.setString(3, stuVO.getBodNum());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
				  
	  }
	  
	  public void deleteStuBoard(String BodNum) {
		  String sql = "DELETE TBL_STU_BOARD WHERE BODNUM = ?";
		  
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BodNum);
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
}
