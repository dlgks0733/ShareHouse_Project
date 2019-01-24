package com.sh.vo;

import java.sql.Date;

public class MlbBoardVO extends MemberVO{

	private String bodNum;
	private String bodTitle;
	private String bodContents;
	private int bodHits;
	private Date bodDate;
	private String memberId;
	private String adminId;

	public String getBodNum() {
		return bodNum;
	}

	public void setBodNum(String bodNum) {
		this.bodNum = bodNum;
	}

	public String getBodTitle() {
		return bodTitle;
	}

	public void setBodTitle(String bodTitle) {
		this.bodTitle = bodTitle;
	}

	public String getBodContents() {
		return bodContents;
	}

	public void setBodContents(String bodContents) {
		this.bodContents = bodContents;
	}

	public int getBodHits() {
		return bodHits;
	}

	public void setBodHits(int bodHits) {
		this.bodHits = bodHits;
	}

	public Date getBodDate() {
		return bodDate;
	}

	public void setBodDate(Date bodDate) {
		this.bodDate = bodDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "MlbBoardVO [bodNum=" + bodNum + ", bodTitle=" + bodTitle + ", bodContents=" + bodContents + ", bodHits="
				+ bodHits + ", bodDate=" + bodDate + ", memberId=" + memberId + ", adminId=" + adminId + "]";
	}

}
