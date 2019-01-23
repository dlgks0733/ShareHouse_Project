package com.sh.dao;

import util.DBManager;

public class MlbGalBoardDAO extends DBManager{
	
	private static MlbGalBoardDAO instance;
	
	private MlbGalBoardDAO() {
		
	}
	
	public static MlbGalBoardDAO getInstance() {
		if(instance == null) {
			instance = new MlbGalBoardDAO();
		}
		return instance;
	}
	
}
