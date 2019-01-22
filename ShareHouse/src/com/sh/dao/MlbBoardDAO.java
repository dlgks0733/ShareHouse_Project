package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.sh.vo.MlbBoardVO;

import util.DBManager;

public class MlbBoardDAO extends DBManager{
	
	private static MlbBoardDAO instance;
	
	private MlbBoardDAO() {
		
	}
	
	public static MlbBoardDAO getInstance() {
		if(instance == null) {
			instance = new MlbBoardDAO();
		}
		return instance;
	}
	
	// mlb 게시물 등록
	public void insertMlbBoard(MlbBoardVO mlbVo) {
		String sql = "INSERT INTO TBL_MLB_BOARD("
				+ "	  BODNUM, BODTITLE, BODCONTENTS )"
				+ "	  VALUES(mlb_bodnum_seq.nextval, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mlbVo.getBodTitle());
			pstmt.setString(2, mlbVo.getBodContents());
		//	pstmt.setInt(3, mlbVo.getBodHits());
		//	pstmt.setString(4, mlbVo.getMemberId());
		//	pstmt.setString(5, mlbVo.getAdminId());
			
			pstmt.executeQuery();
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
		
	}
	
	// mlb 게시판 리스트
	public ArrayList<MlbBoardVO> mlbBoardList() {
		
		ArrayList<MlbBoardVO> list = new ArrayList<MlbBoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_MLB_BOARD";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MlbBoardVO mlbVo = new MlbBoardVO();
				mlbVo.setBodNum(rs.getString("BODNUM"));
				mlbVo.setBodTitle(rs.getString("BODTITLE"));
				mlbVo.setBodContents(rs.getString("BODCONTENTS"));
				mlbVo.setBodDate(rs.getDate("BODDATE"));
				mlbVo.setBodHits(rs.getInt("BODHITS"));
				
				
				list.add(mlbVo);
				
			}
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
		
		return list;
	}
	
	//mlb 게시판 상세보기
	public MlbBoardVO mlbBoardView(String bodNum) {
		String sql = "SELECT * FROM TBL_MLB_BOARD WHERE BODNUM = ?";
		
		MlbBoardVO mlbVo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bodNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mlbVo = new MlbBoardVO();
				
				mlbVo.setBodNum(rs.getString("BODNUM"));
				mlbVo.setBodTitle(rs.getString("BODTITLE"));
				mlbVo.setBodContents(rs.getString("BODCONTENTS"));
				mlbVo.setBodDate(rs.getDate("BODDATE"));
				mlbVo.setBodHits(rs.getInt("BODHITS"));
				mlbVo.setMemberId(rs.getString("MEMBERID"));
				mlbVo.setAdminId(rs.getString("ADMINID"));
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return mlbVo;
	}
	
	//mlb 게시물 수정
	public void updateMlbBoard(MlbBoardVO mlbVo) {
		String sql = "UPDATE TBL_MLB_BOARD SET BODTITLE = ?"
				+ "	 , BODCONTENTS = ?"
				+ "	  WHERE BODNUM = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mlbVo.getBodTitle());
			pstmt.setString(2, mlbVo.getBodContents());
			pstmt.setString(3, mlbVo.getBodNum());
			
			pstmt.executeUpdate();
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		
	}
	
	public void deleteMlbBoard(String bodNum) {
		String sql = "DELETE FROM TBL_MLB_BOARD WHERE BODNUM = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bodNum);
			
			pstmt.executeUpdate();
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
	}
	
}
