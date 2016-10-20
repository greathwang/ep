package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.NoticeDao;
import com.hwang.employee.dao.ReplyDao;
import com.hwang.employee.dto.NoticeDto;
import com.hwang.employee.dto.ReplyDto;

public class NoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="project/notice_Detail.jsp";
		
		String noticenum = request.getParameter("noticenum");
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		nDao.updateHit(noticenum);
		
		ReplyDao rDao = ReplyDao.getInstance();
		
		List<ReplyDto> replyList = rDao.selectAllReply(noticenum);
		
		NoticeDto nDto = nDao.selectOneNoticeByNoticeNum(noticenum);
		
		request.setAttribute("notice", nDto);
		request.setAttribute("replyList", replyList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
