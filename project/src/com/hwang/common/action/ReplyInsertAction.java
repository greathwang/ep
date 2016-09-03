package com.hwang.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hwang.employee.dao.ReplyDao;
import com.hwang.employee.dto.ReplyDto;

public class ReplyInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDao rDao = ReplyDao.getInstance();
		ReplyDto rDto = new ReplyDto();
		
		HttpSession session = request.getSession();
		rDto.setContent(request.getParameter("replyContent"));
		rDto.setEmpnum((String)session.getAttribute("empnum"));
		rDto.setNoticenum(request.getParameter("noticenum"));
		List<ReplyDto> replyList =null;
		replyList = rDao.insertReply(rDto);
		
		/*JsonObject json = new JsonObject();
		*/
		String json =null;
		if(replyList != null){
			json= new Gson().toJson(replyList);
			
			
		/*	json.addProperty("empnum", rDto.getEmpnum());
			json.addProperty("content", rDto.getContent());
			json.addProperty("writedate", rDto.getWritedate());
			json.addProperty("replyno", rDto.getReplyno());
			json.addProperty("empname", (String)session.getAttribute("first_name")+session.getAttribute("last_name"));
		*/}
		
		
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);
	}

}
