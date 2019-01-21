package com.sh.vo;

public class MemberVO {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private int authority;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", authority=" + authority + "]";
	}

}
