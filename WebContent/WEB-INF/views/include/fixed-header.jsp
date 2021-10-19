<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<body>
  <aside id="gnb-aside">
    <ul class="gnb-aside-menu">
      <li id="gnb-aside-search" data-gnb='01'><a href="/search/camping">차박검색</a></li>
      <li id="gnb-aside-tourInfo" data-gnb='02'><a href="/tour/info">관광정보</a></li>
      <li id="gnb-aside-community" data-gnb='03'><a href="/community/camper">커뮤니티</a></li>
    </ul>
  </aside>
  <header>
    <div class="wrap-header">
      <div class="container con-header">
        <button class="nav-toggleBtn">
          <i class="fas fa-bars"></i>
        </button>
        <div class="user">
	        <c:if test="${empty authentication}">
	          <a class="login" href="/member/login-page">LOGIN</a>
	          <a class="join" href="/member/join-page">JOIN</a>
			</c:if>
			<c:if test="${not empty authentication}">
	          <a class="mypage" href="/mypage/home">MYPAGE</a>
	          <a class="logout" href="/member/logout">LOGOUT</a>
			</c:if>
        </div>
        <div class="logo">
          <a href="/index"><img src="/resources/img/main/real_logo.png" alt=""></a>
        </div>
      </div>
      <div class="wrap-gnb-menu">
        <ul class="gnb-menu">
          <li id="gnb-search" data-gnb='01'><a href="/search/camping" class="gnb-main">차박검색</a></li>
          <li id="gnb-tourInfo" data-gnb='02'><a href="/toursite/home" class="gnb-main">관광정보</a></li>
          <li id="gnb-community" data-gnb='03'><a href="/community/camper" class="gnb-main">커뮤니티</a></li>
        </ul>
      </div>
      <div class="wrap-gnb-subMenu">
        <ul class="sub-menu search" data-gnb='01'>
          <li><a href="/search/camping">테마별</a></li>
          <li><a href="/search/full-course">풀코스추천</a></li>
        </ul>
        <ul class="sub-menu tourInfo" data-gnb='02'>
          <li><a href="/festival/home">지역별 축제</a></li>
          <li><a href="/toursite/home">지역별 명소</a></li>
        </ul>
        <ul class="sub-menu community" data-gnb='03'>
          <li><a href="/community/camper">#차박캠퍼</a></li>
          <li><a href="/community/guide">차박가이드</a></li>
        </ul>
      </div>
    </div>
  </header>
</body>
</html>