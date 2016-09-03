//package com.hwang.common.action;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.hwang.employee.dao.EmployeeDao;
//import com.hwang.employee.dto.EmployeeDto;
//
//public class LoginAction implements Action {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "EmployeeServlet?command=loginForm";
//		int result=0;
//		String empid = request.getParameter("empid");
//		String pwd = request.getParameter("pwd");
//		EmployeeDto eDto = null;
//		HttpSession session = null;
//		
//		EmployeeDao eDao = EmployeeDao.getInstance();
//		result = eDao.userCheck(empid, pwd);
//		if(result==1){
//			session = request.getSession();
//			
//			url="EmployeeServlet?command=home";
//			
//			eDto = eDao.sessionEmp(empid);
//			
//			session.setAttribute("empid", empid);
//			session.setAttribute("first_name", eDto.getFirst_name());
//			session.setAttribute("last_name", eDto.getLast_name());
//			session.setAttribute("emp", eDto);
//		}
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//	}
//}
