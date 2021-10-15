<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/sub03/board-form.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>
<section class="sec03-board-form">
	<form action="/community/upload" method="post" class="container con-tit-board-form" enctype="multipart/form-data">
		<h1 class="tit-form">커뮤니티 글쓰기<button type="submit" class="btn_upload">업로드하기</button></h1>	
		<div class="container wrap-form">
			<div class="board-form" >
				<div class="wrap-img">
					<button id="btn"class="btn_img" type="button"><i class="fas fa-camera-retro"></i></button>
					<img id="img" class="btn_img" style="display: none" src="#">
					<input id="file" type="file" style="display: none;">
				</div>
				<div class="txt-form">
					<h2>카테고리</h2>
					<select name="category">
						<option value="c">#차박캠퍼</option>
						<option value="g">차박가이드</option>
					</select>
					<h2>내용</h2>
					<textarea name="content" rows="10" cols="40"></textarea>	
					<h2>해시태그</h2>
					<input class="tag" type="text" placeholder="#키워드">
				</div>		
			</div>
		</div>
	</form>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</section>
<script type="text/javascript">



document.querySelector('.btn_img').addEventListener('click', () => {
	console.dir(document.querySelector('#file'));
	document.querySelector('#file').click();
});

let readImg = input => {
	if(input.files && input.files[0]){
		let reader = new FileReader();
		
		reader.onload = e => {
			document.querySelector('#btn').style.display='none';
			console.log('e.target.result : ' + e.target.result);
			document.querySelector('#img').style.display='inline-block';
			document.querySelector('#img').src = e.target.result;
		}
		reader.readAsDataURL(input.files[0]);
	}
}

document.querySelector('#file').addEventListener('change', e => {
	readImg(e.target);	//input-file
	console.dir(e.target);
	//uploadFile();
	/* sendFile(fileURL); */
});

function uploadFile() {
	  let formData = new FormData(document.querySelector('.con-tit-board-form'));
	   $.ajax({
	       url: "/community/upload", //컨트롤러 URL
	       data: formData,
	       dataType: 'json',
	       processData: false, // 비동기 파일 업로드시 꼭 설정해줘야 하는 속성
	       contentType: false, // 비동기 파일 업로드시 꼭 설정해줘야 하는 속성
	       type: 'POST',
	       success: function (res) {
	         alert("success");
	       },error: function (xhr) {
	         alert(xhr.responseText);
	       } 
	    });
	}

/* 비동기로 이미지 파일테이블에 등록하기  */
/* let sendFile = async (reader) => {
	let response = await fetch('/community/upload');
	
	if(!response.ok){
		throw new Error('status : ' ${response.status})
	}else{
		if(type)
	}
}
 */



</script>
</body>
</html>