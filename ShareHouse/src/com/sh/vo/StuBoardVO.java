package com.sh.vo;

import java.util.Date;



import java.sql.Timestamp;

public class StuBoardVO {
/*	CREATE TABLE TBL_STU_BOARD
	(
		BOD_NUM             VARCHAR2(50)  CONSTRAINT STARTUP_BOD_NUM_PK PRIMARY KEY ,
		BOD_TITLE           VARCHAR2(150) CONSTRAINT STARTUP_BOD_TITLE_NN NOT NULL ,
		BOD_CONTENTS        VARCHAR2(3000) CONSTRAINT STARTUP_BOD_CONTENTS_NN NOT NULL ,
	    BOD_HITS            NUMBER(4) DEFAULT 0 CONSTRAINT STARTUP_BOD_HITS_NN NOT NULL ,
	    BOD_DATE            DATE DEFAULT SYSDATE  CONSTRAINT STARTUP_BOD_DATE_NN NOT NULL ,
	    MEMBER_ID           VARCHAR2(8)   CONSTRAINT STARTUP_BOD_MEBMER_ID_FK REFERENCES TBL_MEMBER(MEMBER_ID),
		ADMIN_ID            VARCHAR2(10)  CONSTRAINT STARTUP_BOD_ADMIN_ID_FK REFERENCES TBL_STU_ADMIN(ADMIN_ID)
	);*/
	
	private String BodNum;
	private String BodTitle;
	private String BodContents;
	private int BodHits;
	private Date BodDate;
	private String MemberId;
	private String AdminId;
	
	public String getBodNum() {
		return BodNum;
	}
	public void setBodNum(String bodNum) {
		BodNum = bodNum;
	}
	public String getBodTitle() {
		return BodTitle;
	}
	public void setBodTitle(String bodTitle) {
		BodTitle = bodTitle;
	}
	public String getBodContents() {
		return BodContents;
	}
	public void setBodContents(String bodContents) {
		BodContents = bodContents;
	}
	public int getBodHits() {
		return BodHits;
	}
	public void setBodHits(int bodHits) {
		BodHits = bodHits;
	}
	public Date getBodDate() {
		return BodDate;
	}
	public void setBodDate(Date bodDate) {
		BodDate = bodDate;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	
	
}