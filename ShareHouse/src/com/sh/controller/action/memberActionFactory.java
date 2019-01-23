package com.sh.controller.action;

import com.sh.controller.action.member.LoginFormAction;
import com.sh.controller.action.member.LogoutFormAction;


public class memberActionFactory {
	private static memberActionFactory instance = new memberActionFactory();
	

	public static memberActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;

		System.out.println("memberActionFactory : " + command);

		if (command.equals("main")) {

			action = new MainAction();
			
		} else if (command.equals("LogoutFormAction")) {

			action = new LogoutFormAction();
		} else if (command.equals("LoginFormAction")) {

			action = new LoginFormAction();
		}
		return action;
	}



}
	