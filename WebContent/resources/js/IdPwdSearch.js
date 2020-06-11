///*-- 작성자 : 박주완
//   * 작성일 : 2020.01.14
//   * 내용 : 아이디찾기 / 비밀번호찾기 
//   * 수정일 : 2020.02.17
//*/
////////////////////////////////아이디 / 비밀번호  찾기 화면//////////////////////////////// 
//// 등록된 휴대폰 번호로 찾기  
//$(function() {
//    $('#inputPhone').keyup(function() {
//        // input에 키보드 입력시 왼쪽 취소 버튼 생성
//        $('#inputPhoneClear').css('display','block');
//
//        //숫자만 입력받도록 유효성 체크하기
//        //숫자 12자리 이상 입력시 에러 메시지
//        var regExp = /^[0-9]{1,11}$/;
//
//        if(!regExp.test($(this).val()) || ($(this).val()).length > 11) {
//            $('#errorPhone').html("잘못된 휴대폰번호 형식입니다.(-없이 입력)").css('display','block');
//        }else if ($(this).val() == null ||
//                  $(this).val() == '') {
//                  $('#errorPhone').html("휴대폰번호를 입력해주세요").css('display','block');
//        }
//
//        //취소버튼 클릭시 초기화
//        $('#inputPhoneClear').click(function() {
//            $('#inputPhoneClear').css('display','none');
//            //경고문구 없애기 고민중
//            $('#errorPhone').css('display','none');
//            $('#inputPhone').val('').focus();
//            return;
//        });
//    });
//});
//  
////등록된 이메일로 찾기 
//$(function() {
//    $('#inputEmail').keyup(function() {
//        // input에 키보드 입력시 왼쪽 취소 버튼 생성
//        $('#inputEmailClear').css('display','block');
//
//        //취소버튼 클릭시 초기화
//        $('#inputEmailClear').click(function() {
//            $('#inputEmailClear').css('display','none');
//            //경고문구 없애기 고민중
//            $('#errorEmail').css('display','none');
//            $('#inputEmail').val('').focus();
//            return;
//        });
//    });
//    
//    //확인 버튼 이벤트
//    $('#idEmailSearch').click(function() {
//        //Email 정규식 - 이메일 유효성 검사
//        var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z]?)*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z]?)*\.[a-zA-Z]{2,3}$/i;
//
////        if(!regExp.test($('#inputEmail').val())) {
////            $('#inputEmailClear').css('display','none');
////            $('#inputEmail').val('');
////            $('#errorEmail').html("이메일 형식에 어긋납니다").css('display','block');
////            $('#inputEmail').focus();
////        }else if($('#inputEmail').val() == null ||
////                 $('#inputEmail').val() == '' ||
////                 $('#inputEmail').attr('placeholer')) {
////                 $('#errorEmail').html("이메일을 입력해주세요.").css('display','block');
////                 $('#inputEmail').focus();
////        }else{
////            $('#inputEmailClear').css('display','none');
////            $('#inputEmail').val('').focus();
////           $('#errorEmail').css('display','none');
////            
////        }
//    });
//});
//
////////////////////////////////아이디 / 비밀번호 찾기 결과 -> 전체 확인하기//////////////////////////////// 
////라디오버튼 클릭 이벤트
//$(function() {
//    $('#radioId').click(function() {
//        $('.allResult').css('display','block');
//    });
//});

//로그인 버튼 링크
function openerLogin(){
    if (window.opener && !window.opener.closed) //부모창이 존재하고 닫혀있지 않을때
    window.opener.location.href = "/6Days/login.jsp"; // 부모창에서 이동할 주소
    window.close();
}
 