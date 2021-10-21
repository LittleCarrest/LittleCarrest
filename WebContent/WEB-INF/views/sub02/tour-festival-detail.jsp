<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub02/tour-festival-detail.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
  <%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <!-- 여기서부터 section -->
  <section class="sub03-community-guide">
    <div class="festival-image">
      <img src="" alt="">
    </div>
    <div class="container con-sub03-guide-tip">

      <div class="festival-title-wrap">
        <div class="festival-status">
          <p>진행중</p>
        </div>
        <div class="festival-title">
          <h1>제주도 흔들어 페스티벌</h1>
        </div>
        <div class="festival-date">
          <p>제주도 ｜ 2021.09.08 ~ 2021.10.17</p>
        </div>
      </div>

      <div class="festival-detail">
        <h1>상세내용</h1>
        <div class="line"></div>
        <p>청주공예비엔날레는 공예가 지닌 일상성과 예술성의 조화로운 균형 속에서 동시대인들의 정서를 읽고 감성을 표현하는 문화행사로서 지역의 오늘과 함께하며 세계의 내일을 선도하고자 한다.</p>
      </div>

      <div class="detail-info">
        <div class="detail-info-inside">
          <strong>관람시간</strong><span>1시간</span>
          <strong>요금(무료/유료)</strong><span>1000원</span>
          <strong>주차시설</strong><span>유</span>
          <strong>안내전화번호</strong><span>02-123-123</span>
        </div>
      </div>

    </div>

    <!-- edit-detail -->
    
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </section>

</body>
</html>