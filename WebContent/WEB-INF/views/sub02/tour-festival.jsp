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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.8/slick.css" integrity="sha512-inhNdg7IzfSAH94H3l6CthSX4Jw+1zhesq/N7JZ01ZyMvbGvOh2d7+j1fuEHA57TMdGDJXJ48SsXKhx4iIOkBQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript">
	
	
	
</script>
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
        <div class="festival-title">
          <h1>이달의 축제</h1>
        </div>
        <div class="wrapper">
              <div class="carousel">
              <c:forEach var="festivalMonth" items="${festivalOfMonths}" begin="0" end="5">
             	 <div><p style="line-height: 27px">${festivalMonth.name}</p><img style="height: 230px;" src="${festivalMonth.image}"></div>
              </c:forEach>
              </div>
        </div>
      </div>

      <div class="season-tabs">
        <div class="season-button">
          <ul>
            <li class="spring"><a >봄</a></li>
            <li class="summer"><a >여름</a></li>
            <li class="fall"><a >가을</a></li>
            <li class="winter"><a >겨울</a></li>
          </ul>
        </div>
        <div class="season-main">
          <div class="season-main-inner">
            <div class="main-inner-text">
              <h1 id="springTitle"></h1>
              <p id="dateLocation"></p>
            </div>
            <div class="season-main-img">
              <img id="titleImage" src="" alt="">
            </div>
          </div>
        </div>
        <div class="season-sub">
          <div class="season-sub-wrap">
            <div class="season-sub-row">
              <div class="season-sub-col">
                <p id="seasonFe01">영월 붉은메밀 축제 </p>
                <img id="seasonImage01" src="https://picsum.photos/300/200?random=2">
              </div>
              <div class="season-sub-col">
                <p id="seasonFe02">영월 붉은메밀 축제</p>
                <img id="seasonImage02" src="https://picsum.photos/300/200?random=2">
              </div>
              <div class="season-sub-col">
                <p id="seasonFe03">영월 붉은메밀 축제</p>
                <img id="seasonImage03" src="https://picsum.photos/300/200?random=2">
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>
  <script 
    src="https://code.jquery.com/jquery-3.6.0.js"
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
    crossorigin="anonymous"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
</body>
<script>

           $(document).ready(function(){
	            $('.carousel').slick({
	            slidesToShow: 3,
	            dots:false,
	            centerMode: true,
	            prevArrow: $('.festival-prev-button'),
	            nextArrow: $('.festival-after-button'),
	            responsive: [ // 반응형 웹 구현 옵션
	              {  
	                breakpoint: 960, //화면 사이즈 960px
	                settings: {
	                  //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
	                  slidesToShow:2
	                } 
	              },
	              { 
	                breakpoint: 768, //화면 사이즈 768px
	                settings: {	
	                  //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
	                  slidesToShow:1
	                } 
	              }
	            ]
	            });
	            
	            $.ajax({
	            	type:'get',
	            	astnc:true,
	            	url:'./fetival/home/spring',
	            	success:(data) => {
	            		var springData = JSON.parse(data);
	            		
	            		function parse(str) {
	                	    var y = str.substr(0, 4);
	                	    var m = str.substr(4, 2);
	                	    var d = str.substr(6, 2);
	                	    return m+"."+d;
	                	}
	            		
	            		var startDate = parse(springData.spring[0].startDate)
	            		var endDate = parse(springData.spring[0].endDate)
	            		$('#dateLocation').append(startDate+"~"+endDate + "<span class='no-drag'> ｜ </span>" + springData.spring[0].address);
	            		
	            		$('#springTitle').text(springData.spring[0].name);
	            		$('#seasonFe01').text(springData.spring[1].name);
	            		$('#seasonFe01').append("<span>"+springData.spring[1].address +"<span>");
	            		$('#seasonFe02').text(springData.spring[2].name);
	            		$('#seasonFe02').append("<span>"+springData.spring[2].address +"<span>");
	            		$('#seasonFe03').text(springData.spring[3].name);
	            		$('#seasonFe03').append("<span>"+springData.spring[3].address +"<span>");
	            		$("#titleImage").attr("src", springData.spring[0].image);
	            		$("#seasonImage01").attr("src", springData.spring[1].image);
	            		$("#seasonImage02").attr("src", springData.spring[2].image);
	            		$("#seasonImage03").attr("src", springData.spring[3].image);
	            		
	            		
	            	},
	            	error:() => {
	            		alert('error');
	            	}
	            });
            });
         
           $('.spring').click(()=> {
          	 
        	   $.ajax({
	            	type:'get',
	            	astnc:true,
	            	url:'./fetival/home/spring',
	            	success:(data) => {
	            		var springData = JSON.parse(data);
	            		
	            		function parse(str) {
	                	    var y = str.substr(0, 4);
	                	    var m = str.substr(4, 2);
	                	    var d = str.substr(6, 2);
	                	    return m+"."+d;
	                	}
	            		
	            		var startDate = parse(springData.spring[0].startDate)
	            		var endDate = parse(springData.spring[0].endDate)
	            		$('#dateLocation').text("");
	            		$('#dateLocation').append(startDate+"~"+endDate + "<span class='no-drag'> ｜ </span>" + springData.spring[0].address);
	            		
	            		$('#springTitle').text(springData.spring[0].name);
	            		$('#seasonFe01').text(springData.spring[1].name);
	            		$('#seasonFe01').append("<span>"+springData.spring[1].address +"<span>");
	            		$('#seasonFe02').text(springData.spring[2].name);
	            		$('#seasonFe02').append("<span>"+springData.spring[2].address +"<span>");
	            		$('#seasonFe03').text(springData.spring[3].name);
	            		$('#seasonFe03').append("<span>"+springData.spring[3].address +"<span>");
	            		$("#titleImage").attr("src", springData.spring[0].image);
	            		$("#seasonImage01").attr("src", springData.spring[1].image);
	            		$("#seasonImage02").attr("src", springData.spring[2].image);
	            		$("#seasonImage03").attr("src", springData.spring[3].image);
	            		
	            	},
	            	error:() => {
	            		alert('error');
	            	}
	            });
        	   
           })
           
           
           $('.summer').click(()=> {
        	 
        	   $.ajax({
	            	type:'get',
	            	astnc:true,
	            	url:'./fetival/home/summer',
	            	success:(data) => {
	            		var springData = JSON.parse(data);
	            		
	            		function parse(str) {
	                	    var y = str.substr(0, 4);
	                	    var m = str.substr(4, 2);
	                	    var d = str.substr(6, 2);
	                	    return m+"."+d;
	                	}
	            		
	            		var startDate = parse(springData.spring[0].startDate)
	            		var endDate = parse(springData.spring[0].endDate)
	            		$('#dateLocation').text("");
	            		$('#dateLocation').append(startDate+"~"+endDate + "<span class='no-drag'> ｜ </span>" + springData.spring[0].address);
	            		
	            		$('#springTitle').text(springData.spring[0].name);
	            		$('#seasonFe01').text(springData.spring[1].name);
	            		$('#seasonFe01').append("<span>"+springData.spring[1].address +"<span>");
	            		$('#seasonFe02').text(springData.spring[2].name);
	            		$('#seasonFe02').append("<span>"+springData.spring[2].address +"<span>");
	            		$('#seasonFe03').text(springData.spring[3].name);
	            		$('#seasonFe03').append("<span>"+springData.spring[3].address +"<span>");
	            		$("#titleImage").attr("src", springData.spring[0].image);
	            		$("#seasonImage01").attr("src", springData.spring[1].image);
	            		$("#seasonImage02").attr("src", springData.spring[2].image);
	            		$("#seasonImage03").attr("src", springData.spring[3].image);
	            		
	            	},
	            	error:() => {
	            		alert('error');
	            	}
	            });
        	   
           })
           
           
           

 
</script>

</body>
</html>