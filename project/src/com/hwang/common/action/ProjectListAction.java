package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.ProjectDao;
import com.hwang.employee.dto.ProjectDto;

public class ProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/pj/pj_List.jsp";
		
		ProjectDao pDao = ProjectDao.getInstance();
		List<ProjectDto> pjlist = pDao.selectAllprojects();
		
		request.setAttribute("pjlist", pjlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
