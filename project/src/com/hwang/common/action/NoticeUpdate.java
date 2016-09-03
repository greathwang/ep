package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.NoticeDao;
import com.hwang.employee.dto.NoticeDto;

public class NoticeUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "EmployeeServlet?command=notice_list";
		int result = -1;
		
		NoticeDto nDto = new NoticeDto();
		
		nDto.setTitle(request.getParameter("title"));
		nDto.setContent(request.getParameter("content"));
		nDto.setNoticenum(request.getParameter("noticenum"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		result = nDao.NoticeUpdate(nDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
