package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.EmployeeDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "EmployeeServlet?command=loginForm";
		int result=0;
		String empid = request.getParameter("empid");
		String pwd = request.getParameter("pwd");
		EmployeeDto emp = null;
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		result = eDao.userCheck(empid, pwd);
		
		HttpSession session = request.getSession();
		
		emp = eDao.sessionEmp(empid);
		
		if(result==1){
			url="EmployeeServlet?command=home";
			
			session.setAttribute("empid", empid);
			session.setAttribute("first_name", emp.getFirst_name());
			session.setAttribute("last_name", emp.getLast_name());
			session.setAttribute("enum", emp.getEmpnum());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
