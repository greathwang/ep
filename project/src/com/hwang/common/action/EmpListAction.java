package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.EmployeeDto;

public class EmpListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/employee/emp_List.jsp";
		
		EmployeeDao mDao = EmployeeDao.getInstance();
		List<EmployeeDto> emplist = mDao.selectAllEmployees();
		request.setAttribute("emplist", emplist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
