package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
}
