package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.controller.PageController;
import com.hwang.employee.dao.PageDao;
import com.hwang.employee.dao.ProjectDao;
import com.hwang.employee.dto.PageDto;
import com.hwang.employee.dto.ProjectDto;

public class ProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/pj/pj_List.jsp";
		
		int curPage=0;
		if(request.getParameter("curPage")!=null){
		 curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		PageDao pageDao = PageDao.getInstance();
		int totalRecord = pageDao.selectTotalRecord("pjt");
		
		ProjectDao pDao = ProjectDao.getInstance();
		
		PageDto pDto = new PageDto();
		PageController pCon = new PageController();
		pDto = pCon.PageControll(totalRecord, 10, 5, curPage);
		List<ProjectDto> pjlist = pDao.selectProjectPage(curPage, 10);
		
//		List<ProjectDto> pjlist = pDao.selectAllprojects();
		
		request.setAttribute("pjlist", pjlist);
		request.setAttribute("pDto", pDto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
