package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sh.vo.MlbImageFileVO;

import util.DBManager;

public class MlbImageFileDAO extends DBManager{

	private static MlbImageFileDAO instance;
	
	private MlbImageFileDAO() {
		
	}
	
	public static MlbImageFileDAO getInstance() {
		if(instance == null) {
			instance = new MlbImageFileDAO();
		}
		return instance;
	}

	//이미지 파일 등록
	
	public void insertMlbImageFile(MlbImageFileVO mlbVo) {
		String sql = "INSERT INTO TBL_MLB_IMAGEFILE("
				+ "	  GALNUM, FILENAME)"
				+ "	  VALUES(?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mlbVo.getGalNum());
			pstmt.setString(2, mlbVo.getFileName());
			
			pstmt.executeUpdate();
		}	catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
}
