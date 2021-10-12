
   //변수가 전역변수에 선언되어 있으면 브라우저에서 접근하여 변경할 위험
   //but, 즉시실행함수로 넣을 경우 onclick인라인 이벤트로 해당 함수객체에 접근할 수 없다
   
   (()=>{
	   
	   let confirmId = '';   //아이디 중복확인을 완료한 아이디 저장할 변수
	   
	   document.querySelector('#btnIdCheck').addEventListener('click',() => {
			let userId = document.querySelector("#userId").value;
			
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
				}else{
					document.querySelector('#idCheck').innerHTML = '사용 불가능한 아이디 입니다.';
				}
			})
		});
	   
	   
	   
	   	document.querySelector('#frm_join').addEventListener('submit', function(e){
	   		let userId = document.querySelector("#userId").value;
	   		let password = document.querySelector('#password').value;
	   		let pwReg = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9])(?=.{8,})/;
	   		let tell = document.querySelector('#tell').value;
	   		let tellReg = /^\d{9,11}$/;
	   		
	   		if(confirmId != userId){
	   			document.querySelector('#idCheck').innerHTML = '아이디 중복 검사를 하지 않았습니다.';
	   			document.querySelector('#userId').focus();
		   		e.preventDefault();	//기본이벤트 막기
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


  