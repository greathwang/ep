package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwang.employee.dao.NoticeDao;
import com.hwang.employee.dto.NoticeDto;

public class NoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "EmployeeServlet?command=notice_list";
		int result = -1;
		
		NoticeDto nDto = new NoticeDto();
		HttpSession session = request.getSession();

		nDto.setEmpid((String)session.getAttribute("empid"));
		nDto.setTitle(request.getParameter("title"));
		nDto.setContent(request.getParameter("content"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		result = nDao.insertNotice(nDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
