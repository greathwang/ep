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
<script type="text/javascript" src="js/address.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<script type="text/javascript">


$(function(){
    function readURL(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
             reader.onload = function (e) {
             //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                 $('#emp_img').attr('src', e.target.result);
                 //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                 //(아래 코드에서 읽어들인 dataURL형식)
             }                   
             reader.readAsDataURL(input.files[0]);
             //File내용을 읽어 dataURL형식의 문자열로 저장
         }
     }//readURL()--

     //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
     $("#emp_imgpath").change(function(){
         //alert(this.value); //선택한 이미지 경로 표시
         readURL(this);
     });
});
</script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main_auto">
		<div id="main">
			<div class="top">
				<h2>사원 등록</h2>
			</div>
			<hr><br>
			<form action="EmployeeServlet?command=emp_insert" method="post" name="frm" enctype="multipart/form-data" >
				<div id="login_form" >
					<p> <span>아이디</span> 
						<input class="input1" name="empid" id="empid" type="text" >
						<input type="button" value="중복 체크" onclick="idCheck()">
					</p>
					<p> <span>비밀번호</span> <input class="input1" name="pwd" id="pwd" type="password" > </p> 
					<p> <span>비밀번호 확인</span> <input class="input1" name="pwd_chk" id="pwd_chk" type="password" ></p>
					<p>	
						<span>사  진</span>
						<img width="150px" height="160px" name="emp_img" id="emp_img" src="upload/no_image.gif">
						<input type="file" name="emp_imgpath" id="emp_imgpath">
					</p>	
					<p> <span>성</span> <input class="input1" name="first_nm" id="first_nm" type="text" ></p>
					<p> <span>이름</span> <input class="input1" name="last_nm" id="last_nm" type="text" ></p>
					<p> <span>이메일</span> 
						<input class ="input1" type="text" name="first_email" id="first_email" >
						@
						<input class="input1" type="text" name="last_email" id="last_email"> </p>
					<p> <span>주민번호</span> 
						<input class="input0" type="text" name="first_reginum" id="first_reginum" maxlength="6">
							-
						<input class="input0" type="password" name="last_reginum" id="last_reginum" maxlength="7"> 
					</p>
					<p> <span>연락처</span> 
						<input class ="input4" type="text" value="010" name="fir_phone">
							-
						<input class="input5" type="text" name="mid_phone" maxlength="4">
							-
						<input class="input5" type="text" name="las_phone" maxlength="4">
					</p>
					<p> <span>우편번호</span> 
						<input class ="input0" type="text" name="zipcode" id="zipcode" readonly="readonly">
						 &nbsp;&nbsp;
						<input type="button" value ="주소찾기" id="find_address">
					</p>
					
					<p> <span>주소</span> <input class ="input3" type="text" name="address"id="address" readonly="readonly"></p>
					<p> <span>상세주소</span> <input class ="input3" type="text" name="detail_address"></p>
					<p> 
						<span>부서</span> 
							<select class="input1" name="dept_num">
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
							<select class="input1" name="pnum">
								<option value="00">사원</option>
								<option value="01">대리</option>
								<option value="02">과장</option>
								<option value="03">차장</option>
								<option value="04">부장</option>
								<option value="05">사장</option>
							</select> 
					</p>
					<p> <span>급여</span> <input class ="input1" type="text" name="salary" id="salary"></p>
					<p> <span>입사일</span> <input class ="input1" type="text" name="hire_date" id="datepicker1" value="${dayTime }" readonly="readonly"></p>
					<p> <span>퇴사일</span> <input class ="input1" type="text" name="out_date" id="datepicker2" disabled="disabled"></p>
					<p> 
						관리자  &nbsp;<input type="radio" name="manager" value="1"  checked="checked">  &nbsp;&nbsp;&nbsp; 
						일반사원 &nbsp;<input type="radio" name="manager" value="0">
					</p>
					<p> <input class="btn" type="submit" value="등록"></p>
				</div>
				
			</form>
			</div>
	<div id="dialog-form" title="주소 검색">
	  <p class=""></p>
	 
	  <!-- <form action="" id="frm" method="post"> -->
	      <label for="search"></label>
	      <input type="text" name="addrtext" id="addrtext" class="text ui-widget-content ui-corner-all">
	      <input type="button" id="address_find" value="검색">
	      <!-- Allow form submission with keyboard without duplicating the dialog button -->
	      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
	    <table id="addrTable">
			
	    </table>
	  <!-- </form> -->
	</div>

		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>