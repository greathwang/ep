package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.NoticeDao;

public class NoticeDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "EmployeeServlet?command=notice_list";
		String noticenum = request.getParameter("noticenum");
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.NoticeDelete(noticenum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
