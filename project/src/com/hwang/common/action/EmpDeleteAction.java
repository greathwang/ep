package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.EmployeeDao;

public class EmpDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="EmployeeServlet?command=emp_list";
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		
		int result = eDao.EmployeeDelete(request.getParameter("empnum"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
