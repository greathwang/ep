<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty empid}">
	<jsp:forward page="../EmployeeServlet"/>
</c:if>

<div id="navi" >
	<div id="accordion" class="stv_list">
		<h3>Home</h3>
		<div>
			<p>
				<a href="EmployeeServlet?command=home">홈으로</a>
			</p>
		</div>
		<h3>개인 프로젝트 이력관리</h3>
		<div>
			<p>
			<ul>
				<li><a href="EmployeeServlet?command=pj_list"> 프로젝트 이력 목록</a></li>
				<li><a href="pj_Regi.jsp"> 프로젝트 이력 등록</a></li>
			</ul>
		</div>
		<h3>개인 정보 관리</h3>
		<div>
			<p>
			<ul>
				<li><a href="EmployeeServlet?command=emp_list"> 사원 정보 목록</a></li>
				<li><a href="EmployeeServlet?command=emp_update"> 사원 정보 수정</a></li>
				<li><a href="EmployeeServlet?command=emp_insert_form"> 사원 정보 등록</a></li>
				
			</ul>
		</div>
		<h3>공지사항</h3>
		<div>
			<ul>
				<li><a href="EmployeeServlet?command=notice_list"> 공지사항 목록</a></li>
				<li><a href=""> 공지사항 등록</a></li>
			</ul>
		</div>
	</div>
</div>