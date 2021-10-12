<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub03/guide.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>
  <section class="sub03-community-guide">
    <!-- 검색창 -->
    <div class="sub03-search-box">
      <div class="wrap-sub03-guide-search">
        <div class="sub03-guide-search">
          <div class=search>
            <input type="text" placeholder="검색어를 입력하세요">
            <i class="fas fa-car-side"></i>
          </div>
        </div>
        <h1 class="tit-sub03-guide-search">꾸미고 싶은 차박 아이템이나 원하는 캠핑Tip을 검색하세요!</h1>
      </div>
    </div>
    <!-- 캠핑 tip 게시물 -->
    <div class="container con-sub03-guide-tip">
      <div class="tit-sub03-guide-tip">
        <h1>리틀카레스트가 제안하는 캠핑TIP<span>더보기</span></h1>
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
      <!-- 감성캠핑 공유 섹션 -->
    <div class="container con-sub03-guide-board">
      <div class="tit-sub03-guide-board">
        <h1>나만의 꾸미기tip으로 감성캠퍼 되기<span>더보기</span>!</h1>
      </div>
      <article class="wrap-col-sub03-guide-board">
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item open-modal" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/여름나기.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/요리.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/차박가이드_ex.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/여름나기.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/요리.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/차박가이드_ex.jpg"></img>
          </a>
        </div>
        <div class="col-sub03-guide-tip">
          <a class="col-sub03-guide-item" href="#none">
            <img class="col-sub03-guide-img" src="/resources/img/sub03/텐트 고르는 꿀tip.jpg"></img>
          </a>
        </div>

      </article>
    </div>
    
  </section>

  <!-- Layer Popup -->
  <div class="modal">
    <div class="modal-inner">
      <div class="click-img"><img src="/resources/img/sub03/여름나기.jpg"></img></div>
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

  <!-- custom.js 링크 -->
  <script src="/resources/js/common/popup.js"></script>
</body>
</html>