<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub01/search-detail.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

<!-- 여기서부터 section -->
  <section class="sub03-community-guide">
    <!-- 검색창 -->
    <div class="container con-sub03-guide-tip">
      <div class="detail-image">
        <img src="" alt="">
      </div>
      <div class="detail-title">
        <h1>제주도 매바위 공영주차장</h1>
      </div>
      <div class="detail-info">
        <div class="detail-info-inside">
          <strong>운영상태</strong><span>운영중</span>
          <strong>비용</strong><span>2000만원</span>
          <strong>주소</strong><span>경기도 가평시 계곡</span>
          <strong>문의처</strong><span>가평캠핑마을</span>
          <strong>홈페이지</strong><span>camping@camping.com</span>
          <strong>주변이용가능시설</strong><span>화장실</span>
        </div>
      </div>
    </div>

    <!-- edit-detail -->
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
</body>
</html>