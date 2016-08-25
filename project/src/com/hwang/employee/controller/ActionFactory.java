package com.hwang.employee.controller;

import com.hwang.common.action.Action;
import com.hwang.common.action.EmpDetailAction;
import com.hwang.common.action.EmpInsertFormAction;
import com.hwang.common.action.EmpListAction;
import com.hwang.common.action.EmpUpdateAction;
import com.hwang.common.action.HomeAction;
import com.hwang.common.action.LoginAction;
import com.hwang.common.action.LoginFormAction;
import com.hwang.common.action.LogoutAction;
import com.hwang.common.action.NoticeListAction;
import com.hwang.common.action.ProjectListAction;
import com.hwang.common.action.ProjectListDetailAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		System.out.println("ActionFactory :"+command);
		
		if(command.equals("loginForm")){
			action = new LoginFormAction();
		}else if(command.equals("login")){
			action = new LoginAction();
		}else if(command.equals("home")){
			action = new HomeAction();
		}else if(command.equals("emp_list")){
			action = new EmpListAction();
		}else if(command.equals("emp_detail")){
			action = new EmpDetailAction();
		}else if(command.equals("emp_update")){
			action = new EmpUpdateAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}else if(command.equals("notice_list")){
			action = new NoticeListAction();
		}else if(command.equals("pj_list")){
			action = new ProjectListAction();
		}else if(command.equals("pj_detail")){
			action = new ProjectListDetailAction();
		}else if(command.equals("emp_insert_form")){
			action = new EmpInsertFormAction();
		}
		return action;
	}
}
