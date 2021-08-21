let toggleBtn = document.querySelector('.nav_toggleBtn');
let menu = document.querySelector('.menu');

toggleBtn.addEventListener('click',()=>{
  if(menu.classList.toggle('active')){
    document.querySelectorAll('div').forEach(e=>{
      e.style.opacity='0';

    })
  }else{
    document.querySelectorAll('div').forEach(e=>{
      e.style.opacity='1';
    })
  }

})


document.querySelectorAll('.menu>li').forEach(e=>{
  e.addEventListener('click',event =>{
    
    console.dir(event.target);
    let gnbNum = event.target.parentElement.dataset.gnb; 
    console.dir(gnbNum);


    document.querySelectorAll('.sub-menu').forEach((sub)=>{
      sub.style.display='none';
      if(sub.dataset.gnb == gnbNum){
        sub.style.display="flex";
      }
    })
  })
  
})


