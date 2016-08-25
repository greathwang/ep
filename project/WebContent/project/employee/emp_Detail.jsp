<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty empid}">
	<jsp:forward page="../EmployeeServlet"/>
</c:if>
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

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
			<h2>사원 정보 상세</h2>
			</div>
			<hr><br>
			<table id="notice">
				<tr>
					<td rowspan="16">dd</td>
				</tr>
				<tr>
					<td></td>					
					<th>사번</th>
					<td>${employee.empnum }</td>
				</tr>
				<tr>
					<td></td>
					<th>이름</th>
					<td>${employee.first_name }${employee.last_name }</td>
				</tr>
				<tr>
					<td></td>
					<th>주민번호</th>
					<td>${employee.reginum }</td>
				</tr>
				<tr>
					<td></td>
					<th>성별</th>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>생년월일</th>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>부서</th>
					<td>${employee.deptnum }</td>
				</tr>
				<tr>
					<td></td>
					<th>직급</th>
					<td>${employee.pnum }</td>
				</tr>
				<tr>
					<td></td>
					<th>입사일</th>
					<td>${employee.hire_date }</td>
				</tr>
				<tr>
					<td></td>
					<th>퇴사일</th>
					<td>${employee.out_date }</td>
				</tr>
				<tr>
					<td></td>
					<th>우편번호</th>
					<td>${employee.zipcode }</td>
				</tr>
				<tr>
					<td></td>
					<th>주소</th>
					<td>${employee.address }</td>
				</tr>
				<tr>
					<td></td>
					<th>상세주소</th>
					<td>${employee.detailaddress }</td>
				</tr>
				<tr>
					<td></td>
					<th>급여</th>
					<td>${employee.salary }</td>
				</tr>
				<tr>
					<td></td>
					<th>비고</th>
					<td>JAVA,jsp</td>
				</tr>
				<tr>
					<td></td>
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
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>