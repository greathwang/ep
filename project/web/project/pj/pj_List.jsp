<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
			<h2>프로젝트 이력 목록</h2>
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
						<td>프로젝트명</td>
						<td><input type="text"></td>
						<td colspan="3" align="right"><input type="submit" value="조회" id="inp"></td>
					</tr>
				</table>
				<br><hr><br>
				<table id="notice">
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>글제목</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="pj" items="${pjlist }">
				<tr>
					<td>${pj.pjtcd }</td>
					<td>${pj.reguser }</td>
					<td><a href="EmployeeServlet?command=pj_detail&pjtcd=${pj.pjtcd }">${pj.pjt }</a></td>
					<td>${pj.regdt }</td>
				</tr>
				</c:forEach>
			</table>
				<nav align="center">
				<c:forEach var="i" begin="${pDto.getFirstPage() }" varStatus="num" end="${pDto.getLastPage() }">
						<a href="EmployeeServlet?command=pj_list&curPage=${i }">${num.count }
						</a>
				</c:forEach>
				</nav>
			</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>