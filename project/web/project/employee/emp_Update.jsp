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
<script type="text/javascript" src="js/tabs.js"></script>
<script type="text/javascript">
$(function(){
	$("#tabs").tabs();
});
</script>
<style type="text/css">
	.emp_img{
		height:100px; 
		width: 100px;
		margin-top: 7px;
		margin-bottom: 7px;
	}
	


#tabs{
	margin-left: 40px;
	margin-bottom: 30px;
	width: 700px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main_auto">
		<div id="main">
			<div class="top">
			<h2>사원 정보 수정</h2>
			</div>
			<hr><br>
			<form action="EmployeeServlet?command=emp_update" method="post">
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
					<th>성</th>
					<td>${employee.first_name }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" value="${employee.last_name }"> </td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>${employee.reginum }</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${employee.gender }</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${employee.birth }</td>
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
					<th>등록일</th>
					<td>${employee.regidate }</td>
				</tr>
				<tr>
					<td id="btn" colspan="4">
						<input type="submit" value="수정">
						<input type="button" value="취소" onclick="location.href='EmployeeServlet?command=emp_detail&empnum=${employee.empnum}'">
						<input type="button" value="목록" onclick="location.href='EmployeeServlet?command=emp_list'">
					</td>
				</tr>
			</table>
			</form>
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">경력</a></li>
					<li><a href="#tabs-2">학력</a></li>
					<li><a href="#tabs-3">자격증</a></li>
				</ul>
				<div id="tabs-1">
					<button id="add_careear_btn">경력 추가</button>
					<table id="careearTable">
						<tr>
							<th>근무회사</th>
							<th>부서</th>
							<th>직급</th>
							<th>입사일</th>
							<th>퇴사일</th>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div id="tabs-2">
					<p>학력</p>
				</div>
				<div id="tabs-3">
					<p>자격증</p>
				</div>
			</div>
			
			<div id="careear_form" title="경력 추가">
				<input type="hidden" id="empnum" value="${employee.empnum }">
				<p><span>회사</span><input type="text" id="company"></p>
				<p>
					<span>부서</span>
					<select class="input1" id="dupt_num" name="dupt_num">
						<option value="00">영업부</option>
						<option value="01">관리부</option>
						<option value="02">생산부</option>
						<option value="03">품질관리부</option>
						<option value="04">인사</option>
						<option value="05">개발</option>
					</select> 
				</p>
				<p>
					<span>직급</span>
					<select class="input1" id="pnum" name="pnum">
						<option value="00">사원</option>
						<option value="01">대리</option>
						<option value="02">과장</option>
						<option value="03">차장</option>
						<option value="04">부장</option>
						<option value="05">사장</option>
					</select>
				</p>
				<p>
					<span>입사일</span><input class ="input1" type="text" name="startdt" id="startdt" readonly="readonly">
				</p>
				<p>
					<span>퇴사일</span><input class ="input1" type="text" name="enddt" id="enddt" readonly="readonly">
				</p>
			</div>
						
		</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>