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
		System.out.print("MemberDAO.java");
		return instance;
	}
	

	
	//회원 등록
	public void insertMember(MemberVO memVo) {
		String sql = "INSERT INTO TBL_MEMBER("
				+ "	  MEMBERID, MEMBERPWD, MEMBERNAME, AUTHORITY)"
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
		String sql = "select MEMBERID from TBL_MEMBER where MEMBERID=?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  memId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;			//ID 중복
			} else {
				result = -1;		//ID 중복 아님
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
		String sql = "select MEMBERPWD from TBL_MEMBER where MEMBERID=?";
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("memberPwd")!=null && rs.getString("memberPwd").equals(pwd)){
					System.out.println("로그인성공(useerCheck)");
					result = 1;//로그인 성공
				} else {
					System.out.println("비밀번호가 틀립니다.(useerCheck)");
					result = 0;// 비밀번호 불일치
				}
			}else {
					System.out.println("아이디가 존재하지 않습니다.(useerCheck)");
					result = -1; //아이디없음
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
		String sql = "select * from TBL_MEMBER where MEMBERID = ?";
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