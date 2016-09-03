package com.hwang.common.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date d = new Date();
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(d);
		
		request.setAttribute("dayTime", str);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/project/employee/emp_Insert.jsp");
		dispatcher.forward(request, response);
	}

}
