<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
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
	.emp_img{
		height:100px; 
		width: 100px;
		margin-top: 7px;
		margin-bottom: 7px;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
			<h2>사원 정보 수정</h2>
			</div>
			<hr><br>
			<form action="EmployeeServlet?command=emp_list" method="post">
			<table id="notice">
				<tr>
					<th>사번</th>
					<td>${employee.empnum } </td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${employee.empid }</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><img class="emp_img" src="upload/${employee.emp_img}" ></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" value="${employee.first_name }${employee.last_name }"></td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>${employee.reginum }</td>
				</tr>
				<tr>
					<th>성별</th>
					<td></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td></td>
				</tr>
				<tr>
					<th>부서</th>
					<td>${employee.deptnum }</td>
				</tr>
				<tr>
					<th>직급</th>
					<td>${employee.pnum }</td>
				</tr>
				<tr>
					<th>입사일</th>
					<td>${employee.hire_date }</td>
				</tr>
				<tr>
					<th>퇴사일</th>
					<td><input class ="input1" type="text" name="out_date" id="datepicker2" value="${employee.out_date }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>${employee.zipcode }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${employee.address }</td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>${employee.detailaddress }</td>
				</tr>
				<tr>
					<th>급여</th>
					<td>${employee.salary }</td>
				</tr>
				<tr>
					<th>비고</th>
					<td>JAVA,jsp</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${employee.regidate }</td>
				</tr>
				<tr>
					<td id="btn" colspan="4">
						<input type="submit" value="목록">
						<input type="button" value="수정">
					</td>
				</tr>
			</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>