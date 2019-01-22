package com.sh.controller;

import com.sh.controller.action.Action;
import com.sh.controller.action.MainAction;
import com.sh.controller.action.epl.IntroductionFormAction;

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
			
		} else if (command.equals("introductionFormAction")) {
			
			action = new IntroductionFormAction();	
			
		}
			
			return action;
		}
}

