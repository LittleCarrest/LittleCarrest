let gnbTxt = document.querySelectorAll('.gnb-menu>li>a');


//스크롤시 sub-menu 감추기
document.addEventListener('scroll',()=>{
  if(window.scrollY > 50){
    document.querySelectorAll('.sub-menu').forEach((sub)=>{
      sub.style.display='none';
    })
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
  gnb.addEventListener('mouseout', e => {
    e.target.style.color = '#555555';
  })

  //gnb 클릭이벤트
  gnb.addEventListener('click', event => {
    //초기화
    gnbTxt.forEach(e => {
      e.style.color='#555555';
    })
  
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




  

