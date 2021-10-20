<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/member/mypage/edit-profile.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>

  <!-- 여기서부터 section -->
  <section class="sub03-community-guide">
    <!-- 검색창 -->
    <div class="mypage-profile">
      <div class="profile-inside">
        <div class="profile-image">
          <c:if test="${not empty authentication and not empty authentication.profile}">
          	<img id="target_img" src="http://localhost:7070/file/${authentication.profile}">
          </c:if>
          <c:if test="${not empty authentication and empty authentication.profile}">
            <img id="target_img" src="/resources/img/user.png">
          </c:if>        
        </div>
        <div class="info-edit-button">
          <form action="/mypage/upload-profile" name="img" class="edit-image" method="POST" enctype="multipart/form-data">
            <label class="profile_img" for="img-file">Upload new Picture</label>
            <input type="file" name="file" id="img-file">
          </form>
        </div>
      </div>
    </div>

    <!-- edit-detail -->
    <div class="container wrap-form">
      <form name="edit_form" id="edit-profile-form" action="/mypage/edit" method="POST">
        <div class="edit-name">
          <span>닉네임</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail nickname">
          <input type="text" name="nickname" id="nickname" value="${authentication.nickname }">
          <button type="button" class="btn-chk-nick">중복확인</button>
        </div>
        <em id="alert_nick" class="alert_auth">
          	<c:if test="${not empty param.err and not empty editValid.nickname}">
          		닉네임을 사용하실 수 없습니다.
          	</c:if>
        </em>  
        <div class="edit-intro mt">
          <span>자기소개</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text" name="info" value="${authentication.info }">
        </div>
        <div class="edit-pass mt line">
          <span>새 비밀번호</span><span style="color: red;" > *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text" name="password" id="password">
          <em id="alert_password" class="alert_auth">
          	<c:if test="${not empty param.err and not empty editValid.password}">
          		영문,숫자,특수문자 포함 8~15자를 입력하세요.
          	</c:if>
          </em> 
        </div>
        <div class="edit-pass mt">
          <span>새 비밀번호 확인</span><span style="color: red;"> *</span>
        </div>
        <div class="edit-profile-detail">
          <input type="text" name="chk-pw" id="chk-pw">
          <em id="alert_nick" class="alert_auth">
          	<c:if test="${not empty param.err and not empty editValid.confirmPw}">
          		비밀번호가 일치하지 않습니다
          	</c:if>
          </em> 
        </div>
        <div class="edit-button">
          <input id="btn-edit" type="submit" value="수정 완료">
        </div>
      </form>
    </div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </section>
  
<script type="text/javascript">
  

let confirmNick = '';
 
let changeValue = (obj) => {
 document.img.submit();

}



document.querySelector('.btn-chk-nick').addEventListener('click', ()=>{
	  let nickname = document.querySelector('#nickname').value;
	  
	  if(nickname == null){
		document.querySelector('#alert_nick').innerHTML = '닉네임을 입력하지 않았습니다.';
		return;
	  }
	  
	  fetch("mypage/chk-nickname?nickname=" + nickname)
	  .then(response => {
		  if(response.ok){	//통신 성공시
			  return response.text();
		  }else{
			  throw new Error(response.status);
		  }
	  }).then(text => {	//promise객체의 text
		  if(text == 'available'){
			  confirmNick = nickname;
			  
			  document.querySelector('#alert_nick').style.color = 'var(--point-color)';
			  document.querySelector('#alert_nick').innerHTML = '사용 가능한 닉네임입니다.';
		  }else{
			  document.querySelector('#alert_nick').innerHTML = '사용 불가능한 닉네임입니다.';
		  }
	  }).catch(error => {
		  document.querySelector('#alert_nick').innerHTML = '응답에 실패하였습니다.';
	  });
	  
});


document.querySelector('#btn-edit').addEventListener('click',(e) => {

		e.preventDefault();	
	  let nickname = document.querySelector('#nickname').value;
	  let password = document.querySelector('#password').value;
	  let confirmPw = document.querySelector('#chk-pw').value;
	  console.dir('' + confirmNick);

	  /* 사용자 닉네임이 기존 닉네임과 동일하다면 중복검사 패스 */
	  /* null인 경우에도 닉네임 변경의도가 없음으로 간주하고 중복검사 패스 */
	  if(nickname != null && nickname != '${authentication.nickname}' && confirmNick == ''){	  
		  console.dir(confirmNick);
		  document.querySelector('#alert_nick').innerHTML = '닉네임 중복 검사를 하지 않았습니다.';
		  document.querySelector('#alert_nick').focus();
		    		
	  }else{
		  document.edit_form.submit();
	  }
	  

});
/* 
document.querySelector('.profile_img').addEventListener('click', function (e) {
	 document.img.file.value = document.getElementById('target_img').src;
    e.preventDefault();
  	 $('.profile_img').click();	//changeValue메서드 호출
});
   */
   
document.querySelector('#img-file').addEventListener('change', (e) => {
	
	//e.preventDefault();	 
	console.dir(document.getElementById('img-file'));
	let files = document.getElementById('img-file').files;
	
	for (let file of files) {
		if(validFileType(file)){
			document.getElementById('target_img').src = URL.createObjectURL(file);
			document.img.submit();
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
 
function validFileType(file) {
   return fileTypes.includes(file.type);
 }
  
</script>
</body>
</html>