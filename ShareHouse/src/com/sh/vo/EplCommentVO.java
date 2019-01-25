package com.sh.vo;

public class EplCommentVO extends MemberVO {
	
	private String commNum;
	private String commContents;
	private String commDate;
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
	public String getCommDate() {
		return commDate;
	}
	public void setCommDate(String commDate) {
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
		return "EplCommentVO [commNum=" + commNum + ", commContents=" + commContents + ", commDate=" + commDate
				+ ", bodNum=" + bodNum + ", memberId=" + memberId + "]";
	}
	
	
	
}
