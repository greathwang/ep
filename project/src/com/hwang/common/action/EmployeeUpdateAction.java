package com.hwang.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hwang.employee.dao.CareearDao;
import com.hwang.employee.dto.CareearDto;

public class EmployeeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CareearDao cDao = CareearDao.getInstance();
		CareearDto cDto = new CareearDto();
		
		cDto.setCompany(request.getParameter("company"));
		cDto.setDeptnum(request.getParameter("dupt_num"));
		cDto.setEmpnum(request.getParameter("empnum"));
		cDto.setEnddt(request.getParameter("enddt"));
		cDto.setPnum(request.getParameter("pnum"));
		cDto.setStartdt(request.getParameter("startdt"));
		
		cDao.insertCareear(cDto);
		
		List<CareearDto> careearList = 
					cDao.selectCareearList(request.getParameter("empnum"));
		
		String json = null;
		if(careearList != null){
			json = new Gson().toJson(careearList);
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);
	}

}
