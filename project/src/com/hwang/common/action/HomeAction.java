package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.controller.PageController;
import com.hwang.employee.dao.NoticeDao;
import com.hwang.employee.dao.PageDao;
import com.hwang.employee.dto.NoticeDto;

public class HomeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/home.jsp";
		
		NoticeDao nDao = NoticeDao.getInstance();
//		List<NoticeDto> noticelist = nDao.selectAllNotice();
		
		int curPage=0;
		if(request.getParameter("curPage")!=null){
		 curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		List<NoticeDto> noticelist = nDao.selectNoticePage(curPage, 5);
		
		request.setAttribute("noticelist", noticelist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
