<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub01/full-course.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <!-- ----------------------------gnb -->
  <section class="fullcourse">
    <div class="fullcourse-content">
      <div class="fullcourse-content-container">
        <div class="fullcourse-header">
          <div class="fullcourse-header-content">
            <p>이곳은 어디 일까요?</p>
          </div>
        </div>
        <div class="fullcourse-img">
          <div class="fullcourse-img-content">
            <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
          </div>
        </div>
        <div class="fullcourse-article">
          <div class="fullcourse-article-content">
          </div>
        </div>
        <div class="fullcourse-line">
          <div class="fullcourse-line-content">
            <div class="line"></div>
          </div>
        </div>
        <div class="fullcourse-article-tour">
          <div class="fullcourse-tour-content">
            <div class="tour-title">
              <h2>주변관광지</h2>
            </div>
            <div class="tour-img">
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
            </div>
          </div>
        </div>
        <div class="fullcourse-article-tour">
          <div class="fullcourse-tour-content">
            <div class="tour-title">
              <h2>주변먹거리</h2>
            </div>
            <div class="tour-img">
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
              <div class="tour-img-detail">
                <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
              </div>
            </div>
            <div class="fullcourse-tour-button">
              <div class="full-tour-button">
                <a class="button-title" href="#">
                  <p >코스한눈에보기</p>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
    
  <div class="bakc-fullcourse"></div>

  <!-- ----------------------------gnb end-->
  <section class="sub01-campingSearch">
    <div class="container con-sub01">
      <div class="tit-wrap">
        <div class="tit-image">
          <p>
            풀코스 추천01
          </p>
          <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
        </div>
        <div class="tit-image">
          <p>
            풀코스 추천02
          </p>
          <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
        </div>
        <div class="tit-image">
          <p>
            풀코스 추천03
          </p>
          <img src="/resources/img/sub02/차박가이드_ex.jpg" alt="">
        </div>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>

  <script>

    $(".tit-image").click(function(){
      setTimeout(function() {
        $(".fullcourse").addClass("topmotion");
        $(".bakc-fullcourse").addClass("back-display")
      },0)
      $(".fullcourse").addClass("fullflex");
      
    })

  </script>
</body>
</html>