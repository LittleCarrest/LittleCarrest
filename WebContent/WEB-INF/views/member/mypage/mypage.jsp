<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/member/mypage/mypage.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>
  <!-- 여기서부터 section -->
  <section class="sub03-community-guide">
    <!-- 검색창 -->
    <div class="mypage-profile">
      <div class="profile-inside">
        <div class="profile-image">
          <img src="/resources/img/user.png" alt="">
        </div>
        <div class="profile-info">
          <div class="profile-name">
            <h3>jung</h3>
          </div>
          <div class="profile-follow">
            <span>팔로우</span> <span>10명</span> 
            <span>팔로워</span> <span>10명</span>
          </div>
          <div class="profile-intro"><p>안녕하세요 잘부탁드립니다.</p></div>
        </div>
      </div>
      <div class="mypage-button">
        <a href="/mypage/edit-profile">Edit Profile</a>
      </div>
    </div>

    <!-- 캠핑 tip 게시물 -->
    <div class="container con-sub03-guide-tip">
      <div class="tit-sub03-guide-tip">
        <h1>내 게시글</h1>
      </div>
      <article class="wrap-col-sub03-guide-tip">
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/그림1.png"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/그림2.png"></img
            ></a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/그림3.png"></img>
          </a>
        </div>

      </article>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>
</body>
</html>