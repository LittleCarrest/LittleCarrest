
   //변수가 전역변수에 선언되어 있으면 브라우저에서 접근하여 변경할 위험
   //but, 즉시실행함수로 넣을 경우 onclick인라인 이벤트로 해당 함수객체에 접근할 수 없다
   
   (()=>{
	   
	   document.querySelector('.spring').addEventListener('click',() => {
		    
			fetch("/member/spring")
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
		
   })();


  