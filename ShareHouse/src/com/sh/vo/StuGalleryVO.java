package com.sh.vo;
/*(
		GAL_NUM               VARCHAR2(50)  CONSTRAINT STARTUP_GAL_NUM_NUM_PK PRIMARY KEY ,
		GAL_TITLE             VARCHAR2(150) CONSTRAINT STARTUP_GAL_TITLE_NN NOT NULL ,
		GAL_CONTENTS          VARCHAR2(3000) CONSTRAINT STARTUP_GAL_CONTENTS_NN NOT NULL ,
		GAL_DATE              DATE DEFAULT SYSDATE CONSTRAINT STARTUP_GAL_DATE_NN NOT NULL ,
		GAL_HITS              NUMBER(4) DEFAULT 0 CONSTRAINT STARTUP_GAL_HITS_NN NOT NULL ,
		ADMIN_ID              VARCHAR2(10)  CONSTRAINT STARTUP_GAL_ADMIN_ID_FK REFERENCES TBL_STU_ADMIN(ADMIN_ID) 
	);*/

import java.util.Date;

public class StuGalleryVO {
	
	private String GalNum;
	private String GalTitle;
	private String GalContents;
	private Date GalDate;
	private int GalHits;
	private String AdminId;
	
	public String getGalNum() {
		return GalNum;
	}
	public void setGalNum(String galNum) {
		GalNum = galNum;
	}
	public String getGalTitle() {
		return GalTitle;
	}
	public void setGalTitle(String galTitle) {
		GalTitle = galTitle;
	}
	public String getGalContents() {
		return GalContents;
	}
	public void setGalContents(String galContents) {
		GalContents = galContents;
	}
	public Date getGalDate() {
		return GalDate;
	}
	public void setGalDate(Date galDate) {
		GalDate = galDate;
	}
	public int getGalHits() {
		return GalHits;
	}
	public void setGalHits(int galHits) {
		GalHits = galHits;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	
	@Override
	public String toString() {
		return "StuGalleryVO [GalNum=" + GalNum + ", GalTitle=" + GalTitle + ", GalContents=" + GalContents
				+ ", GalDate=" + GalDate + ", GalHits=" + GalHits + ", AdminId=" + AdminId + "]";
	}
	
	
}
