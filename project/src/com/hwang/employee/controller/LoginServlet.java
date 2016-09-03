package com.hwang.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.EmployeeDto;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/loginForm.jsp";
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/loginForm.jsp";
		int result=0;
		String empid = request.getParameter("empid");
		String pwd = request.getParameter("pwd");
		EmployeeDto emp = null;
		HttpSession session = null;
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		result = eDao.userCheck(empid, pwd);
		
		if(result==1){
			session = request.getSession();
			url="EmployeeServlet?command=home";
			
			emp = eDao.sessionEmp(empid);
			
			session.setAttribute("empid", empid);
			session.setAttribute("first_name", emp.getFirst_name());
			session.setAttribute("last_name", emp.getLast_name());
			session.setAttribute("empnum", emp.getEmpnum());
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
