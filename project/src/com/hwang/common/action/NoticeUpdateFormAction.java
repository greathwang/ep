package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.NoticeDao;
import com.hwang.employee.dto.NoticeDto;

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/notice_Update.jsp";
		String noticenum = request.getParameter("noticenum");

		NoticeDto nDto = new NoticeDto();
		NoticeDao nDao = NoticeDao.getInstance();
		
		nDto = nDao.selectOneNoticeByNoticeNum(noticenum);
		
		request.setAttribute("notice", nDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
