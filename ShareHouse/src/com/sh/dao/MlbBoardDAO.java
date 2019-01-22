package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
