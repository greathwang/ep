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
<link rel="stylesheet" type="text/css" href="css/Layout_style.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript" src="js/navi.js"></script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
			<h2>프로젝트 이력 상세</h2>
			</div>
			<hr><br>
			<form action="">
			<table id="notice">
				<tr>
					<th>사번</th>
					<td></td>
				</tr>
				<tr>
					<th>ID</th>
					<td></td>
				</tr>
				<tr>
					<th>프로젝트명</th>
					<td>${pj.pjt }</td>
				</tr>
				<tr>
					<th>기간</th>
					<td>${startdt }~${enddt }</td>
				</tr>
				<tr>
					<th>사용스킬</th>
					<td>자바자바자바잡자바자바</td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td>${pj.pjtdtl }</td>
				</tr>
				<tr>
					<th>수행역할</th>
					<td>PM</td>
				</tr>
				<tr>
					<td id="btn" colspan="2">
						<input type="submit" value="목록">
						<input type="button" value="수정">
						<input type="button" value="삭제">
					</td>
				</tr>
			</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>