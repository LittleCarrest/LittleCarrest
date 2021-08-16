let wrContent = document.querySelector('.wr-slides');


function moveSlide(num){
  wrContent.style.left = -num * 290 + 'px';
  wrContent.style.transition = '0.5s ease-in-out';
}

let cnt = 0;

document.querySelector('#arrow-r').addEventListener('click',(e)=>{
  cnt++;
  if(cnt>3){
    cnt = 0;
  }
  moveSlide(cnt);

});
document.querySelector('#arrow-l').addEventListener('click',(e)=>{
  cnt--;
  if(cnt<0){
    cnt = 3;
  }
  moveSlide(cnt);
});
