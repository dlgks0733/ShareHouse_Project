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
	
	//이미지 삭제 
	public void deleteMlbImage(String galNum) {
		
		String sql = "DELETE FROM TBL_MLB_IMAGEFILE WHERE GALNUM = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
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
	
	
	
	//이미지 파일 리스트 불러오기
	
	/*public ArrayList<MlbImageFileVO> mlbImageList(){
		
		ArrayList<MlbImageFileVO> imgList = new ArrayList<MlbImageFileVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_MLB_IMAGEFILE";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MlbImageFileVO mlbVo = new MlbImageFileVO();
				mlbVo.setGalNum(rs.getString("GALNUM"));
				mlbVo.setFileName(rs.getString("FILENAME"));
				
				imgList.add(mlbVo);
				
			}
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		return imgList;
	}*/
	
}
