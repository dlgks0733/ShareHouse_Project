package com.sh.vo;
/*(
		ADMIN_ID              VARCHAR2(10)  CONSTRAINT STU_ADMIN_ID_FK REFERENCES TBL_STU_ADMIN(ADMIN_ID),
	    INT_CLUBNAME          VARCHAR2(50)  CONSTRAINT STARTUP_INT_CLUMNAME_NN NOT NULL,
		INT_CONTENTS          VARCHAR2(3000) CONSTRAINT STARTUP_INT_CONTENTS_NN NOT NULL ,
		INT_HISTORY           VARCHAR2(1000) CONSTRAINT STARTUP_INT_HISTORY_NN NOT NULL ,
		INT_NAME              VARCHAR2(15)  NULL ,
		INT_ID                VARCHAR2(8)   NULL ,
		INT_RANK              VARCHAR2(30)  NULL 
	);*/
public class StuIntroductionVO {
	private String AdminId;
	private String IntClubName;
	private String IntContents;
	private String IntHistory;
	private String IntName;
	private String IntId;
	private String IntRank;
	
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public String getIntClubName() {
		return IntClubName;
	}
	public void setIntClubName(String intClubName) {
		IntClubName = intClubName;
	}
	public String getIntContents() {
		return IntContents;
	}
	public void setIntContents(String intContents) {
		IntContents = intContents;
	}
	public String getIntHistory() {
		return IntHistory;
	}
	public void setIntHistory(String intHistory) {
		IntHistory = intHistory;
	}
	public String getIntName() {
		return IntName;
	}
	public void setIntName(String intName) {
		IntName = intName;
	}
	public String getIntId() {
		return IntId;
	}
	public void setIntId(String intId) {
		IntId = intId;
	}
	public String getIntRank() {
		return IntRank;
	}
	public void setIntRank(String intRank) {
		IntRank = intRank;
	}
	
	@Override
	public String toString() {
		return "StuIntroductionVO [AdminId=" + AdminId + ", IntClubName=" + IntClubName + ", IntContents=" + IntContents
				+ ", IntHistory=" + IntHistory + ", IntName=" + IntName + ", IntId=" + IntId + ", IntRank=" + IntRank
				+ "]";
	}
	
	
}
