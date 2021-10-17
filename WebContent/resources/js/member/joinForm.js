
   //변수가 전역변수에 선언되어 있으면 브라우저에서 접근하여 변경할 위험
   //but, 즉시실행함수로 넣을 경우 onclick인라인 이벤트로 해당 함수객체에 접근할 수 없다
   
   (()=>{
	   
	   let confirmId = '';   //아이디 중복확인을 완료한 아이디 저장할 변수
	   let confirmNick = "";
	   let para = document.location.href.split("?");
	   console.log(para)
	   
			if(para[1] == "err=1") {
				let serviceCheck = document.querySelector('#chk1');
		  		let privacyCheck = document.querySelector('#chk2');
		  		console.log(serviceCheck)
		  		serviceCheck.checked = true;
		  		privacyCheck.checked = true;
		  	}
	   
	   document.querySelector('#btnIdCheck').addEventListener('click',() => {
		    
		    let userId = document.querySelector("#userId").value;
		    let idReg = /^[a-z]+[a-z0-9]{3,19}$/g;
		    
		    if(!idReg.test(userId)) {
		   	   document.querySelector('#idCheck').innerHTML = '<i class="fas fa-exclamation-circle"></i> 아이디는 영문자로 시작하는 4~20자 영문자 또는 숫자이어야 합니다.';
			   return;
           } else {
		   	   document.querySelector('#idCheck').innerHTML = '';
 		   }
			
			if(!userId){
				document.querySelector('#idCheck').innerHTML = '아이디를 입력하지 않았습니다.';
				return;
			}
	   		
			fetch("/member/id-check?userId=" + userId)
			.then(response => response.text())
			.then(text => {
				if(text == 'available'){
					confirmId = userId;
					document.querySelector('#idCheck').innerHTML = '사용 가능한 아이디 입니다.';
					return;
				}else{
					document.querySelector('#idCheck').innerHTML = '사용 불가능한 아이디 입니다.';
					document.querySelector('#userId').focus();
					return;
				}
			})
		});
		
		document.querySelector('#btnNickCheck').addEventListener('click', function(){
		  
		   let nickname = document.querySelector('#nickname').value;
		   let idReg = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
		   let spaceCheck = /\s/g;

		   if(!nickname){
			   document.querySelector('#checkNickname').innerHTML = '닉네임을 입력하지 않았습니다';
			   return;
		   }

		   if(!idReg.test(nickname)) {
		   	   document.querySelector('#checkNickname').innerHTML = '<i class="fas fa-exclamation-circle"></i> 닉네임은 2~20자로 설정해야합니다.';
			   return;
           } else {
		   	   document.querySelector('#checkNickname').innerHTML = '';
 		   }

		   if(spaceCheck.test(nickname)) {
		   	   document.querySelector('#checkNickname').innerHTML = '<i class="fas fa-exclamation-circle"></i> 공백으로 입력하셨습니다.';
			   return;
           } else {
		   	   document.querySelector('#checkNickname').innerHTML = '';
 		   }		      

		   fetch("/member/nick-check?nickname="+nickname)
		   .then(response =>{
				if(response.ok){
					return response.text()
				}else{
					throw new Error(response.status);
				}
			})
		   .then(text => {
				if(text == 'available'){
				   confirmNick = nickname;
				   document.querySelector('#checkNickname').innerHTML = '사용 가능한 닉네임 입니다.';
			   }else{
				   document.querySelector('#checkNickname').innerHTML = '사용 불가능한 닉네임 입니다.';
			   }
		   })
			.catch(error=>{
				 document.querySelector('#checkNickname').innerHTML ='응답에 실패했습니다  상태코드 : '+error;
			})
	   });
	   
	   
	   
	   	document.querySelector('#join').addEventListener('submit', function(e){
	   		let userId = document.querySelector("#userId").value;
	   		let nickname = document.querySelector('#nickname').value;
	   		let password = document.querySelector('#password').value;
	   		let passwordCheck = document.querySelector('#chkPwd').value;
	   		let serviceCheck = document.querySelector('#chk1');
		    let privacyCheck = document.querySelector('#chk2');
		    let userName = document.querySelector('#userName').value;
	   		
	   		let pwReg = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9])(?=.{8,})/;
	   		let regName = /^[가-힣a-zA-Z]+$/;
	   		
	   		if(!(serviceCheck.checked && privacyCheck.checked)){
			  alert('필수약관에 동의하지 않았습니다');
	 		  e.preventDefault();
		   }
		   
		     if(!pwReg.test(password)){
			  document.querySelector('#passwordReg').innerHTML = '<i class="fas fa-exclamation-circle"></i> 비밀번호는 숫자,영문,특수문자 조합의 8글자 이상인 문자열입니다'; 
		      document.querySelector('#password').focus();
			  e.preventDefault();
		   } else {
			  document.querySelector('#passwordReg').innerHTML = '';
		   }

		   if(password != passwordCheck) {
			  document.querySelector('#passwordDif').innerHTML = '<i class="fas fa-exclamation-circle"></i> 비밀번호가 일치하지 않습니다.';
			  document.querySelector('#chkPwd').focus();
			  e.preventDefault();
		   } else {
			  document.querySelector('#passwordDif').innerHTML = '';
		   }
	   		
	   		if(confirmId != userId){
	   			document.querySelector('#idCheck').innerHTML = '아이디 중복 검사를 하지 않았습니다.';
	   			document.querySelector('#userId').focus();
		   		e.preventDefault();	//기본이벤트 막기
	   		}
	   		
	   		if(confirmNick != nickname){
	   			document.querySelector('#checkNickname').innerHTML = '닉네임 중복 검사를 하지 않았습니다.';
	   			document.querySelector('#userId').focus();
		   		e.preventDefault();	//기본이벤트 막기
	   		}
	   		
	   		 if(!regName.test(userName)){
			   document.querySelector('#NameDif').innerHTML = '<i class="fas fa-exclamation-circle"></i> 이름은 한글 또는 영문 2~10글자인 문자열입니다';
			   document.querySelector('#userName').focus();
			   e.preventDefault();
		   } else {
			  document.querySelector('#NameDif').innerHTML = '';
		   }
	   		
/*	   		if(!pwReg.test(password)){
	   			e.preventDefault();
	   			document.querySelector('#pwCheck').innerHTML = '비밀번호는 숫자,영문,특수문자를 조합하여 8~16자를 입력하세요.';
	   		}
	   		
	   		if(!tellReg.test(tell)){
	   			e.preventDefault();
	   			document.querySelector('#tellCheck').innerHTML = '전화번호는 9~11자리의 숫자입니다.';
	   		}*/

	   	})

   })();


  