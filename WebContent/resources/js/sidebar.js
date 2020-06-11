function InitializeStaticMenu(){
    var duration = 300;

    var $sidebar = $('.sidebar');
    var $sidebarButton = $sidebar.find('button').on('click', function(){
        $sidebar.toggleClass('open');
        if($sidebar.hasClass('open')){
            $sidebar.stop(true).animate({left: '-70px'}, duration, 'easeOutBack');
            $sidebarButton.find('span').text('닫기');
        }else{
            $sidebar.stop(true).animate({left: '-285px'}, duration, 'easeInBack');
            $sidebarButton.find('span').text('메뉴');
        };
    });
}
