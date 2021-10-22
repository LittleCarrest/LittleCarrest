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
	<form action="/community/upload" name="form" method="post" class="container con-tit-board-form" enctype="multipart/form-data">
		<h1 class="tit-form">커뮤니티 글쓰기<button type="submit" class="btn_upload">업로드하기</button></h1>	
		<div class="container wrap-form">
			<input id="file" type="file" name="file" style="opacity: 0;">
			<div class="board-form" >
				<div class="wrap-img">
					<button id="btn"class="btn_img" type="button"><i class="fas fa-camera-retro"></i></button>	
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
					<input class="tag" name="tag" type="text" placeholder="#키워드">
				</div>		
			</div>
		</div>
	</form>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</section>
<script type="text/javascript">

document.querySelectorAll('.input[type="text"]').forEach( input => {
	input.addEventListener('keydown',e => {
		
		  if (e.keyCode === 13) {
		    e.preventDefault();
		    document.querySelector('.txt-form').lastChild.addEventListener('change',addElement(e));
			
		  };
	})
})



document.querySelector('.btn_img').addEventListener('click', () => {
	document.querySelector('#file').click();
});


document.querySelector('#file').addEventListener('change', e => {
	
	let files = document.getElementById('file').files;
	
	for (let file of files) {
		if(validFileType(file)){
			let image = document.createElement('img');
			image.className = 'image';
			image.src = URL.createObjectURL(file);
			/* document.querySelector('#file').style.display='none';  */
			document.querySelector('#btn').style.display='none';
			document.querySelector('.wrap-img').appendChild(image);
			/* document.form.submit(); */
		}
	}

});

let fileTypes = [
	   "image/gif",
	   "image/jpeg",
	   "image/pjpeg",
	   "image/png",
	   "image/tiff",
	   "image/webp",
	   "image/x-icon"
	 ];
	 
let validFileType = (file) => {
   return fileTypes.includes(file.type);
 }
 
let addElement = (e) => {
	let tagInput = document.createElement("input");
	tagInput.type = 'text';
	tagInput.className = 'tag';
	tagInput.name = 'tag';
	tagInput.placeholder = '#키워드';
	$(e).after(tagInput);
	/* $('.txt-form').append($(e)); */
}

document.querySelector('.tag').addEventListener('change', e => {

	document.querySelectorAll('.tag').forEach(e => {
		e.addEventListener('change',addElement(e));
	})
	
});





/* document.querySelector('.tag').addEventListener('input', e => {
	
})
 */
</script>
</body>
</html>