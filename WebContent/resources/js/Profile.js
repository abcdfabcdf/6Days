
// <!--    작성자 : 박주완
//         작성일 : 2020-01-14
//         내용 : 자신의프로필에서 세팅 버튼 클릭시 모달창 온오프기능-->
            function settingbtn(){
                var ulr = $(this).attr("src");
                $("#setting").attr("src",ulr);
                $("#setting").show();
            }

            function settinglistclose(){
                $('#setting').css("display",'none');
            }
    
// <!--    작성자 : 박주완
//         작성일 : 2020-01-14
//         내용 : 프로필 세팅 변경 모달 온오프 기능-->
            function profileModalOpen(){
                var ulr = $(this).attr("src");
                $("#profileModal").attr("src",ulr);
                $("#profileModal").show();
            }

            function profileModalClose(){
                $('#profileModal').css("display",'none');
            }

// <!--    작성자 : 박주완
//         작성일 : 2020-01-16
//         내용 : 공개범위 및 보안 클릭시 모달 온오프 -->
            function PublicScopeModal(){
                var url = $(this).attr("src");
                $("#Public_Scope_Modal").attr("src",url);
                $("#Public_Scope_Modal").show();
            }

            function PublicScopeModalclose(){
                $('#Public_Scope_Modal').css("display",'none');
            }

// <!--    작성자 : 박주완
//         작성일 : 2020-01-16
//         내용 : 코멘트 변경 모달 로직-->
        function comentsetopen(){
            var url = $(this).attr("src");
            $("#comentSetModal").attr("src",url);
            $("#comentSetModal").show();
        }

        function comentsetclose(){
            $('#comentSetModal').css("display",'none');
        }

// <!--    작성자 : 박주완
//         작성일 : 2020-01-16
//         내용 : 코멘트 변경 함수-->
        function comentInput() {
            var coment = document.getElementById('memo');
            var resetcoment = document.getElementById("comenttextarea");
            coment.innerHTML = " ";
            coment.innerHTML += resetcoment.value;
        }

// <!--    작성자 : 박주완
//         작성일 : 2020-01-16
//         내용 : 닉네임 변경 모달 로직-->
            function nameSetopen(){
                var url = $(this).attr("src");
                $("#nameSetModal").attr("src",url);
                $("#nameSetModal").show();
            }
    
            function nameSetclose(){
                $('#nameSetModal').css("display",'none');
            }
    
//// <!--    작성자 : 박주완
////         작성일 : 2020-01-16
////         내용 : 닉네임 변경 함수-->
//            function nameInput() {
//                var name = document.getElementById('name');
//                var resetname = document.getElementById("nametextarea");
//                name.innerHTML = " ";
//                name.innerHTML += resetname.value;
//            }
            
         // <!--     작성자 : 신지영
//          작성일 : 2020-02-13
//          내용 : 프로필 사진 변경 함수-->
            function proImgChange(){
                var url = $(this).attr("src");
                $("#proImgModal").attr("src",url);
                $("#proImgModal").show();
            }

            function proimgSetclose(){
                $('#proImgModal').css("display",'none');
            }
            
            // <!--     작성자 : 신지영
//          작성일 : 2020-02-16
//          내용 : 프로필배경 사진 변경 함수-->
            function proBackChange(){
                var url = $(this).attr("src");
                $("#proBackModal").attr("src",url);
                $("#proBackModal").show();
            }

            function probackSetclose(){
                $('#proBackModal').css("display",'none');
            }
            
            
            
            
            

