<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty empid}">
	<jsp:forward page="../EmployeeServlet"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/Layout_style.css">
</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="navi.jsp"></jsp:include>
		<div id="main">
			<h2>공지사항</h2>
			<table id="notice">
				<tr>
					<th>제목</th>
					<td colspan="5" align="center">공지사항입니다</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>관리자</td>
					<th>작성일</th>
					<td>2014-51-51</td>
					<th>조회수</th>
					<td>0</td>
				</tr>
				<tr>
					<td colspan="6" align="right"><button>목록</button></td>
				<tr>
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>