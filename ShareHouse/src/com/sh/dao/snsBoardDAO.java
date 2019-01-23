package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.sh.vo.sns.snsBoardVO;

import util.DBManager;

public class snsBoardDAO extends DBManager{
	
	private static snsBoardDAO instance;
	
	private snsBoardDAO() {
		
	}
	
	public static snsBoardDAO getInstance() {
		if(instance == null) {
			instance = new snsBoardDAO();
		}
		return instance;
	}
	
	// sns 게시물 등록
	public void insertsnsBoard(snsBoardVO snsVo) {
		String sql = "INSERT INTO TBL_SNS_BOARD("
				+ "	  BODNUM, BODTITLE, BODCONTENTS )"
				+ "	  VALUES(sns_bodnum_seq.nextval, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snsVo.getBodTitle());
			pstmt.setString(2, snsVo.getBodContents());
		//	pstmt.setInt(3, snsVo.getBodHits());
		//	pstmt.setString(4, snsVo.getMemberId());
		//	pstmt.setString(5, snsVo.getAdminId());
			
			pstmt.executeQuery();
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
		
	}
	
	// sns 게시판 리스트
	public ArrayList<snsBoardVO> snsBoardList() {
		
		ArrayList<snsBoardVO> list = new ArrayList<snsBoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_SNS_BOARD ORDER BY BODNUM DESC";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				snsBoardVO snsVo = new snsBoardVO();
				snsVo.setBodNum(rs.getString("BODNUM"));
				snsVo.setBodTitle(rs.getString("BODTITLE"));
				snsVo.setBodContents(rs.getString("BODCONTENTS"));
				snsVo.setBodDate(rs.getDate("BODDATE"));
				snsVo.setBodHits(rs.getInt("BODHITS"));
				
				
				list.add(snsVo);
				
			}
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
		
		return list;
	}
	
	//sns 게시판 상세보기
	public snsBoardVO snsBoardView(String bodNum) {
		String sql = "SELECT * FROM TBL_SNS_BOARD WHERE BODNUM = ?";
		
		snsBoardVO snsVo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bodNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				snsVo = new snsBoardVO();
				
				snsVo.setBodNum(rs.getString("BODNUM"));
				snsVo.setBodTitle(rs.getString("BODTITLE"));
				snsVo.setBodContents(rs.getString("BODCONTENTS"));
				snsVo.setBodDate(rs.getDate("BODDATE"));
				snsVo.setBodHits(rs.getInt("BODHITS"));
				snsVo.setMemberId(rs.getString("MEMBERID"));
				snsVo.setAdminId(rs.getString("ADMINID"));
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return snsVo;
	}
	
	//sns 게시물 수정
	public void updatesnsBoard(snsBoardVO snsVo) {
		String sql = "UPDATE TBL_SNS_BOARD SET BODTITLE = ?"
				+ "	 , BODCONTENTS = ?"
				+ "	  WHERE BODNUM = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, snsVo.getBodTitle());
			pstmt.setString(2, snsVo.getBodContents());
			pstmt.setString(3, snsVo.getBodNum());
			
			pstmt.executeUpdate();
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		
	}
	
	public void deletesnsBoard(String bodNum) {
		String sql = "DELETE FROM TBL_SNS_BOARD WHERE BODNUM = ?";
		
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
