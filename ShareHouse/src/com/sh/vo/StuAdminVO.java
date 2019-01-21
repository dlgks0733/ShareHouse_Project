package com.sh.vo;
/*(
		ADMIN_ID              VARCHAR2(10) CONSTRAINT STARTUP_ADMIN_ID_PK PRIMARY KEY ,
		ADMIN_PWD             VARCHAR2(12) CONSTRAINT STARTUP_ADMIN_PWD_NN NOT NULL,
		AUTHORITY             NUMBER(1)    CONSTRAINT STARTUP_ADMIN_AUTHORITY_NN NOT NULL 
	);*/
public class StuAdminVO {

	private String AdminId;
	private String AdminPwd;
	private int Authority;
	
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	public int getAuthority() {
		return Authority;
	}
	public void setAuthority(int authority) {
		Authority = authority;
	}
	
	@Override
	public String toString() {
		return "StuAdmin [AdminId=" + AdminId + ", AdminPwd=" + AdminPwd + ", Authority=" + Authority + "]";
	}
	
	
}
