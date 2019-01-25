package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sh.vo.sns.snsImageFileVO;

import util.DBManager;

public class snsImageFileDAO extends DBManager{

	private static snsImageFileDAO instance;
	
	private snsImageFileDAO() {
		
	}
	
	public static snsImageFileDAO getInstance() {
		if(instance == null) {
			instance = new snsImageFileDAO();
		}
		return instance;
	}

	//이미지 파일 등록
	
	public void insertsnsImageFile(snsImageFileVO snsVo) {
		String sql = "INSERT INTO TBL_sns_IMAGEFILE("
				+ "	  GALNUM, FILENAME)"
				+ "	  VALUES(?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snsVo.getGalNum());
			pstmt.setString(2, snsVo.getFileName());
			
			pstmt.executeUpdate();
		}	catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	//이미지 삭제 
	public void deletesnsImage(String galNum) {
		
		String sql = "DELETE FROM TBL_sns_IMAGEFILE WHERE GALNUM = ?";
		
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
	
	/*public ArrayList<snsImageFileVO> snsImageList(){
		
		ArrayList<snsImageFileVO> imgList = new ArrayList<snsImageFileVO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_sns_IMAGEFILE";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				snsImageFileVO snsVo = new snsImageFileVO();
				snsVo.setGalNum(rs.getString("GALNUM"));
				snsVo.setFileName(rs.getString("FILENAME"));
				
				imgList.add(snsVo);
				
			}
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		return imgList;
	}*/
	
}
