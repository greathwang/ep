<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty empid}">
	<jsp:forward page="../EmployeeServlet"/>
</c:if>
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

<script type="text/javascript">

$(function(){
    var $win = $(window);
    var top = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
 
    /*사용자 설정 값 시작*/
    var speed          = "normal";     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
    var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
    var $layer         = $('.stv_list'); // 레이어 셀렉팅
    var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
    $layer.css('position', 'relative');
    /*사용자 설정 값 끝*/
 
    // 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
    if (top > 0 )
        $win.scrollTop(layerTopOffset+top);
    else
        $win.scrollTop(0);
 
    //스크롤이벤트가 발생하면
    $(window).scroll(function(){
        yPosition = $win.scrollTop() - 123;
        if (yPosition < 0)
        {
            yPosition = 0;
        }
        $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
    });
});
</script>

<style>
	#main{height: 1000px}
	.input0 { width:70px;}
	.input1 { width:150px;}
	.input2 { width:200px;}
	.input3 { width:300px;}
	.input4 { width:25px;}
	.input5 { width:30px;}
	#login_form span {display: inline-block; width:150px;}
	#login_form p {margin-top:15px;}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../navi.jsp"></jsp:include>
		<div id="main">
			<div class="top">
				<h2>사원 등록</h2>
			</div>
			<hr><br>
			<form action="EmployeeServlet?command=emp_insert" method="post" name="frm">
				<div id="login_form" >
					<p> <span>성</span> <input class="input1" name="first_nm" id="first_nm" type="text" ></p>
					<p> <span>이름</span> <input class="input1" name="last_nm" id="last_nm" type="text" ></p>
					<p> <span>비밀번호</span> <input class="input1" name="pwd" id="pwd" type="password" ></p>
					<p> <span>비밀번호 확인</span> <input class="input1" name="pwd_chk" id="pwd_chk" type="password" ></p>
					<p> <span>이메일</span> <input class ="input1" type="text" name="first_email" id="first_email" >@<input class="input1" type="text" name="last_email" id="last_emaile"> </p>
					<p> <span>주민번호</span> <input class="input0" type="text" name="first_reginum" id="first_reginum" maxlength="6">-<input class="input0" type="password" name="last_reginum" id="last_reginum"> </p>
					<p> <span>연락처</span> <input class ="input4" type="text">-<input class="input5" type="text"></p>
					<p> <span>우편번호</span> <input class ="input1" type="text"></p>
					<p> <span>주소</span> <input class ="input1" type="text"></p>
					<p> <span>상세주소</span> <input class ="input1" type="text"></p>
					<p> 
						<span>부서</span> 
							<select class="input1">
								
							</select> 
					</p>
					<p> 
						<span>직급</span> 
							<select class="input1">
								
							</select> 
					</p>
					<p> <span>급여</span> <input class ="input1" type="text" name="salary" id="salary"></p>
					<p> <span>입사일</span> <input class ="input1" type="date" name="hire_date" id="hire_date"></p>
					<p> <span>퇴사일</span> <input class ="input1" type="date" name="out_date" id="out_date"></p>
					<p> 
						관리자  &nbsp;<input type="radio" name="manager" value="1"  checked="checked">  &nbsp;&nbsp;&nbsp; 
						일반사원 &nbsp;<input type="radio" name="manager" value="0">
					</p>
				</div>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>