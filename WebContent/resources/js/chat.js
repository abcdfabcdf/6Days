$(window).scroll(function(){
    var 윗여백 = 80;
    var scrollTop = $(document).scrollTop();
        if (scrollTop < 윗여백) {
        scrollTop = 윗여백-80;
        }
    $("#chatting").stop();
    $("#chatting").animate( { "top" : scrollTop+80 });
});