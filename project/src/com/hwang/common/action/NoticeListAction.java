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
import com.hwang.employee.dto.PageDto;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/notice.jsp";
		
		int curPage=0;
		if(request.getParameter("curPage")!=null){
		 curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		PageDao pageDao = PageDao.getInstance();
		int totalRecord = pageDao.selectTotalRecord("notice");
		
		PageDto pDto = new PageDto();
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		PageController pCon = new PageController();
		
		pDto = pCon.PageControll(totalRecord, 7, 5, curPage);
		
		List<NoticeDto> noticelist =nDao.selectNoticePage(curPage, 7);
		
//		List<NoticeDto> noticelist = nDao.selectAllNotice();
		
		request.setAttribute("noticelist", noticelist);
		request.setAttribute("pDto", pDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
