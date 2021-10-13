<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/member/mypage/edit-profile.css">
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
          <img src="img/사랑이.jpg" alt="">
        </div>
        <div class="info-edit-button">
          <form action="" class="edit-image">
            <label for="img-file">Upload new Picture</label>
            <input type="file" id="img-file">
          </form><div class=""><a href="#"></a></div>
        </div>
      </div>
    </div>

    <!-- edit-detail -->
    <div class="container con-sub03-guide-tip">
      <form action="" method="POST">
        <div class="edit-name">
          <span></h1>닉네임</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text" placeholder="jung">
        </div>
        <div class="edit-intro mt">
          <span></h1>자기소개</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text" placeholder="안녕하세요">
        </div>
        <div class="edit-pass mt line">
          <span></h1>새 비밀번호</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text">
        </div>
        <div class="edit-pass mt">
          <span></h1>새 비밀번호 확인</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text">
        </div>
        <div class="edit-button">
          <input type="submit" value="수정 완료">
        </div>
      </form>
    </div>



	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>
</body>
</html>