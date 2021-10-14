<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/member/login-page.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <section class="sec-login">
  	<form action="/member/login" method="post">
    <div class="login-form">
      <div class="login-type">
        <h1>로그인</h1>
        <div class="common-login">
          <input type="text" name="userId" placeholder="아이디를 입력하세요">
          <input type="password" name="password" placeholder="패스워드를 입력하세요">
        </div>
        <input type="submit" class="btn btn-login" value="로그인">
        <span class="or-text">또는</span>
        <a class="btn btn-kakao-login" href="/member/kakao-login">카카오톡 로그인</a>
        <div class="login-footer">
          <h3 class="wrap-find">
             <a href="/member/find-id">아이디 찾기</a>
             <span>or</span>
             <a href="/member/find-password">비밀번호 찾기</a>
          </h3>
          <p>
            리틀카레스트 처음이신가요? <a href="/member/join-page">회원가입</a>
          </p>
        </div>
      </div>
    </div>  
    </form>
  </section>
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>