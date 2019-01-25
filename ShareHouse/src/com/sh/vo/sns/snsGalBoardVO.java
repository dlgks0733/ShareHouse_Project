package com.sh.vo.sns;

import java.sql.Date;

public class snsGalBoardVO {

	/**
	 * @author Lee Han
	 */

	/*
	 * GALNUM NOT NULL VARCHAR2(50) GALTITLE NOT NULL VARCHAR2(150) GALCONTENTS NOT
	 * NULL VARCHAR2(3000) GALDATE NOT NULL DATE GALHITS NOT NULL NUMBER(4) ADMINID
	 * VARCHAR2(10)
	 */

	private String galNum;
	private String galTitle;
	private String galContents;
	private Date galDate;
	private int galHits;
	private String adminId;
	private String fileName;
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getGalNum() {
		return galNum;
	}

	public void setGalNum(String galNum) {
		this.galNum = galNum;
	}

	public String getGalTitle() {
		return galTitle;
	}

	public void setGalTitle(String galTitle) {
		this.galTitle = galTitle;
	}

	public String getGalContents() {
		return galContents;
	}

	public void setGalContents(String galContents) {
		this.galContents = galContents;
	}

	public Date getGalDate() {
		return galDate;
	}

	public void setGalDate(Date galDate) {
		this.galDate = galDate;
	}

	public int getGalHits() {
		return galHits;
	}

	public void setGalHits(int galHits) {
		this.galHits = galHits;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "MlbGalBoardVO [galNum=" + galNum + ", galTitle=" + galTitle + ", galContents=" + galContents
				+ ", galDate=" + galDate + ", galHits=" + galHits + ", adminId=" + adminId + ", fileName=" + fileName
				+ "]";
	}

	

}
