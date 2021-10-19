<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/member/search-id.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <c:if test="${empty member and empty param.err}">
  <section class="id-search">
        <form action="/member/search-id" method="post">
      <div class="search-form">
        <div class="search-type">
          <h1>아이디 찾기</h1>
          <p>회원가입시 입력하신 <span style="color: red;">이름</span>과 <span style="color: red;">이메일</span>을 입력하세요.</p>
          <div class="common-login">
            <input type="text" name="userName" placeholder="이름을 입력하세요">
            <input type="text" name="email" placeholder="이메일을 입력하세요">
          </div>
          <input type="submit" class="btn btn-login" value="아이디찾기">
        </div>
      </div>
      </form>
  </section>
  </c:if>
    
   <c:if test="${not empty member}">
   <section class="id-search">
        <form action="/member/login-page" method="post">
      <div class="search-form">
        <div class="search-type">
          <h1>회원가입하신 아이디</h1>
          <div class="common-login">
            <input type="text" name="userId" value="${member.userId}">
          </div>
          <input type="submit" class="btn btn-login" value="로그인하러가기">
        </div>
      </div>
      </form>
  </section>
  </c:if>
  
  <c:if test="${not empty param.err}">
  <section class="id-search">
        <form action="/member/search-id" method="post">
      <div class="search-form">
        <div class="search-type">
          <h1>아이디 찾기</h1>
          <p style="color:red;">입력하신 정보는 존재하지 않습니다.</p>
          <div class="common-login">
            <input type="text" name="userName" placeholder="이름을 입력하세요">
            <input type="text" name="email" placeholder="이메일을 입력하세요">
          </div>
          <input type="submit" class="btn btn-login" value="아이디찾기">
        </div>
      </div>
      </form>
  </section> 
  </c:if>
    
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  <script type="text/javascript" src="/resources/js/kakaoLogin/kakaoLogin.js"></script> 

</body>
</html>