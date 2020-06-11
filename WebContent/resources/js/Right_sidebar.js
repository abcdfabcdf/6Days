function Initializerightsidebar(){
    var duration = 300;

    var $sidebar = $('#right_sidebar');
    var $sidebarButton = $sidebar.find('button').on('click', function(){
        $sidebar.toggleClass('메신저');
        if($sidebar.hasClass('메신저')){
            $sidebar.stop(true).animate({right: '-70px'}, duration, 'easeOutBack');
            $sidebarButton.find('span').text('닫기');
        }else{
            $sidebar.stop(true).animate({right: '-490px'}, duration, 'easeInBack');
            $sidebarButton.find('span').text('메신저');
        };
    });
}