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
<script type="text/javascript" src="js/address.js"></script>
<script type="text/javascript" src="js/common.js"></script>
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
			<div class="top">
				<h2>프로젝트 등록</h2>
			</div>
			<form action="">
			<table id="notice">
				<tr>
					<th>사번</th>
					<td><input type="text" disabled="disabled" value="${emp.empnum }"> </td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" disabled="disabled" value="${empid }"> </td>
				</tr>
				<tr>
					<th>프로젝트명</th>
					<td><input type="text"> </td>
				</tr>
				<tr>
					<th>기간</th>
					<td>
						<input class ="input1" type="text" name="startdt" id="datepicker1" value="${dayTime }" readonly="readonly">
						~ 
						<input class ="input1" type="text" name="enddt" id="datepicker2" value="${dayTime }" readonly="readonly">
				</tr>
				<tr>
					<th>사용스킬</th>
					<td><textarea rows="10" cols="50"></textarea> </td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td><textarea rows="15" cols="50"></textarea></td>
				</tr>
				<tr>
					<th>수행역할</th>
					<td><input type="text"> </td>
				</tr>
				<tr>
					<td id="btn" colspan="2" align="center">
						<input type="submit" value="등록">
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