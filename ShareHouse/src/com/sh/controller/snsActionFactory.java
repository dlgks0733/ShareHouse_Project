package com.sh.controller;

import com.sh.controller.action.Action;
import com.sh.controller.action.MainAction;
import com.sh.controller.action.member.InsertMemberAction;
import com.sh.controller.action.member.JoinFormAction;
import com.sh.controller.action.member.MemberIdCheckAction;
import com.sh.controller.action.sns.snsBoardDeleteAction;
import com.sh.controller.action.sns.snsBoardInsertAction;
import com.sh.controller.action.sns.snsBoardInsertFormAction;
import com.sh.controller.action.sns.snsBoardListFormAction;
import com.sh.controller.action.sns.snsBoardUpdateAction;
import com.sh.controller.action.sns.snsBoardUpdateFormAction;
import com.sh.controller.action.sns.snsBoardViewFormAction;
import com.sh.controller.action.sns.snsCommentCountAction;
import com.sh.controller.action.sns.snsCommentInsertAction;
import com.sh.controller.action.sns.snsCommentListAction;
import com.sh.controller.action.sns.snsGalBoardInsertFormAction;
import com.sh.controller.action.sns.snsGalBoardListFormAction;

public class snsActionFactory {
	private static snsActionFactory instance = new snsActionFactory();

	private snsActionFactory() {
		super();
	}

	public static snsActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("snsActionFactory : " + command);

		if (command.equals("main")) {

			action = new MainAction();
		}
		
		else if (command.equals("snsBoardListFormAciton")) {

			action = new snsBoardListFormAction();

		} else if (command.equals("joinFormAction")) {

			action = new JoinFormAction();

		} else if (command.equals("insertMemberAction")) {

			action = new InsertMemberAction();

		} else if (command.equals("memberIdCheck")) {

			action = new MemberIdCheckAction();

		} else if (command.equals("snsInsertFormAction")) {

			action = new snsBoardInsertFormAction();

		} else if (command.equals("snsBoardInsertAction")) {

			action = new snsBoardInsertAction();

		} else if (command.equals("snsBoardViewFormAction")) {

			action = new snsBoardViewFormAction();
		} else if (command.equals("snsBoardUpdateFormAction")) {

			action = new snsBoardUpdateFormAction();
			
		} else if (command.equals("snsBoardUpdateAction")) {
			
			action = new snsBoardUpdateAction();
			
		} else if (command.equals("snsBoardDeleteAction")) {
			
			action = new snsBoardDeleteAction();
			
		} else if (command.equals("snsGalBoardListFormAction")) {
			
			action = new snsGalBoardListFormAction();
			
		} else if (command.equals("snsGalBoardInsertFormAction")) {
			
			action = new snsGalBoardInsertFormAction();
			
		} else if (command.equals("snsCommentInsertAction")) {
			
			action = new snsCommentInsertAction();
			
		} else if (command.equals("snsCommentCountAction")) {
			
			action = new snsCommentCountAction();
			
		} else if (command.equals("snsCommentListAction")) {
			
			action = new snsCommentListAction();
			
		}

		return action;

	}
}
