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
        <form action="/member/search-password" method="post">
      <div class="search-form">
        <div class="search-type">
          <h1>비밀번호 찾기</h1>
          <p>회원가입시 입력하신 <span style="color: red;">아이디</span>와 <span style="color: red;">이메일</span>을 입력하세요.</p>
          <div class="common-login">
            <input type="text" name="userId" placeholder="아이디를 입력하세요">
            <input type="text" name="email" placeholder="이메일을 입력하세요">
          </div>
          <input type="submit" class="btn btn-login" value="임시 비밀번호 발급">
        </div>
      </div>
      </form>
  </section>
  </c:if>
  
  <c:if test="${not empty param.err}">
  <section class="id-search">
        <form action="/member/search-password" method="post">
      <div class="search-form">
        <div class="search-type">
          <h1>비밀번호 찾기</h1>
          <p style="color:red;">입력하신 정보는 존재하지 않습니다.</p>
          <div class="common-login">
            <input type="text" name="userId" placeholder="아이디를 입력하세요">
            <input type="text" name="email" placeholder="이메일을 입력하세요">
          </div>
          <input type="submit" class="btn btn-login" value="임시 비밀번호 발급">
        </div>
      </div>
      </form>
  </section> 
  </c:if>
    
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  <script type="text/javascript" src="/resources/js/kakaoLogin/kakaoLogin.js"></script> 

</body>
</html>