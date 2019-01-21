package com.sh.vo;
/*(
		COMM_NUM              VARCHAR2(50)  CONSTRAINT STARTUP_COMM_NUM_PK PRIMARY KEY ,
		COMM_CONTENTS         VARCHAR2(3000) CONSTRAINT STARTUP_COMM_CONTENTS_NN NOT NULL ,
		COMM_DATE             DATE DEFAULT SYSDATE CONSTRAINT STARTUP_COMM_DATE_NN NOT NULL ,
		BOD_NUM               VARCHAR2(50)  CONSTRAINT STARTUP_BOD_NUM_FK REFERENCES TBL_STU_BOARD(BOD_NUM) ,
		MEMBER_ID             VARCHAR2(8)   CONSTRAINT STARTUP_COMM_MEBMER_ID_FK REFERENCES TBL_MEMBER(MEMBER_ID) 
	);*/

import java.util.Date;

public class StuCommentVO {
	
	private String CommNum;
	private String CommContents;
	private Date CommDate;
	private String BodNum;
	private String MemberId;
	
	public String getCommNum() {
		return CommNum;
	}
	public void setCommNum(String commNum) {
		CommNum = commNum;
	}
	public String getCommContents() {
		return CommContents;
	}
	public void setCommContents(String commContents) {
		CommContents = commContents;
	}
	public Date getCommDate() {
		return CommDate;
	}
	public void setCommDate(Date commDate) {
		CommDate = commDate;
	}
	public String getBodNum() {
		return BodNum;
	}
	public void setBodNum(String bodNum) {
		BodNum = bodNum;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	
	@Override
	public String toString() {
		return "StuComment [CommNum=" + CommNum + ", CommContents=" + CommContents + ", CommDate=" + CommDate
				+ ", BodNum=" + BodNum + ", MemberId=" + MemberId + "]";
	}
	
	
	
}
