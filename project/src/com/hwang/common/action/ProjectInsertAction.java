package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwang.employee.dao.ProjectDao;
import com.hwang.employee.dto.ProjectDto;

public class ProjectInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "EmployeeServlet?command=pj_list";

		HttpSession session = request.getSession();
		ProjectDto pDto = new ProjectDto();
		
		int result = -1;
		
		pDto.setEmpnum((String)session.getAttribute("empnum"));
		pDto.setEnddt(request.getParameter("enddt"));
		pDto.setPerrolecd(request.getParameter("perrole"));
		pDto.setPjt(request.getParameter("pjt"));
		pDto.setPjtdtl(request.getParameter("pjtdtl"));
		pDto.setReguser((String)session.getAttribute("empid"));
		pDto.setStartdt(request.getParameter("startdt"));
		pDto.setPerrolecd(request.getParameter("perrole"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		result = pDao.projectInsert(pDto);
		
		result = pDao.projectMgInsert(pDto);
		
		result = pDao.projectSkillInsert(pDto);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
