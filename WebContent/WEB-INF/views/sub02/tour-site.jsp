<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub02/tour-site.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=69107c554701b54eadcccbac1a29bcf2"></script>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=69107c554701b54eadcccbac1a29bcf2&libraries=LIBRARY"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <!-- section -->
  <section class="sub02-tour-site">
    <!-- top -->
    <div class="sub02-tour-site-welcome-box" style="background-image: url(/resources/img/sub02/tourSiteBg.jpg);">
      <h1>Make your memories here</h1>
    </div>
    <!-- content-currLoc -->
    <div class="wrap-con-sub02-site-bg">
      <div class="container con-sub02-site-currLoc">
        <div class="tit-sub02-site-currLoc">
          <h1>방구석 근거리 여행</h1>
          <div id="map" class="map">지도 들어갈 공간입니다.</div>
        </div>
        <article class="wrap-col-sub02-site-currLoc">
          <div class="col-sub02-site-currLoc">
            <a class="col-sub02-site-currLoc-item" href="#none">
              <img class="col-sub02-site-currLoc-img" src="/resources/img/sub02/차박가이드_ex.jpg"></img>
              <div class="overlay-col-sub02"></div>
              <h1>#양양 하조대</h1>
            </a>
          </div>
          <div class="col-sub02-site-currLoc">
            <a class="col-sub02-site-currLoc-item" href="#none">
              <img class="col-sub02-site-currLoc-img" src="/resources/img/sub02/차박가이드_ex.jpg"></img>
            </a>
          </div>
          <div class="col-sub02-site-currLoc">
            <a class="col-sub02-site-currLoc-item" href="#none">
              <img class="col-sub02-site-currLoc-img" src="/resources/img/sub02/차박가이드_ex.jpg"></img>
            </a>
          </div>
          <div class="col-sub02-site-currLoc">
            <a class="col-sub02-site-currLoc-item" href="#none">
              <img class="col-sub02-site-currLoc-img" src="/resources/img/sub02/차박가이드_ex.jpg"></img>
            </a>
          </div>
          <div class="col-sub02-site-currLoc">
            <a class="col-sub02-site-currLoc-item" href="#none">
              <img class="col-sub02-site-currLoc-img" src="/resources/img/sub02/차박가이드_ex.jpg"></img>
            </a>
          </div>
        </article>
      </div>
      <!-- tourSite-region -->
      <div class="container con-sub02-site-region">
        <div class="tit-sub02-site-region">
          <h1>지역별 명소</h1>
        </div>
        <div class="wrap-col-sub02-site-region">
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2FtcGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://www.gooutkorea.com/wp-content/uploads/2020/04/2-6-500x380.jpg)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2FtcGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://www.gooutkorea.com/wp-content/uploads/2020/04/2-6-500x380.jpg)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2FtcGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
          <div class="col-sub02-site-region">
            <a class="col-sub02-site-region-item" href="#">
              <!-- <span class="new">NEW</span> -->
              <div class="col-sub02-site-region-bg"
                style="background-image: url(https://www.gooutkorea.com/wp-content/uploads/2020/04/2-6-500x380.jpg)">
              </div>
              <article>
                <h1>제부도 매바위 공영주차장</h1>
                <span>조회 100</span>
              </article>
            </a>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
   </section>
   <script type="text/javascript">
   

   let latlng = () => {
	   return new Promise((resolve,reject)=>{
	      navigator.geolocation.getCurrentPosition((position) =>{
	         resolve(position.coords);         
	      });
	   })
	}

   /* 현위치 근처 관광지 */
   let toursite = async() => {
	   let header = new Headers();
	   header.append('Authorization','KakaoAK 02235aa3e05dc625e3390ddd831ad7de');
	   
	   let currLoc = await latlng();
	   
	   let url = `https://dapi.kakao.com/v2/local/search/category.json`;
	   let queryString = `?category_group_code=AT4&x=${currLoc[0]}&y=${currLoc[1]}&radius=500`; 
	   
	   let response = await fetch(url+queryString,{ method : "get", headers : header});
	   let obj = await response.json();

	   return new Promise((resolve,reject)=>{	
		   resolve(obj)
	   });
	   


   }
   
   
let drawMap = (currLoc,searchLoc) =>{

	   
	   let options = { center: new kakao.maps.LatLng(currLoc.latitude, currLoc.longitude), 
	               level: 3, 
	               keyboardShortcuts:true};
	   
	   var map = new kakao.maps.Map(document.getElementById('map'),options);
	   map.addControl(new kakao.maps.MapTypeControl(),kakao.maps.ControlPosition.BOTTOMLEFT);
	   map.addControl(new kakao.maps.ZoomControl(),kakao.maps.ControlPosition.BOTTOMRIGHT);
	      
	   new kakao.maps.Marker({
	       map: map,
	       position: new kakao.maps.LatLng(currLoc.latitude, currLoc.longitude)
	   });
	   
	   console.dir(searchLoc);
	   console.dir(searchLoc.documents);
	   
	      let x = []
	      let y = []
	      searchLoc.documents.forEach(e => {
	            x.push(Number(e.x))
	            y.push(Number(e.y))
	     })

	     let storeMarker = (x,y) => {
             var marker = new kakao.maps.Marker({
             map: map,
             position: new kakao.maps.LatLng(x, y)
             });
        }

        for (let i = 0; i < x.length; i++) {
            storeMarker(y[i],x[i])
        }
	   }

(async () => {
	let currLoc = await latlng();		//현재 위치
	let tourObj = await toursite(currLoc);	//현재 위치 인근편의점
	drawMap(currLoc,tourObj);
})();


   	
   	
   	

   
   
   </script>
</body>
</html>