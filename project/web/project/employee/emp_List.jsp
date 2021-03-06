<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<h2>사원정보 목록</h2>
			</div>
			<br>
			<div>
			<form action="">
				<table id="notice">
					<tr>
						<td>ID</td>
						<td><input type="text" size=""></td>
						<td>등록일</td>
						<td><input type="text">~<input type="text"></td>
					</tr>
					<tr>
						<td>사원명</td>
						<td><input type="text"></td>
						<td colspan="5" align="right"><input type="submit" value="조회" id="inp"></td>
					</tr>
				</table>
				<br><hr><br>
				<table id="notice">
				<tr>
					<th>사번</th>
					<th>사원명</th>
					<th>직급</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="emp" items="${emplist }">
				<tr>
					<td>${emp.empnum }</td>
					<td><a href="EmployeeServlet?command=emp_detail&empnum=${emp.empnum }">${emp.first_name }${emp.last_name }</a></td>
					<td>${emp.pnum }</td>
					<td>${emp.regidate }</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	</body>
</html>
