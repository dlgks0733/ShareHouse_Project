package com.sh.vo.sns;

import java.sql.Date;

public class snsCommentVO {
	
	private String COMMNUM;			//댓글 번호
	private String COMMCONTENTS;	//댓글 내용
	private Date COMMDATE;			//댓글 작성일
	private String BODNUM;			//게시글 번호
	private String MEMBERID;		//댓글 작성자
	
	
	public String getCOMMNUM() {
		return COMMNUM;
	}
	public void setCOMMNUM(String cOMMNUM) {
		COMMNUM = cOMMNUM;
	}
	public String getCOMMCONTENTS() {
		return COMMCONTENTS;
	}
	public void setCOMMCONTENTS(String cOMMCONTENTS) {
		COMMCONTENTS = cOMMCONTENTS;
	}
	public Date getCOMMDATE() {
		return COMMDATE;
	}
	public void setCOMMDATE(Date cOMMDATE) {
		COMMDATE = cOMMDATE;
	}
	public String getBODNUM() {
		return BODNUM;
	}
	public void setBODNUM(String bODNUM) {
		BODNUM = bODNUM;
	}
	public String getMEMBERID() {
		return MEMBERID;
	}
	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}
	
	@Override
	public String toString() {
		return "snsCommentVO [COMMNUM=" + COMMNUM + ", COMMCONTENTS=" + COMMCONTENTS + ", COMMDATE=" + COMMDATE
				+ ", BODNUM=" + BODNUM + ", MEMBERID=" + MEMBERID + "]";
	}

	
	
	
}
