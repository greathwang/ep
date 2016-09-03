<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<style type="text/css">
textarea{
	margin-top:5px;
	resize:none;
	overflow-y: scroll;
}


</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
				<h2>공지사항 수정</h2>
			</div>
			<form action="EmployeeServlet?command=notice_update" method="post">
			<table class="notdetail">
				<tr>
					<th>제목</th>
					<td colspan="5">
						<input class="title_inp" type="text" name="title" value="${notice.title }"> 
						<input type="hidden" name="noticenum" value="${notice.noticenum }">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${notice.empid }(관리자)</td>
					<th>작성일</th>
					<td>${notice.writedate }</td>
					<th>조회수</th>
					<td>${notice.hit }</td>
				</tr>
				<tr>
					<td colspan="6" >
						<textarea rows="20" cols="100" name="content">${notice.content }</textarea>
					</td>
				</tr>
				<tr>
					<td class="not_btn" colspan="6">
						<input type="submit" value="수정">
						<input type="button" value="취소" onclick="location.href='EmployeeServlet?command=notice_detail&noticenum=${notice.noticenum}'">
					</td>
				</tr>
			</table>
			</form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>