<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub02/tour-festival.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <!-- ----------------------------gnb end-->
  <section class="sub01-campingSearch">
    <div class="container con-sub01">
      <div class="festival-wrap">
        <div class="festival-prev-button">
          <svg width="40" height="40" viewBox="0 0 40 40" preserveAspectRatio="xMidYMid meet"><g fill="none"><circle cx="20" cy="20" r="20" fill="#FFF" class="circle"></circle><path fill="#424242" d="M17 20l7.5 7.5-1.4 1.4-8.4-8.4-.5-.5.5-.5 8.4-8.4 1.4 1.4-7.5 7.5z" class="arrow"></path></g></svg>
        </div>
        <div class="festival-after-button">
          <svg width="40" height="40" viewBox="0 0 40 40" preserveAspectRatio="xMidYMid meet"><g fill="none" transform="matrix(-1 0 0 1 40 0)"><circle cx="20" cy="20" r="20" fill="#FFF" class="circle"></circle><path fill="#424242" d="M17 20l7.5 7.5-1.4 1.4-8.4-8.4-.5-.5.5-.5 8.4-8.4 1.4 1.4-7.5 7.5z" class="arrow"></path></g></svg>
        </div>
        <div class="festival-row">
          <div class="festival-col">
            <p>
              1
            </p>
            <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
          </div>
          <div class="festival-col">
            <p>
              2
            </p>
            <img src="#" alt="">
          </div>
          <div class="festival-col">
            <p>
              3
            </p>
            <img src="#" alt="">
          </div>
        </div>
      </div>
      <!-- <div class="tit-sub01">
        <h1>편안한캠핑</h1>
      </div> -->
      <div class="season-tabs">
        <div class="season-button">
          <ul>
            <li><a href="#">봄</a></li>
            <li><a href="#">여름</a></li>
            <li><a href="#">가을</a></li>
            <li><a href="#">겨울</a></li>
          </ul>
        </div>
        <div class="season-main">
          
        </div>
        <div class="season-sub">
          <div class="season-sub-wrap">
            <div class="season-sub-row">
              <div class="season-sub-col"></div>
              <div class="season-sub-col"></div>
              <div class="season-sub-col"></div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>

</body>
</html>