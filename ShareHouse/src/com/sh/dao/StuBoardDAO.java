package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.sh.vo.EplCommentVO;
import com.sh.vo.StuBoardVO;
import com.sh.vo.StuCommentVO;
import com.sh.vo.StuNoticeVO;

import util.DBManager;
import util.Paging;

public class StuBoardDAO extends DBManager{
	private StuBoardDAO() {
	}
	
	private static StuBoardDAO instance = new StuBoardDAO();
	
	public static StuBoardDAO getInstance() {
		return instance;
	}
		// 게시판 목록
	public ArrayList<StuBoardVO> selectAllStuBoard(){
		
		String sql = "SELECT * FROM TBL_STU_BOARD ORDER BY BODNUM DESC";
		
		ArrayList<StuBoardVO> list = new ArrayList<StuBoardVO>();
		
	    Connection conn = getConnection();
	    PreparedStatement psmt;
	    ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				StuBoardVO stuVO = new StuBoardVO();
				
				stuVO.setBodNum(rs.getString("bodNum"));
				stuVO.setBodTitle(rs.getString("bodTitle"));
				stuVO.setBodHits(rs.getInt("bodHits"));
				stuVO.setBodDate(rs.getDate("bodDate"));

				
				
				list.add(stuVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	/*public ArrayList<StuBoardVO> selectNumStuBoard(String bodNum){
		
		String sql = "SELECT * FROM TBL_STU_BOARD WHERE BODNUM = " + bodNum +"";
		
		ArrayList<StuBoardVO> list = new ArrayList<StuBoardVO>();
		
	    Connection conn = getConnection();
	    PreparedStatement psmt;
	    ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				StuBoardVO stuVO = new StuBoardVO();
				
				stuVO.setBodNum(rs.getString("bodNum"));
				stuVO.setBodTitle(rs.getString("bodTitle"));
				stuVO.setBodContents(rs.getString("bodContents"));
				stuVO.setBodDate(rs.getDate("bodDate"));

				
				
				list.add(stuVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}*/
		// 게시판 글 등록
	   public void insertStuBoard(StuBoardVO stuVO) {
		     
		      String sql = "INSERT INTO TBL_STU_BOARD(BODNUM, BODTITLE, BODCONTENTS, MEMBERID)"
		      		+ "VALUES(STU_BODNUM_SEQ.nextval, ? , ?, ?)";
		 

		      Connection conn = getConnection();
		      PreparedStatement psmt;
		      

		      try {

		    	 psmt = conn.prepareStatement(sql);
		    	 
		    	 
		    	 psmt.setString(1, stuVO.getBodTitle());
		    	 psmt.setString(2, stuVO.getBodContents());
		    	 psmt.setString(3, stuVO.getMemberId());
		    	 //psmt.setString(4, stuVO.getAdminId());
		    	 psmt.executeUpdate(); 
		    	 
		   }catch (SQLException e){
			   e.printStackTrace();
		   }finally {
			   dbClose();
		   }
		}
	   //조회수 늘어나는거
	   public void updateHits(String bodNum) {
		   
		   String sql = "UPDATE TBL_STU_BOARD SET BODHITS = BODHITS +1 WHERE BODNUM = ?";
		   
		   Connection conn = getConnection();
		   PreparedStatement psmt;
		   
		   try {
			   
			   
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bodNum);
			
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		   
	   }
	   // 게시판 글 상세 내용 보기 글번호로 찾아온다.
	  public StuBoardVO selectOneBoardByBodNum(String BodNum) {
		  String sql = "SELECT STU.*, M.MEMBERNAME AS MEMBERNAME" + 
		  		"  FROM TBL_STU_BOARD STU, TBL_MEMBER M" + 
		  		" WHERE STU.MEMBERID = M.MEMBERID AND BODNUM = ?";
		  
		  StuBoardVO stuVO  = null;
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  ResultSet rs = null;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BodNum);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				stuVO = new StuBoardVO();
				
				stuVO.setBodNum(rs.getString("bodNum"));
				stuVO.setBodTitle(rs.getString("bodTitle"));
				stuVO.setBodContents(rs.getString("bodContents"));
				stuVO.setBodHits(rs.getInt("bodHits"));
				stuVO.setBodDate(rs.getDate("bodDate"));
				stuVO.setMemberId(rs.getString("memberId"));
				stuVO.setAdminId(rs.getString("adminId"));
				stuVO.setMemberName(rs.getString("MEMBERNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		  return stuVO;  
	  }
	  
	  public void updateStuBoard(StuBoardVO stuVO) {
		  String sql = "UPDATE TBL_STU_BOARD SET BODTITLE = ?, BODCONTENTS = ? WHERE BODNUM = ?";
		  
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stuVO.getBodTitle());
			psmt.setString(2, stuVO.getBodContents());
			psmt.setString(3, stuVO.getBodNum());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
				  
	  }
	  
	  public void deleteStuBoard(String bodNum) {
		  String sql = "DELETE FROM TBL_STU_BOARD WHERE BODNUM = ?";
		  
		  Connection conn = getConnection();
		  PreparedStatement psmt;
		  
		  try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bodNum);
			psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	   //공지사항 리스트 페이징처리
	   
/*	   public List<StuBoardVO> selectAllNoticesPerPage(Paging paging) {
	          
	        String sql = "SELECT * FROM ( "
	        		+ " SELECT ROWNUM AS PNUM, NOTI.*"
	              + "        FROM (SELECT (COUNT(*)OVER() - NOTI.RNUM + 1) REVRNUM"
	              + "                   , NOTI.*"
	              + "                FROM (SELECT ROWNUM RNUM"
	              + "                    , NOTI.BODNUM"
	              + "                    , NOTI.BODTITLE"
	              + "                    , NOTI.BODCONTENTS"
	              + "                    , NOTI.ADMINID"
	              + "					 , NOTI.BODDATE"
	              + "               FROM TBL_STU_BOARD NOTI"
	              + "              ORDER BY NOTI.BODDATE DESC) NOTI"
	              + "             ) NOTI"
	              + "     ) WHERE PNUM BETWEEN ? AND ?";
	        
	        System.out.println(sql);
	         
	         List<StuBoardVO> list = new ArrayList<StuBoardVO>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;

	         try {
	            conn = getConnection();
	            stmt = conn.prepareStatement(sql);
	            
	            
	            
	            stmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()) + 1);
	            stmt.setInt(2, ((paging.getPageNum() - 1) * paging.getPerPage()) + paging.getPerPage());
	            
	            
	            
	            rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	            	StuBoardVO stuVO = new StuBoardVO();
	               
	               stuVO.setrNum(rs.getInt("rNum"));
	               stuVO.setBodNum(rs.getString("bodNum"));
	               stuVO.setBodTitle(rs.getString("bodTitle"));
	               stuVO.setBodContents(rs.getString("bodContents"));
	               stuVO.setBodDate(rs.getDate("bodDate"));
	               
	               
	               list.add(stuVO);
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         } finally {
	            dbClose();
	         }
	         
	         
	         
	         return list;
	      } */
	  
	  public List<StuBoardVO> selectAllNoticesPerPage(Paging paging) {
          
	        String sql = "SELECT * FROM ( "
	        		+ "SELECT ROWNUM AS PNUM , NOTI.* FROM (SELECT (COUNT(*)OVER() - NOTI.RNUM + 1) REVRNUM" + 
	        		"                                     , NOTI.* FROM (SELECT ROWNUM RNUM" + 
	        		"                                     , NOTI.BODNUM" + 
	        		"	                                 , NOTI.BODTITLE" + 
	        		"	                                 , NOTI.BODCONTENTS" + 
	        		"	                                 , NOTI.ADMINID" + 
	        		"	              					 , NOTI.BODDATE" + 
	        		"                                     ,(SELECT MEMBERNAME from TBL_MEMBER where MEMBERID = NOTI.MEMBERID) as memname" + 
	        		"	                            FROM TBL_STU_BOARD NOTI" + 
	        		"	                           ORDER BY NOTI.BODDATE DESC) NOTI" + 
	        		"	                         ) NOTI" + 
	        		"	               )WHERE PNUM BETWEEN ? AND ?";
	         
	         List<StuBoardVO> list = new ArrayList<StuBoardVO>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;

	         try {
	            conn = getConnection();
	            stmt = conn.prepareStatement(sql);
	            
	            System.out.println(sql);
	            
	            stmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()) + 1);
	            stmt.setInt(2, ((paging.getPageNum() - 1) * paging.getPerPage()) + paging.getPerPage());
	            
	            
	            
	            rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	            	StuBoardVO stuVO = new StuBoardVO();
	               
	               stuVO.setrNum(rs.getInt("rNum"));
	               stuVO.setBodNum(rs.getString("bodNum"));
	               stuVO.setBodTitle(rs.getString("bodTitle"));
	               stuVO.setBodContents(rs.getString("bodContents"));
	               stuVO.setBodDate(rs.getDate("bodDate"));
	               stuVO.setMemberName(rs.getString("memname"));
	               
	               
	               list.add(stuVO);
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         } finally {
	            dbClose();
	         }
	         
	         
	         
	         return list;
	      }
	  
	   
	   
	   public Paging selectNoticeRowCount(Paging paging)
	   {
	      int cnt = 0;
	      
	      String sql = "SELECT COUNT(*) CNT"
	            + "     FROM TBL_STU_BOARD";
	      
	          Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         
	         try
	         {
	            conn = getConnection();
	            stmt = conn.prepareStatement(sql);
	            
	            rs = stmt.executeQuery();
	            
	            while (rs.next())
	            {
	               cnt = rs.getInt("CNT");
	               paging.setNumOfRow(cnt);;
	            }
	            
	         }
	         catch (SQLException e)
	         {
	            e.printStackTrace();
	         }
	         finally
	         {
	            dbClose();
	         }
	         
	         return paging;
	   }
	   
	 //댓글 등록
		public void insertComment(StuCommentVO stuVO) {
			
			String sql = "INSERT INTO TBL_STU_COMMENT("
					+ "COMMNUM, MEMBERID, COMMCONTENTS, BODNUM, COMMDATE) "
					+ "VALUES (STU_COMMNUM_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			Connection conn = getConnection();
			PreparedStatement pstmt;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stuVO.getMemberId());
				pstmt.setString(2, stuVO.getCommContents());
				pstmt.setString(3, stuVO.getBodNum());
				
				pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
		
		//댓글 리스트 불러오기
		public ArrayList<StuCommentVO> stuCommentList(String bodNum) {
			
			ArrayList<StuCommentVO> list = new ArrayList<StuCommentVO>();
			
			Connection conn = getConnection();
			PreparedStatement pstmt;
			ResultSet rs = null;
			
			String sql = "SELECT C.*, M.MEMBERNAME" + 
					"  FROM TBL_STU_COMMENT C, TBL_MEMBER M" + 
					" WHERE C.MEMBERID = M.MEMBERID AND BODNUM = ?" + 
					"ORDER BY COMMDATE ASC";
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bodNum);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					StuCommentVO stuVO = new StuCommentVO();
					
					stuVO.setCommNum(rs.getString("COMMNUM"));
					stuVO.setCommContents(rs.getString("COMMCONTENTS"));
					stuVO.setBodNum(rs.getString("BODNUM"));
					stuVO.setCommDate(rs.getDate("COMMDATE"));
					stuVO.setMemberId(rs.getString("MEMBERID"));
					stuVO.setMemberName(rs.getString("MEMBERNAME"));
					
					list.add(stuVO);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			
			return list;
		}
		
		public void stuCommentDelete(String commNum) {
			
			String sql = "DELETE FROM TBL_STU_COMMENT WHERE COMMNUM = ?";
			
			Connection conn = getConnection();
			PreparedStatement pstmt;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, commNum);
				pstmt.executeUpdate();
				
			}	catch (SQLException e) {
					e.printStackTrace();
			}	finally {
				
				dbClose();
			}
			
		}
		
		//게시글에 있는 모든 댓글 삭제
		
public void stuAllCommentDelete(String bodNum) {
			
			String sql = "DELETE FROM TBL_STU_COMMENT WHERE bodNum = ?";
			
			Connection conn = getConnection();
			PreparedStatement pstmt;
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bodNum);
				pstmt.executeUpdate();
				
			}	catch (SQLException e) {
					e.printStackTrace();
			}	finally {
				
				dbClose();
			}
			
		}

//댓글 수정
public void updateStuComment(StuCommentVO stuVo) {
	
	String sql = "UPDATE TBL_STU_COMMENT SET COMMCONTENTS = ?, COMMDATE = SYSDATE WHERE COMMNUM = ?";
	Connection conn = getConnection();
	PreparedStatement pstmt;
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stuVo.getCommContents());
		pstmt.setString(2, stuVo.getCommNum());
		pstmt.executeUpdate();
	}	catch (SQLException e) {
		e.printStackTrace();
	}	finally {
		dbClose();
	}
	
}


}
