<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/Layout_style.css">
<style type="text/css">
textarea{
	resize:none;
	overflow-y: scroll;
}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<h2>프로젝트 이력 수정</h2>
			<form action="">
			<table id="notice">
				<tr>
					<th>사번</th>
					<td><input type="text" disabled="disabled"> </td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" disabled="disabled"> </td>
				</tr>
				<tr>
					<th>프로젝트명</th>
					<td><input type="text"> </td>
				</tr>
				<tr>
					<th>기간</th>
					<td><input type="date">~ <input type="date"></td>
				</tr>
				<tr>
					<th>사용스킬</th>
					<td><textarea rows="7" cols="50"></textarea> </td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td><textarea rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<th>수행역할</th>
					<td><input type="text"> </td>
				</tr>
				<tr>
					<td id="btn" colspan="2" align="center">
						<input type="submit" value="수정">
						<input type="button" value="취소">
					</td>
				</tr>
			</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>