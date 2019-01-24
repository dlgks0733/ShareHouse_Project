package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sh.vo.MlbGalBoardVO;

import util.DBManager;

public class MlbGalBoardDAO extends DBManager{
	
	private static MlbGalBoardDAO instance;
	
	private MlbGalBoardDAO() {
		
	}
	
	public static MlbGalBoardDAO getInstance() {
		if(instance == null) {
			instance = new MlbGalBoardDAO();
		}
		return instance;
	}
	
	//갤러리 SEQ 받기
	public String getGalSeq() {
		String sql = "SELECT MLB_GALNUM_SEQ.CURRVAL AS CUR FROM DUAL";
		
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
	public int insertGalBoard(MlbGalBoardVO mlbVo) {
		
		int res =0;
		
		String sql = "INSERT INTO TBL_MLB_GALLERY("
				+ "	  GALNUM, GALTITLE, GALCONTENTS, ADMINID)"
				+ "	  VALUES(MLB_GALNUM_SEQ.NEXTVAL, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql, new String[]{"GALNUM" });
			pstmt.setString(1, mlbVo.getGalTitle());
			pstmt.setString(2, mlbVo.getGalContents());
			pstmt.setString(3, mlbVo.getAdminId());
			
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
	public ArrayList<MlbGalBoardVO> mlbGalBoardList(){
		
		ArrayList<MlbGalBoardVO> list = new ArrayList<MlbGalBoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT g.galNum, g.galTitle, g.galContents, g.galDate, g.galHits, g.adminId,i.fileName as \"FileName\"" + 
				"  	  FROM tbl_mlb_gallery g, tbl_mlb_imagefile i" + 
				"	  WHERE g.galNum = i.galNum" + 
				"	  ORDER BY g.galNum DESC";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MlbGalBoardVO mlbVo = new MlbGalBoardVO();
				mlbVo.setGalNum(rs.getString("GALNUM"));
				mlbVo.setGalTitle(rs.getString("GALTITLE"));
				mlbVo.setGalContents(rs.getString("GALCONTENTS"));
				mlbVo.setGalDate(rs.getDate("GALDATE"));
				mlbVo.setGalHits(rs.getInt("GALHITS"));
				mlbVo.setAdminId(rs.getString("ADMINID"));
				mlbVo.setFileName(rs.getString("FileName"));
				
				
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
		public MlbGalBoardVO mlbGalBoardView(String galNum) {
			String sql = "SELECT g.galNum, g.galTitle, g.galContents, g.galDate, g.galHits, g.adminId,i.fileName as \"FileName\"" + 
					"  	  FROM tbl_mlb_gallery g, tbl_mlb_imagefile i" + 
					"	  WHERE g.galNum = i.galNum AND g.galNum = ?";
			
			MlbGalBoardVO mlbVo = null;
			Connection conn = getConnection();
			PreparedStatement pstmt;
			ResultSet rs = null;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, galNum);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					mlbVo = new MlbGalBoardVO();
					
					mlbVo.setGalNum(rs.getString("GALNUM"));
					mlbVo.setGalTitle(rs.getString("GALTITLE"));
					mlbVo.setGalContents(rs.getString("GALCONTENTS"));
					mlbVo.setGalDate(rs.getDate("GALDATE"));
					mlbVo.setGalHits(rs.getInt("GALHITS"));
					mlbVo.setAdminId(rs.getString("ADMINID"));
					mlbVo.setFileName(rs.getString("FileName"));
					
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			
			return mlbVo;
			
		}
		
		public void deleteGalBoard(String galNum) {
			
			String sql = "DELETE FROM TBL_MLB_GALLERY WHERE GALNUM = ?";
			
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
