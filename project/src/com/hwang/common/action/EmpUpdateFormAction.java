package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.CareearDao;
import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.CareearDto;
import com.hwang.employee.dto.EmployeeDto;

public class EmpUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/employee/emp_Update.jsp";
		
		String empnum = request.getParameter("empnum");
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		
		EmployeeDto eDto = eDao.selectOneEmpoyeeByNum(empnum);
		
		CareearDao cDao = CareearDao.getInstance();
		
		List<CareearDto> cDto = cDao.selectCareearList(empnum);
		
		request.setAttribute("employee", eDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
