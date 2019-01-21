package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	//아이디 중복체크
	public int confirmID(String memId) {
		int result = -1;
		String sql = "select MEMBER_ID from TBL_MEMBER where MEMBER_ID=?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  memId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;			//중복된 ID가 없음
			} else {
				result = -1;		//
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	
	
	//사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from TBL_MEMBER where userid=?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)){
					result = 1;
				} else {
					result = 0;
				}
			}else {
					result = -1;
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	
	//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;
		String sql = "select * from TBL_MEMBER where userid = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mVo = new MemberVO();
				mVo.setMemberId(rs.getString("memberId"));
				mVo.setMemberPwd(rs.getString("memberPwd"));
				mVo.setMemberName(rs.getString("memberName"));
				
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return mVo;
	}
	
	
}
