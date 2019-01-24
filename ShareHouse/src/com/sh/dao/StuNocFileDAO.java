package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sh.vo.StuNocFileVO;

import util.DBManager;

public class StuNocFileDAO extends DBManager{
	private StuNocFileDAO() {
		
	}
	
	private static StuNocFileDAO instance = new StuNocFileDAO(); 
	
	public static StuNocFileDAO getInstance() {
		
		return instance;
	}
	
	public ArrayList<StuNocFileVO> nocfileSelect() {
		String sql = "SELECT * FROM TBL_STU_NOCFILE";
		
		ArrayList<StuNocFileVO> list = new ArrayList<StuNocFileVO>();
		
		Connection conn = getConnection();
		PreparedStatement psmt;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				StuNocFileVO stuVO = new StuNocFileVO();
				
				stuVO.setNocNum(rs.getString("nocNum"));
				stuVO.setFileName(rs.getString("fileName"));
				
				list.add(stuVO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	public void nocFileInsert(StuNocFileVO fileStuVO) {
		String sql = "INSERT INTO (NOCNUM,FILENAME) VALUES(STU_NOCNUM_SEQ.nextval, ?)";
		
		Connection conn = getConnection();
		PreparedStatement psmt;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,fileStuVO.getFileName());
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
}
