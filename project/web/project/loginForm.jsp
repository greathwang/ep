<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 관리 프로그램</title>
<link rel="stylesheet" type="text/css" href="css/Loginform_style.css">
</head>
<body>
<body class="align">
  <div class="site__container">
		<h1>사원 관리 프로그램</h1>
    <div class="grid__container">

      <form action="LoginServlet" method="post" class="form form--login">
		<!-- <input name="command" type="hidden" value="login">		 -->
        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
          <input name="empid" id="empid" type="text" class="form__input" placeholder="아이디를 입력하세요" required="required">
        </div>

        <div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
          <input name="pwd" id="pwd" type="password" class="form__input" placeholder="Password" required="required" >
        </div>

        <div class="form__field">
          <input type="submit" value="로그인">
        </div>

      </form>
    </div>
  </div>
</body>
</html>