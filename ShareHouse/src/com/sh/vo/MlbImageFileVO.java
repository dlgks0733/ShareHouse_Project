package com.sh.vo;

public class MlbImageFileVO {

	private String galNum;
	private String fileName;

	public String getGalNum() {
		return galNum;
	}

	public void setGalNum(String galNum) {
		this.galNum = galNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MlbImageFileVO [galNum=" + galNum + ", fileName=" + fileName + "]";
	}

	
	
}
