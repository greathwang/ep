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
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="navi.jsp"></jsp:include>
		<div id="main">
			<div class="top"></div>
			<div class="middle"></div>
			<div class="bottom" >
				<table id="notice">
					<tr>
						<th>글번호</th>
						<th>작성자</th>
						<th>글제목</th>
						<th>등록일</th>
						<th>조회수</th>				
					</tr>
						<c:forEach var="notice" items="${noticelist }">
					<tr>
						<td>${notice.noticenum }</td>
						<td>${notice.empid }(관리자)</td>
						<td>
							<a href="EmployeeServlet?command=notice_detail&noticenum=${notice.noticenum }">${notice.title }</a> 
						</td>
						<td>${notice.writedate }</td>
						<td>${notice.hit }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>