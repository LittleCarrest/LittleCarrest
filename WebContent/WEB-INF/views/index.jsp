<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/main/index.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<style type="text/css">
@media screen and (min-width: 1519px){
    /* main-footer */
    #footer_main{
		position:absolute;
		width:100%;
		top: 2300px;
	}
}

@media screen and (min-width: 1900px){
    /* main-footer */
    #footer_main{
		position:absolute;
		width:100%;
		top: 3000px;
	}
}
</style>


</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>
  <section class="main-sec01">
    <div class="bg-video">
      <video src="/resources/img/main/Forest - 9796.mp4"
        autoplay muted loop poster="/resources/img/main/poster.jpg">
      </video>
    </div>
    <div class="title">
      <h5>리틀카레스트가 <b>추천</b>하는</h5>
      <h3><span>재</span><span>명</span>만의 <b>REST</b></h3>
    </div>
  </section>
  <!-- ----------------------------sec02 rec-fullCourse-->
  <div class="wrap-col-main-sec02">
    <div class="tit-main-sec02"><h1>리틀카레스트는 여러분 감성에 맞는 차박 캠핑코스를 추천합니다.</h1></div>
    <div class="col-main-sec02-item"><img class="bg-rec-course" src="/resources/img/camping3.jpg"></div>
    <div class="col-main-sec02-item"><img class="bg-rec-course" src="/resources/img/sec2_3.jpg"></div>
    <div class="col-main-sec02-item"><img class="bg-rec-course" src="/resources/img/camping2.jpg"></div>
  </div>
  <!-- ----------------------------end-->
  <!-- ----------------------------sec03 rec-fullCourse-->

  <div class="bg-main-sec03">
    <div class="wrap-col-main-sec03 container">
      <div class="tit-main-sec03">
        <h1><span>감성/편의 차박장소 미리보기</span></h1>
      </div>
      <a href="/search/camping" class="more">MORE</a>
      <div class="col-main-sec03-item"></div>
      <div class="col-main-sec03-item"></div>
      <div class="col-main-sec03-item"></div>
    </div>
  </div>
  <div class="bg-main-sec04">
    <div class="wrap-col-main-sec04 container">
      <div class="tit-main-sec04">
        <h1><span>월별 축제 미리보기</span></h1>
      </div>
      <a href="/tour/festival" class="more">MORE</a>
      <div class="col-main-sec04-item"></div>
      <div class="col-main-sec04-item"></div>
      <div class="col-main-sec04-item"></div>
    </div>
  </div>
  <footer id="footer_main">
    Copyright 2021 by PCLASS 4TEAM. All Rights Reserved.
  </footer>
<script src="/resources/js/main/main-gnb.js"></script>
</body>
</html>