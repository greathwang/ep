<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty empid}">
	<jsp:forward page="../EmployeeServlet"/>
</c:if>
<!DOCTYPE html>

	<div id=header>
		<div class="top">
			<p align="right">
				${first_name }${last_name }
				님 안녕하세요
				<a href="EmployeeServlet?command=logout">로그아웃</a>
			</p>
			<p></p>
		</div>
		
		<div class="bottom">
		<h1>닭대가리</h1>
		</div>
	</div>
