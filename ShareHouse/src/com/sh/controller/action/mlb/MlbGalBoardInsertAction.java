package com.sh.controller.action.mlb;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.controller.action.Action;
import com.sh.dao.MlbGalBoardDAO;
import com.sh.dao.MlbImageFileDAO;
import com.sh.vo.MlbGalBoardVO;
import com.sh.vo.MlbImageFileVO;

public class MlbGalBoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/*String galTitle = request.getParameter("galTitle");
		String fileName = request.getParameter("fileName");
		String galContents = request.getParameter("galContents");
		
		MlbGalBoardDAO mlbDao = MlbGalBoardDAO.getInstance();
		MlbGalBoardVO mlbVo = new MlbGalBoardVO();
		MlbImageFileDAO imgMlbDao = MlbImageFileDAO.getInstance();
		MlbImageFileVO imgMlbVo = new MlbImageFileVO();
		
		mlbVo.setGalTitle(galTitle);
		mlbVo.setGalContents(galContents);
		imgMlbVo.setFileName(fileName);*/
		
		MlbGalBoardDAO mlbDao = MlbGalBoardDAO.getInstance();
		MlbImageFileDAO imgMlbDao = MlbImageFileDAO.getInstance();
		
		MlbGalBoardVO mlbVo = (MlbGalBoardVO) request.getAttribute("mlbVo");
		System.out.println("mlbVo: "+ mlbVo);
		
		
		MlbImageFileVO imgMlbVo = (MlbImageFileVO) request.getAttribute("imgMlbVo");
		
		//갤러리 정보 저장
		int galNum = mlbDao.insertGalBoard(mlbVo);
		
		//겔러리 정보를 저장 후 PK 다시 돌려받기
		System.out.println("galNum : "+ galNum);
		imgMlbVo.setGalNum(String.valueOf(galNum));
		
		System.out.println("imgMlbVo : "+imgMlbVo);
		
		//이미지 정보 저장
		imgMlbDao.insertMlbImageFile(imgMlbVo);
		
		new MlbGalBoardListFormAction().execute(request, response);
		
		
		
	}

}
