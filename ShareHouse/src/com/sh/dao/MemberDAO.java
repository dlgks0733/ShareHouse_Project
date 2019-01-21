package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sh.vo.MemberVO;

import util.DBManager;

public class MemberDAO extends DBManager {

	private static MemberDAO instance;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	//회원 등록
	public void insertMember(MemberVO memVo) {
		String sql = "INSERT INTO TBL_MEMBER("
				+ "	  MEMBER_ID, MEMBER_PWD, MEMBER_NAME, AUTHORITY)"
				+ "	  VALUES(?, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMemberId());
			pstmt.setString(2, memVo.getMemberPwd());
			pstmt.setString(3, memVo.getMemberName());
			pstmt.setInt(4, memVo.getAuthority());
			
			pstmt.executeUpdate();
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
			dbClose();
		}
		
	}
	
}
