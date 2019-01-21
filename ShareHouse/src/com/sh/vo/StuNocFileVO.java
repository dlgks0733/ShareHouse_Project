package com.sh.vo;
/*(
	    NOC_NUM            VARCHAR2(50)  CONSTRAINT STU_NOC_NUM_FK REFERENCES TBL_STU_NOTICE(NOC_NUM) ,
	    FILENAME           VARCHAR2(150) CONSTRAINT STU_NOCFILENAME_NN NOT NULL
	);*/
public class StuNocFileVO {

	private String NocNum;
	private String FileName;
	
	public String getNocNum() {
		return NocNum;
	}
	public void setNocNum(String nocNum) {
		NocNum = nocNum;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	@Override
	public String toString() {
		return "StuNocFile [NocNum=" + NocNum + ", FileName=" + FileName + "]";
	}
	
}
