package com.hwang.employee.controller;

import com.hwang.common.action.Action;
import com.hwang.common.action.AddrSearchAction;
import com.hwang.common.action.EmpDeleteAction;
import com.hwang.common.action.EmpDetailAction;
import com.hwang.common.action.EmpInsertAction;
import com.hwang.common.action.EmpInsertFormAction;
import com.hwang.common.action.EmpListAction;
import com.hwang.common.action.EmpUpdateFormAction;
import com.hwang.common.action.HomeAction;
//import com.hwang.common.action.LoginAction;
import com.hwang.common.action.LogoutAction;
import com.hwang.common.action.NoticeDelete;
import com.hwang.common.action.NoticeDetailAction;
import com.hwang.common.action.NoticeInsertAction;
import com.hwang.common.action.NoticeInsertFormAction;
import com.hwang.common.action.NoticeListAction;
import com.hwang.common.action.NoticeUpdate;
import com.hwang.common.action.NoticeUpdateFormAction;
import com.hwang.common.action.ProjectInsertForm;
import com.hwang.common.action.ProjectListAction;
import com.hwang.common.action.ProjectListDetailAction;
import com.hwang.common.action.ReplyInsertAction;

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
		
//		if(command.equals("login")){
//			action = new LoginAction();
//		}else 
		if(command.equals("home")){
			action = new HomeAction();
		}else if(command.equals("emp_list")){
			action = new EmpListAction();
		}else if(command.equals("emp_detail")){
			action = new EmpDetailAction();
		}else if(command.equals("emp_update")){
			action = new EmpUpdateFormAction();
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
		}else if(command.equals("emp_insert")){
			action = new EmpInsertAction();
		}else if(command.equals("emp_delete")){
			action = new EmpDeleteAction();
		}else if(command.equals("pj_regi_form")){
			action = new ProjectInsertForm();
		}else if(command.equals("notice_regi_form")){
			action = new NoticeInsertFormAction();
		}else if(command.equals("notice_detail")){
			action = new NoticeDetailAction();
		}else if(command.equals("notice_regi")){
			action = new NoticeInsertAction();
		}else if(command.equals("notice_update_form")){
			action = new NoticeUpdateFormAction();
		}else if(command.equals("notice_update")){
			action = new NoticeUpdate();
		}else if(command.equals("notice_delete")){
			action = new NoticeDelete();
		}else if(command.equals("reply_insert")){
			action = new ReplyInsertAction();
		}else if(command.equals("addr_search")){
			action = new AddrSearchAction();
		}
		return action;
	}
}
