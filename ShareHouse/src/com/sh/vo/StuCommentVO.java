package com.sh.vo;
/*(
		COMM_NUM              VARCHAR2(50)  CONSTRAINT STARTUP_COMM_NUM_PK PRIMARY KEY ,
		COMM_CONTENTS         VARCHAR2(3000) CONSTRAINT STARTUP_COMM_CONTENTS_NN NOT NULL ,
		COMM_DATE             DATE DEFAULT SYSDATE CONSTRAINT STARTUP_COMM_DATE_NN NOT NULL ,
		BOD_NUM               VARCHAR2(50)  CONSTRAINT STARTUP_BOD_NUM_FK REFERENCES TBL_STU_BOARD(BOD_NUM) ,
		MEMBER_ID             VARCHAR2(8)   CONSTRAINT STARTUP_COMM_MEBMER_ID_FK REFERENCES TBL_MEMBER(MEMBER_ID) 
	);*/

import java.util.Date;

public class StuCommentVO extends MemberVO {
	
	private String commNum;
	private String commContents;
	private Date commDate;
	private String bodNum;
	private String memberId;
	
	public String getCommNum() {
		return commNum;
	}
	public void setCommNum(String commNum) {
		this.commNum = commNum;
	}
	public String getCommContents() {
		return commContents;
	}
	public void setCommContents(String commContents) {
		this.commContents = commContents;
	}
	public Date getCommDate() {
		return commDate;
	}
	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}
	public String getBodNum() {
		return bodNum;
	}
	public void setBodNum(String bodNum) {
		this.bodNum = bodNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "StuCommentVO [commNum=" + commNum + ", commContents=" + commContents + ", commDate=" + commDate
				+ ", bodNum=" + bodNum + ", memberId=" + memberId + "]";
	}
	
	
	
	
	
}
