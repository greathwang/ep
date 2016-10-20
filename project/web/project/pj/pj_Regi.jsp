
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
#skillArae{
width:100px;
display: inline-block;

}
.skillsArea{
padding-left:10px;
padding: 10px 10px 10px 10px;
text-align: left;
}
#btn{
	text-align:right;
	background-color:white;
	margin: 30px 10px 30px 0px;
}
#btn input {
	width: 100px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main_auto">
			<div class="top">
				<h2>프로젝트 등록</h2>
			</div>
			<form action="EmployeeServlet?command=pj_regi" method="post">
			<table id="notice">
				<tr>
					<th>사번</th>
					<td><input type="text" disabled="disabled" name="empnum"  value="${empnum }"> </td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" disabled="disabled" name="empid" value="${empid }"> </td>
				</tr>
				<tr>
					<th>프로젝트명</th>
					<td><input class ="input6" type="text" name="pjt"> </td>
				</tr>
				<tr>
					<th>기간</th>
					<td>
						<input type="text" name="startdt" id="datepicker1" value="${dayTime }" readonly="readonly">
						~ 
						<input type="text" name="enddt" id="datepicker2"  readonly="readonly">
				</tr>
				<tr align="left">
					<th>사용스킬</th>
					<td align="left">
					<div class="skillsArea">
					<span id="skillArae"><input type="checkbox" name="skill" value="01">JavasScript</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="02">JQuery</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="03">JSP</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="04">PHP</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="05">Python</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="06">Peal</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="07">Shell</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="08">R</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="09">Scala</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="10">Haskell</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="11">Matlab</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="12">Visual Basic</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="13">Clojure</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="14">Groovy</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="15">XML</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="16">Assembly</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="17">Fortran</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="18">Ruby</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="19">Servlet</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="20">HTML</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="21">CSS</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="22">Node.JS</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="23">Oracle</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="24">Mysql</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="25">Mssql</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="26">MongoDB</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="27">Django</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="28">C</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="29">C++</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="30">C#</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="31">Object-C</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="32">Android</span>
					<br>
					<span id="skillArae">	<input type="checkbox" name="skill" value="33">IOS</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="34">Swift</span>
					<span id="skillArae">	<input type="checkbox" name="skill" value="35">Go</span>
					<br>
					</div>
					</td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td><textarea style="width: 100%; border-style: none;  outline: none; " rows="15" cols="50" name="pjtdtl"></textarea></td>
				</tr>
				<tr>
					<th>수행역할</th>
					<td>
						<select class="input2" name="perrole">
							<option value="0">pm</option>
							<option value="1">개발자</option>
							<option value="2"></option>
						</select> 
					</td>
				</tr>
			</table>
				<div id="btn">
						<input type="submit" value="등록">
						<input type="button" value="취소">
				</div>
			
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>