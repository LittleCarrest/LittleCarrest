'user strick'

$('.levelPage-contents-col').click(function(){
    $('.overlay-content').addClass('overlay-content-open')
    setTimeout(() => {
        $('.overlay-content').addClass('overlay-content-opacity')
    }, 400);
})

$('.close-overlay').click(function(){
    $('.overlay-content').removeClass('overlay-content-opacity')
    setTimeout(() => {
        $('.overlay-content').removeClass('overlay-content-open')
    }, 200);
})