package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sh.vo.EplBoardVO;

import util.DBManager;

public class EplBoardDAO extends DBManager {
	
	private static EplBoardDAO instance;
	
	private EplBoardDAO() {
		
	}
	
	public static EplBoardDAO getInstace() {
		if (instance == null) {
			instance = new EplBoardDAO();
		}
		return instance;
	}
	
	//epl 게시물 등록
	public void inserEplBoard(EplBoardVO eplVo) {
		String sql = "INSERT INTO TBL_EPL_BOARD("
				+ "	  BODNUM, BODTITLE, BODCONTENTS )"
				+ "	  VALUES(mlb_bodnum_seq.nextval, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eplVo.getBodTitle());
			pstmt.setString(2, eplVo.getBodContents());
			
			pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// epl 게시판 리스트
	public ArrayList<EplBoardVO> eplBoardList() {
		
		ArrayList<EplBoardVO> list = new ArrayList<EplBoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_EPL_BOARD ORDER BY BODNUM DESC";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				EplBoardVO eplVo = new EplBoardVO();
				eplVo.setBodNum(rs.getString("BODNUM"));
				eplVo.setBodTitle(rs.getString("BODTITLE"));
				eplVo.setBodContents(rs.getString("BODCONTENTS"));
				eplVo.setBodDate(rs.getDate("BODDATE"));
				eplVo.setBodHits(rs.getInt("BODHITS"));
				
				
				list.add(eplVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
	
	//epl 게시판 상세보기
	public EplBoardVO eplBoardView(String bodNum) {
		String sql = "SELECT * FROM TBL_EPL_BOARD WHERE BODNUM = ?";
		
		EplBoardVO eplVo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bodNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eplVo = new EplBoardVO();
				
				eplVo.setBodNum(rs.getString("BODNUM"));
				eplVo.setBodTitle(rs.getString("BODTITLE"));
				eplVo.setBodContents(rs.getString("BODCONTENTS"));
				eplVo.setBodDate(rs.getDate("BODDATE"));
				eplVo.setBodHits(rs.getInt("BODHITS"));
				eplVo.setMemberId(rs.getString("MEMBERID"));
				eplVo.setAdminId(rs.getString("ADMINID"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return eplVo;
	}
}












































