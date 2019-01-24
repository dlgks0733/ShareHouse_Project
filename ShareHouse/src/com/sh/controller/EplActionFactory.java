package com.sh.controller;

import com.sh.controller.action.Action;
import com.sh.controller.action.MainAction;
import com.sh.controller.action.epl.EplBoardDeleteAction;
import com.sh.controller.action.epl.EplBoardInsertAction;
import com.sh.controller.action.epl.EplBoardInsertFormAction;
import com.sh.controller.action.epl.EplBoardListFormAction;
import com.sh.controller.action.epl.EplBoardUpdateAction;
import com.sh.controller.action.epl.EplBoardUpdateFormAction;
import com.sh.controller.action.epl.EplBoardViewFormAction;
import com.sh.controller.action.epl.EplCommentInsertAction;
import com.sh.controller.action.epl.EplIntroInsertAction;
import com.sh.controller.action.epl.EplIntroInsertFormAction;
import com.sh.controller.action.epl.EplIntroUpdateAction;
import com.sh.controller.action.epl.EplIntroUpdateFormAction;
import com.sh.controller.action.epl.EplIntroViewFormAction;


public class EplActionFactory {
	
	public static EplActionFactory instance = new EplActionFactory();
	
	private EplActionFactory() {
		super();
	}
	
	public static EplActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("EplActionFactory : " + command);
		
		if (command.equals("main")) {
			
			action = new MainAction();
			
		}  else if (command.equals("eplInsertFormAction")) {
			
			action = new EplIntroInsertFormAction();
			
		} else if (command.equals("eplIntroInsertAction")) {
			
			action = new EplIntroInsertAction();
					
		} else if (command.equals("eplIntroListFormAction")) {
			
			action = new EplIntroViewFormAction();
			
		} else if (command.equals("eplIntroUpdateFormAction")) {
			
			action = new EplIntroUpdateFormAction();
			
		} else if (command.equals("eplIntroUpdateAction")) {
			
			action = new EplIntroUpdateAction();
			
		} else if (command.equals("eplBoardListFormAciton")) {
			
			action = new EplBoardListFormAction();
			
		} else if (command.equals("eplBoardInsertFormAction")) {
			
			action = new EplBoardInsertFormAction();
			
		} else if (command.equals("eplBoardInsertAction")) {
			
			action = new EplBoardInsertAction();
			
		} else if (command.equals("eplBoardViewFormAction")) {
			
			action = new EplBoardViewFormAction();
					
		} else if (command.equals("eplBoardUpdateFormAction")) {
			
			action = new EplBoardUpdateFormAction();
			
		} else if (command.equals("eplBoardUpdateAction")) {
			
			action = new EplBoardUpdateAction();
			
		} else if (command.equals("eplBoardDeleteAction")) {
			
			action = new EplBoardDeleteAction();
			
		} else if (command.equals("eplCommentInsertAction")) {
			
			action = new EplCommentInsertAction();
			
		} 
			return action;
		}
}

