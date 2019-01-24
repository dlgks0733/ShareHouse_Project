package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sh.vo.EplIntroductionVO;

import util.DBManager;

public class EplIntroductionDAO extends DBManager {

	private static EplIntroductionDAO instance;
	
	private EplIntroductionDAO() {
		
	}

	public static EplIntroductionDAO getInstance() {
		if(instance == null) {
			instance = new EplIntroductionDAO();
		}
		return instance;
	}
	
	//epl 소개글 등록
	public void inserEplIntroduction(EplIntroductionVO eplVo) {
		String sql = "INSERT INTO TBL_EPL_INTRODUCTION("
				+ "INTCLUBNAME, INTCONTENTS, INTHISTORY, INTNAME, INTID) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eplVo.getIntClubname());
			pstmt.setString(2, eplVo.getIntContents());
			pstmt.setString(3, eplVo.getIntHistory());
			pstmt.setString(4, eplVo.getIntName());
			pstmt.setString(5, eplVo.getIntId());
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	//epl 소개 리스트
	public ArrayList<EplIntroductionVO> eplIntroList() {
		
		ArrayList<EplIntroductionVO> list = new ArrayList<EplIntroductionVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_EPL_INTRODUCTION";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				EplIntroductionVO eplVo = new EplIntroductionVO();
				eplVo.setAdminId(rs.getString("ADMINID"));
				eplVo.setIntClubname(rs.getString("INTCLUBNAME"));
				eplVo.setIntContents(rs.getString("INTCONTENTS"));
				eplVo.setIntHistory(rs.getString("INTHISTORY"));
				eplVo.setIntName(rs.getString("INTNAME"));
				eplVo.setIntId(rs.getString("INTID"));
				
				list.add(eplVo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
		
	}
	
	// 소개글 업데이트
	public void updateEplIntro(EplIntroductionVO eplVo) {
		String sql = "UPDATE TBL_EPL_INTRODUCTION SET INTCLUBNAME = ?"
				+ ", INTCONTENTS = ? , INTHISTORY = ? , INTNAME = ?"
				+ ", INTID = ? WHERE ADMINID = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eplVo.getIntClubname());
			pstmt.setString(2, eplVo.getIntContents());
			pstmt.setString(3, eplVo.getIntHistory());
			pstmt.setString(4, eplVo.getIntName());
			pstmt.setString(5, eplVo.getIntId());
			pstmt.setString(6, eplVo.getAdminId());
			
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
		//소개글 불러오기
		public EplIntroductionVO eplIntroView(String adminId) {
			String sql = "SELECT * FROM TBL_EPL_INTRODUCTION WHERE ADMINID = ?";
			
			EplIntroductionVO eplVo = null;
			Connection conn = getConnection();
			PreparedStatement pstmt;
			ResultSet rs = null;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, adminId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					eplVo = new EplIntroductionVO();
					
					eplVo.setAdminId(rs.getString("ADMINID"));
					eplVo.setIntClubname(rs.getString("INTCLUBNAME"));
					eplVo.setIntContents(rs.getString("INTCONTENTS"));
					eplVo.setIntHistory(rs.getString("INTHISTORY"));
					eplVo.setIntName(rs.getString("INTNAME"));
					eplVo.setIntId(rs.getString("INTID"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return eplVo;
		}
	}
	
	
	

