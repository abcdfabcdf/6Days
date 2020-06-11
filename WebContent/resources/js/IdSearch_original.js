$(function() {
    //초기 상태
    $('#inputPhone').hide();
    $('#inputEmail').hide();
    
    //toggle 직접 구현
    var check = false;

    $('#titlePhone').click(function() {

      $('.typeList').attr('class','typeList current');


        console.log(check);

        if(check) {
            $('#inputPhone').hide();
        }else {
            $('#inputPhone').show();
        }

        if(!check) {
          $('.typeList').removeClass('current');
        }

        check = !check;


    });

    $('#titleEmail').click(function() {
        console.log(check);

        if(check) {
            $('#inputEmail').hide();
        }else {
            $('#inputEmail').show();
        }

        if(!check) {
          $('.typeList').removeClass('current');
        }

        check = !check;
    });
  
});

// 아이디 찾기 -> 등록된 휴대폰으로 찾기  
$(function() {
    $('#inputHp').keyup(function() {
        // //왼쪽 취소 버튼 생성
        $('.delBtnPh').css('display','block');

        //숫자만 입력받도록 체크하기
        //숫자 11자리 이상 입력시 체크하기
        //휴대폰번호 
        var regExp = /^[0-9]{1,}$/;

        if(!regExp.test($(this).val())) {
            $('.error').html("숫자만 입력해야 합니다.").css('display','block')
        }else if (($(this).val()).length > 11) {
            $('.error').html("잘못된 형식입니다.").css('display','block')
        }

        $('.delBtnPh').click(function() {
            $('.delBtnPh').css('display','none');
            $('#inputHp').val('');
            $('.error').css('display','none')
        });
    });

    
});
