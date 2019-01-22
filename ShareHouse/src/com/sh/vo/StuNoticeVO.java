package com.sh.vo;

import java.util.Date;

/*CREATE TABLE TBL_STU_NOTICE
(
	NOC_NUM            VARCHAR2(50)  CONSTRAINT STARTUP_NOC_NUM_PK PRIMARY KEY ,
	NOC_TITLE          VARCHAR2(150) CONSTRAINT STARTUP_NOC_TITLE_NN NOT NULL ,
    NOC_CONTENTS       VARCHAR2(3000) CONSTRAINT STARTUP_NOC_CONTENTS_NN NOT NULL ,
    NOC_HITS           NUMBER(4) DEFAULT 0 CONSTRAINT STARTUP_NOC_HITS_NN NOT NULL ,
    NOC_DATE           DATE DEFAULT SYSDATE  CONSTRAINT STARTUP_NOC_DATE_NN NOT NULL,
    ADMIN_ID           VARCHAR2(10)  CONSTRAINT STARTUP_ADMIN_ID_FK REFERENCES TBL_STU_ADMIN(ADMIN_ID)
);*/
public class StuNoticeVO {

	private String NocNum;
	private String NocTitle;
	private String NocContents;
	private int NocHits;
	private Date NocDate;
	private String AdminId;
	
	public String getNocNum() {
		return NocNum;
	}
	public void setNocNum(String nocNum) {
		NocNum = nocNum;
	}
	public String getNocTitle() {
		return NocTitle;
	}
	public void setNocTitle(String nocTitle) {
		NocTitle = nocTitle;
	}
	public String getNocContents() {
		return NocContents;
	}
	public void setNocContents(String nocContents) {
		NocContents = nocContents;
	}
	public int getNocHits() {
		return NocHits;
	}
	public void setNocHits(int nocHits) {
		NocHits = nocHits;
	}
	public Date getNocDate() {
		return NocDate;
	}
	public void setNocDate(Date nocDate) {
		NocDate = nocDate;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	
	@Override
	public String toString() {
		return "StuNoiceVO [NocNum=" + NocNum + ", NocTitle=" + NocTitle + ", NocContents=" + NocContents + ", NocHits="
				+ NocHits + ", NocDate=" + NocDate + ", AdminId=" + AdminId + "]";
	}
	
	
}
