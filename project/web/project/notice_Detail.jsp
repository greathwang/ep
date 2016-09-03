<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
textarea{
	margin-top:5px;
	resize:none;
	overflow-y: scroll;
}

.cmt{
	margin-top:30px;
}

.cmt table{
	margin-left: 30px;
}

.cmt th{
	text-align: left;
}

#main{
	height: auto;
}

.repmpid{
	width: 60px;
}

.repcontent{
	width: 500px;
}

#reply td{
	border-right: 1px dashed black;
	border-bottom: 1px dotted black; 
}

.replregi{
	margin-top: 10px;
	margin-left: 30px;
}


</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
				<h2>공지사항</h2>
			</div>
			<table class="notdetail">
				<tr>
					<th>제목</th>
					<td colspan="5">${notice.title }</td>
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
						<textarea rows="20" cols="100" readonly="readonly">${notice.content }</textarea>
					</td>
				</tr>
				<tr>
					<td class="not_btn" colspan="6">
						<input type="button" value="목록" onclick="location.href='EmployeeServlet?command=notice_list'">
						<input type="button" value="수정" onclick="location.href='EmployeeServlet?command=notice_update_form&noticenum=${notice.noticenum}'">
						<input type="button" value="삭제" onclick="location.href='EmployeeServlet?command=notice_delete&noticenum=${notice.noticenum}'">
					</td>
				</tr>
			</table>
			
			<div class="cmt">
				<input type="hidden" id="noticenum" value="${notice.noticenum }">
				<input type="hidden" id="empid" value="${notice.empid }">
				<table>
					<thead>
					<tr>
						<th> <h5>댓글</h5></th>
					</tr>
					</thead>
					<tbody  id="reply">
					<c:forEach var="replyList" items="${replyList }">
						<tr class="${replyList.replyno }">
							<td class="repmpid">${replyList.empnum }</td>
							<td class="repcontent">${replyList.content }</td>
							<td>${replyList.writedate }</td>
						</tr>
					</c:forEach>	
					</tbody>
				</table>
				<div class="replregi">
					<p>
						<textarea rows="2" cols="85" id="content" name="content"></textarea>
						<button id="regi-reply" >댓글등록</button>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>