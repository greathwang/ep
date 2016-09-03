package com.hwang.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hwang.employee.dao.AddressDao;
import com.hwang.employee.dto.AddressDto;

public class AddrSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong = request.getParameter("addrtext");

		
		AddressDao aDao = AddressDao.getInstance();
		List<AddressDto> addrList = aDao.selectAllAddress(dong);
		
		String json = null;
		if(addrList != null){
			json = new Gson().toJson(addrList);
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);
	}
}
