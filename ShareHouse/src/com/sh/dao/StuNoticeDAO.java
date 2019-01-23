package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.sh.vo.StuBoardVO;
import com.sh.vo.StuNoticeVO;

import util.DBManager;

public class StuNoticeDAO extends DBManager{
	private StuNoticeDAO(){
		
	} 
	private static StuNoticeDAO instance = new StuNoticeDAO();
	
	public static StuNoticeDAO getInstance() {
		
		return instance;
	}
	
	public ArrayList<StuNoticeVO> noticeAlllist(){
	
	String sql = "SELECT * FROM TBL_STU_NOTICE";
	
	ArrayList<StuNoticeVO> list = new ArrayList<StuNoticeVO>();
	Connection conn = getConnection();
	PreparedStatement psmt;
	ResultSet rs = null;
	
/*  private String NocNum;
	private String NocTitle;
	private String NocContents;
	private int NocHits;
	private Date NocDate;
	private String AdminId;*/
	
	try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			StuNoticeVO stuVO = new StuNoticeVO();
			
			stuVO.setNocNum(rs.getString("nocNum"));
			stuVO.setNocTitle(rs.getString("nocTitle"));
			stuVO.setNocHits(rs.getInt("nocHits"));
			stuVO.setNocDate(rs.getDate("nocDate"));
			
			list.add(stuVO);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		dbClose();
	}
	return list;
}

	public void insertNotice(StuNoticeVO stuVO) {
		String sql = "INSERT INTO TBL_STU_NOTICE(NOCNUM, NOCTITLE, NOCCONTENTS)"
				+ "VALUES(STU_NOCNUM_SEQ.nextval, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement psmt;
		
		try {
			psmt = conn.prepareStatement(sql);
					
			psmt.setString(1, stuVO.getNocTitle());
			psmt.setString(2, stuVO.getNocContents());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	public StuNoticeVO nocNumlist(String nocNum){
		String sql = "SELECT * FROM TBL_STU_NOTICE WHERE NOCNUM = ?";
		
		StuNoticeVO stuVO  = null;
		Connection conn = getConnection();
		PreparedStatement psmt;
		ResultSet rs = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nocNum);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				stuVO = new StuNoticeVO();
				
				stuVO.setNocNum(rs.getString("nocNum"));
				stuVO.setNocTitle(rs.getString("nocTitle"));
				stuVO.setNocContents(rs.getString("nocContents"));
				stuVO.setNocDate(rs.getDate("nocDate"));
				stuVO.setNocHits(rs.getInt("nocHits"));
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return stuVO;
	}
	
	public void noticeUpdate(StuNoticeVO stuVO) {
		String sql = "UPDATE TBL_STU_NOTICE SET NOCTITLE = ?, NOCCONTENTS = ? WHERE NOCNUM = ?";
		
		Connection conn = getConnection();
		PreparedStatement psmt;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stuVO.getNocTitle());
			psmt.setString(2, stuVO.getNocContents());
			psmt.setString(3, stuVO.getNocNum());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public void noticeDelete(String nocNum) {
		String sql = "DELETE TBL_STU_NOTICE WHERE NOCNUM = ?";
		
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nocNum);
			psmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}

