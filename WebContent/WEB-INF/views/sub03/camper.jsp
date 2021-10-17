<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub03/camper.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <section class="sub03-community-camper">
    <div class="container con-tit-sub03-camper">
      <div class="tit-sub03-camper">
        <h1>리틀카레스트 #차박캠퍼</h1>
      </div>
      <ul class="tit-sub03-camper-tag">
      <c:forEach items="${campers}" var="camper">
      	<li><a href="/community/user-page?user=${camper.userIdx}"># ${camper.nickname}</a></li>
      </c:forEach>

      </ul>
    </div>
    <!-- 콘텐츠 grid영역 -->
    <div class="container con-sub03-bestCamper">
      <div class="tit-sub03-best-camper">
        <h3>리틀카레스트 인기팔로워 TOP10<a href="/community/board-form" id="btn_write">글쓰기</a></h3>
      </div>
      <article class="wrap-col-sub03-best-camper">
        <!-- <span class="userId">@jungyk</span> -->
        <div class="col-sub03-bc open-modal">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2FtcGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg" alt="">
          </a>
        </div>
      </article>
    </div>

    <div class="container con-sub03-latestPost">
      <div class="tit-sub03-latestPost">
        <h3>최신 업로드 게시물<span>더보기</span></h3>
      </div>
      <article class="wrap-col-sub03-latest-post">
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2FtcGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/차박가이드_ex.jpg" alt="">
          </a>
        </div>
        <div class="col-sub03-bc">
          <a class="col-sub03-bc-item" href="#">
            <img class="col-sub03-bc-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg" alt="">
          </a>
        </div>
      </article>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>
  
  
  <!-- Layer Popup -->
  <div class="modal">
    <div class="modal-inner">
      <div class="click-img"><img src="/resources/img/sub03/차박가이드_ex.jpg"></img></div>
      <div class="desc">
        <div class="desc-header">
          <div class="profile"><span>yudi_i2</span></div>
          <button class="close-modal">&times;</button>
        </div>
        <div class="wr-desc-content">
          <div class="desc-content">
            <p>
              여기에는 구매링크를 올려줄거에유..근데 어떻게 보여주는게 좋을까유..
            </p>
            <p>
              이것은 최고의 파이어스틸이다. 이런 우드테이블 본 적 있니
            </p>
            <p>
              배고프다 내일은 무엇을 먹을까나.
            </p>
          </div>
          <div class="hashtag">
            <a href="#none">#파이어스틸</a>
            <a href="#none">#타프</a>
            <a href="#none">#워터저그</a>
            <a href="#none">#무쇠팬</a>
            <a href="#none">#스토브</a>
            <a href="#none">#우드테이블</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="overlay"></div>
  <script src="/resources/js/common/popup.js"></script>
</body>
</html>