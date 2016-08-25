package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.EmployeeDto;

public class EmpDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/employee/emp_Detail.jsp";
		
		String empnum = request.getParameter("empnum");
		
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		
		EmployeeDto eDto = eDao.selectOneEmpoyeeByNum(empnum);
		request.setAttribute("employee", eDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
