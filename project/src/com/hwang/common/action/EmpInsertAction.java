package com.hwang.common.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwang.employee.dao.EmployeeDao;
import com.hwang.employee.dto.EmployeeDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EmpInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = 
				new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		
		EmployeeDto eDto = new EmployeeDto(); 
		
		
		eDto.setEmpid(multi.getParameter("empid"));
		eDto.setPwd(multi.getParameter("pwd"));
		eDto.setFirst_name(multi.getParameter("first_nm"));
		eDto.setLast_name(multi.getParameter("last_nm"));
		eDto.setEmail(multi.getParameter("first_email")+"@"+multi.getParameter("last_email"));
		eDto.setReginum(multi.getParameter("first_reginum")+multi.getParameter("last_reginum"));
		eDto.setPhone(multi.getParameter("fir_phone")+multi.getParameter("mid_phone")+multi.getParameter("las_phone"));
		eDto.setZipcode(multi.getParameter("zipcode"));
		eDto.setAddress(multi.getParameter("address"));
		eDto.setDetailaddress(multi.getParameter("detail_address"));
		
		eDto.setEmp_img(multi.getFilesystemName("emp_imgpath"));
		eDto.setEmp_img_org(multi.getOriginalFileName("emp_imgpath"));
		
		eDto.setDeptnum(multi.getParameter("dept_num"));
		eDto.setPnum(multi.getParameter("pnum"));
		eDto.setSalary(Integer.parseInt(multi.getParameter("salary")));
		eDto.setManager(Integer.parseInt(multi.getParameter("manager")));
		
		EmployeeDao eDao = EmployeeDao.getInstance();
		int result = eDao.insertEmployee(eDto);
		
		
		new EmpListAction().execute(request, response);
	}

}