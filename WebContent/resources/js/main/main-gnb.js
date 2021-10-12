(() => {

	let gnbTxt = document.querySelectorAll('.gnb-menu>li>a');
	let subTxt = document.querySelectorAll('.sub-menu>li>a');
	let header = document.querySelector('header');
	
	
	//스크롤시 sub-menu 감추기 + 상단고정메뉴 배경색 white
	document.addEventListener('scroll',()=>{
	
	  if(window.scrollY > 50){
	    header.style.backgroundColor='white';
	    header.style.transition='0.3s';
	    header.style.color='var(--text-color)';
	    document.querySelectorAll('.sub-menu').forEach((sub)=>{
	      sub.style.display='none';
	      sub.parentElement.style.backgroundColor='rgb(240, 240, 240)';
	    })
	    document.querySelectorAll('.gnb-main').forEach((e)=>{
	      e.style.color='var(--text-color)';
	    })
	    document.querySelectorAll('.user>a').forEach((e)=>{
	      e.style.color='var(--text-color)';
	    })
	    gnbTxt.forEach((gnb)=>{
	      gnb.addEventListener('mouseout', e => {
	        e.target.style.color = 'var(--text-color)';
	      })
	    })
		subTxt.forEach(e => {
			e.style.color='#555555';
		});
	  }else{
	    header.style.backgroundColor='';
	    header.style.color='';
	    document.querySelectorAll('.gnb-main').forEach((e)=>{
	      e.style.color='';
	    })
	    document.querySelectorAll('.sub-menu').forEach((sub)=>{
	      sub.style.display='none';
	      sub.parentElement.style.backgroundColor='';
	    })
	    document.querySelectorAll('.user>a').forEach((e)=>{
	      e.style.color='';
	    })
	    gnbTxt.forEach((gnb)=>{
	      gnb.addEventListener('mouseout', e => {
	        e.target.style.color = '';
	      })
	    })
	    subTxt.forEach(e => {
			e.style.color='#fff';
		});
	
	  }
	
	})
	
	
	//모바일 햄버거 메뉴
	document.querySelector('.nav-toggleBtn').addEventListener('click',()=>{
	  if(document.querySelector('.gnb-aside-menu').classList.toggle('active')){
	    document.querySelector('aside').style.left='0';
	  }else{
	    document.querySelector('aside').style.left='';
	  }
	
	})
	
	gnbTxt.forEach(gnb => {
	
	  //gnb 호버이벤트 : a태그 --point-color, sub-menu 나타나게
	  gnb.addEventListener('mouseenter', e => {
	    e.target.style.color = 'var(--point-color)';
	    let gnbNum = e.target.parentElement.dataset.gnb;
	
	    document.querySelectorAll('.sub-menu').forEach((sub) => {
	      if (sub.dataset.gnb != gnbNum || window.innerWidth < '768px') {
	        sub.style.display = 'none';
	      } else {
	        sub.style.display = "flex";
	      }
	    })
	
	  })
	  // 자동초기화 되는 상태
	  gnb.addEventListener('mouseout', e => {
	    e.target.style.color = '';
	  });
	
	  //gnb 클릭이벤트
	  gnb.addEventListener('click', event => {
	  
	    //gnb클릭 > --point-color 적용
	    event.target.style.color = 'var(--point-color)';
	
	
	  
	    let gnbNum = event.target.parentElement.dataset.gnb;
	  
	    document.querySelectorAll('.sub-menu').forEach((sub) => {
	      if (sub.dataset.gnb != gnbNum || window.innerWidth < '768px') {
	        sub.style.display = 'none';
	
	      } else {
	        sub.style.display = "flex";
	        
	      }
	    })
	  })
	
	})
	
	
	

  


})();