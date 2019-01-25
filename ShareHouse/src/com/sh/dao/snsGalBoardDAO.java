package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sh.vo.sns.snsGalBoardVO;

import util.DBManager;

public class snsGalBoardDAO extends DBManager{
	
	private static snsGalBoardDAO instance;
	
	private snsGalBoardDAO() {
		
	}
	
	public static snsGalBoardDAO getInstance() {
		if(instance == null) {
			instance = new snsGalBoardDAO();
		}
		return instance;
	}
	
	//갤러리 SEQ 받기
	public String getGalSeq() {
		String sql = "SELECT sns_GALNUM_SEQ.CURRVAL AS CUR FROM DUAL";
		
		String seq = "";
		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				seq = rs.getString("CUR");
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return seq;
	}
	
	
	//갤러리 게시판 등록
	public int insertGalBoard(snsGalBoardVO snsVo) {
		
		int res =0;
		
		String sql = "INSERT INTO TBL_sns_GALLERY("
				+ "	  GALNUM, GALTITLE, GALCONTENTS, ADMINID)"
				+ "	  VALUES(sns_GALNUM_SEQ.NEXTVAL, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql, new String[]{"GALNUM" });
			pstmt.setString(1, snsVo.getGalTitle());
			pstmt.setString(2, snsVo.getGalContents());
			pstmt.setString(3, snsVo.getAdminId());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rs.next()){
				
				res = rs.getInt(1);
			  System.out.println("res: " + res);
			}
			
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		
		return res;
	}
	
	//갤러리 게시판 리스트 불러오기
	public ArrayList<snsGalBoardVO> snsGalBoardList(){
		
		ArrayList<snsGalBoardVO> list = new ArrayList<snsGalBoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT g.galNum, g.galTitle, g.galContents, g.galDate, g.galHits, g.adminId,i.fileName as \"FileName\"" + 
				"  	  FROM tbl_sns_gallery g, tbl_sns_imagefile i" + 
				"	  WHERE g.galNum = i.galNum" + 
				"	  ORDER BY g.galNum DESC";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				snsGalBoardVO snsVo = new snsGalBoardVO();
				snsVo.setGalNum(rs.getString("GALNUM"));
				snsVo.setGalTitle(rs.getString("GALTITLE"));
				snsVo.setGalContents(rs.getString("GALCONTENTS"));
				snsVo.setGalDate(rs.getDate("GALDATE"));
				snsVo.setGalHits(rs.getInt("GALHITS"));
				snsVo.setAdminId(rs.getString("ADMINID"));
				snsVo.setFileName(rs.getString("FileName"));
				
				
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
		public snsGalBoardVO snsGalBoardView(String galNum) {
			String sql = "SELECT g.galNum, g.galTitle, g.galContents, g.galDate, g.galHits, g.adminId,i.fileName as \"FileName\"" + 
					"  	  FROM tbl_sns_gallery g, tbl_sns_imagefile i" + 
					"	  WHERE g.galNum = i.galNum AND g.galNum = ?";
			
			snsGalBoardVO snsVo = null;
			Connection conn = getConnection();
			PreparedStatement pstmt;
			ResultSet rs = null;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, galNum);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					snsVo = new snsGalBoardVO();
					
					snsVo.setGalNum(rs.getString("GALNUM"));
					snsVo.setGalTitle(rs.getString("GALTITLE"));
					snsVo.setGalContents(rs.getString("GALCONTENTS"));
					snsVo.setGalDate(rs.getDate("GALDATE"));
					snsVo.setGalHits(rs.getInt("GALHITS"));
					snsVo.setAdminId(rs.getString("ADMINID"));
					snsVo.setFileName(rs.getString("FileName"));
					
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			
			return snsVo;
			
		}
		
		public void deleteGalBoard(String galNum) {
			
			String sql = "DELETE FROM TBL_sns_GALLERY WHERE GALNUM = ?";
			
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, galNum);
				
				pstmt.executeUpdate();
				
			}	catch (SQLException e) {
				e.printStackTrace();
			}	finally {
				dbClose();
			}
			
		}
	
	
	
}
