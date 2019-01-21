package com.sh.vo;
/*(
	    GAL_NUM               VARCHAR2(50) CONSTRAINT STARTUP_GAL_NUM_FK REFERENCES TBL_STU_GALLERY(GAL_NUM),
		FILE_NAME             VARCHAR2(99) CONSTRAINT STARTUP_FILE_NAME_NN NOT NULL  
	);*/
public class StuImageFileVO {
	
	private String GalNum;
	private String FileName;
	
	public String getGalNum() {
		return GalNum;
	}
	public void setGalNum(String galNum) {
		GalNum = galNum;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	@Override
	public String toString() {
		return "StuImageFile [GalNum=" + GalNum + ", FileName=" + FileName + "]";
	}
	
	
}
