package com.sh.controller;

import com.sh.controller.action.Action;
import com.sh.controller.action.MainAction;
import com.sh.controller.action.member.InsertMemberAction;
import com.sh.controller.action.member.JoinFormAction;
import com.sh.controller.action.member.MemberIdCheckAction;
import com.sh.controller.action.mlb.MlbBoardListFormAction;
import com.sh.controller.action.mlb.MlbBoardUpdateAction;
import com.sh.controller.action.mlb.MlbBoardUpdateFormAction;
import com.sh.controller.action.mlb.MlbBoardViewFormAction;
import com.sh.controller.action.mlb.MlbGalBoardDeleteAction;
import com.sh.controller.action.mlb.MlbGalBoardInsertFormAction;
import com.sh.controller.action.mlb.MlbGalBoardListFormAction;
import com.sh.controller.action.mlb.MlbGalBoardUpdateFormAction;
import com.sh.controller.action.mlb.MlbGalBoardViewFormAction;
import com.sh.controller.action.mlb.MlbBoardDeleteAction;
import com.sh.controller.action.mlb.MlbBoardInsertAction;
import com.sh.controller.action.mlb.MlbBoardInsertFormAction;

/**
 * request로 받아온 매개변수의 command의 값으로 각 기능을 수행할 액션을 분기하는 클래스 <br>
 * action추가 시 최대한 기능별로 정렬될 수 있도록 한다. 수정이 잦은 class이므로 주의하여 편집!!
 * 
 * @author cho
 *
 */

public class MlbActionFactory {
	private static MlbActionFactory instance = new MlbActionFactory();

	private MlbActionFactory() {
		super();
	}

	public static MlbActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("MlbActionFactory : " + command);

		if (command.equals("main")) {

			action = new MainAction();
		}
		/**
		 * @author LeeHan
		 * 
		 */
		else if (command.equals("mlbBoardListFormAciton")) {

			action = new MlbBoardListFormAction();

		} else if (command.equals("joinFormAction")) {

			action = new JoinFormAction();

		} else if (command.equals("insertMemberAction")) {

			action = new InsertMemberAction();

		} else if (command.equals("memberIdCheck")) {

			action = new MemberIdCheckAction();

		} else if (command.equals("mlbInsertFormAction")) {

			action = new MlbBoardInsertFormAction();

		} else if (command.equals("mlbBoardInsertAction")) {

			action = new MlbBoardInsertAction();

		} else if (command.equals("mlbBoardViewFormAction")) {

			action = new MlbBoardViewFormAction();
		} else if (command.equals("mlbBoardUpdateFormAction")) {

			action = new MlbBoardUpdateFormAction();
			
		} else if (command.equals("mlbBoardUpdateAction")) {
			
			action = new MlbBoardUpdateAction();
			
		} else if (command.equals("mlbBoardDeleteAction")) {
			
			action = new MlbBoardDeleteAction();
			
		} else if (command.equals("mlbGalBoardListFormAction")) {
			
			action = new MlbGalBoardListFormAction();
			
		} else if (command.equals("mlbGalBoardInsertFormAction")) {
			
			action = new MlbGalBoardInsertFormAction();
			
		} else if (command.equals("mlbGalBoardViewFormAction")) {
			
			action = new MlbGalBoardViewFormAction();
			
		} else if (command.equals("mlbGalBoardUpdateFormAction")) {
			
			action = new MlbGalBoardUpdateFormAction();
			
		} else if (command.equals("mlbGalBoardDeleteAction")) {
			
			action = new MlbGalBoardDeleteAction();
			
		}

		return action;

	}
}
