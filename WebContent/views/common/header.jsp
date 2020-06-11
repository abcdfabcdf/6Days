<%@page import="com.sixdays.userMember.model.vo.userMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
    <%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함
    
    HttpSession session = request.getSession();
 
    
   userMember m = (userMember)session.getAttribute("member");
    
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>

   <script src="/6Days/resources/js/sidebar.js"></script>
    <script src="/6Days/resources/js/jquery-3.4.1.min.js"></script>
    <script src="/6Days/resources/js/jquery-ui-1.11.4.custom.min.js"></script>
    <script src="/6Days/resources/js/Right_sidebar.js"></script>
    <script src="/6Days/resources/js/Infadd.js"></script>
    
    <script src="https://unpkg.com/vue@2.6.6/dist/vue.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/6Days/resources/css/sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/Right_sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/main.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Infadd.css">
    <link rel="stylesheet" href = "/6Days/resources/css/MainContact.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Scrollbar.css">
    <link rel="stylesheet" href = "/6Days/resources/css/main-header.css">

<style>
   #titleImgArea,#contentImgArea1,#contentImgArea2,#contentImgArea3
   ,#contentImgArea4,#contentImgArea5{
   vertical-align:middel;
   cursor:pointer;
   border:2px dashed darkgray;
   disaply:table-cell;
}
</style>
</head>

<body>
  
<!--작성자 : 이서현,박주완
    작성일 : 2020.1.14 시작
    내용 : 메인 로고 딴따라
    수정일 : 
   -->
    <header>
        <div id="top1" class="top">
            <img id="logo" src="/6Days/resources/icon/logoletter.png" onclick="location.href='/6Days/main.me'">


<!--  작성자 : 윤석훈,박주완
      작성일 : 2020.02.03 
      내용 : 검색창 구현
     수정일 : -->

            <div id="headersearch" >
                 <input id="searchInput" onkeydown="javascript:if(event.keyCode==13){search();}" type="text" placeholder="닉네임을 입력해주세요.">
            </div>
     
                  <input type="hidden" id="userId" name="userId" value="<%=m.getUserId() %>">


            <img id="loca" class="top-btn" src="/6Days/resources/icon/UPloadbtn.png"  title="게시글추가" onclick="Infopen();" style="margin-left: 265px;">
            <img id="mg" class="top-btn" src="/6Days/resources/icon/4.png" title="마이페이지" onclick="myPage();">
            <img id="myp" class="top-btn" src="/6Days/resources/icon/outbtn.png" title="로그아웃" onclick="logout();">
            
<!--    작성자 : 이서현, 신경섭 , 박주완
        작성일 : 2020.1.14 시작
          내용 : 게시물 업로드  
         수정일 : 2020.02.19
         -->
     <form action="/6Days/pbInsert.bo" method="POST" enctype="multipart/form-data">
       <div id="Infmodal">
           <div id="Infcontent">
               <div id="Infmenu">
                   <label style="font-size: 1.8em; margin-top: 0;">&nbsp; &nbsp;게시글 업로드<button id="Infclosebtn" onclick="return Infclose();">X</button></label>
               </div>
               <hr style="width: 650px; float: left;">
               <div id="Infleft">
                  <table style="text-align: center; width:100%; height:100%;">
                     <tr>
                        <td>
                           <div id="titleImgArea" class="ImgArea0">
                              <img id="titleImg" class="titleImg0">
                           </div>
                        </td>
                        <td>
                           <div id="contentImgArea1" class="ImgArea0">
                              <img id="contentImg1" class="titleImg0" >
                           </div>
                        </td>
                        <td>
                           <div id="contentImgArea2" class="ImgArea0">
                              <img id="contentImg2" class="titleImg0">
                           </div>
                        </td>
                     </tr>
                     
                     
                     <tr>
                        <td>
                           <div id="contentImgArea3" class="ImgArea0">
                              <img id="contentImg3" class="titleImg0" >
                           </div>
                        </td>
                        <td>
                           <div id="contentImgArea4" class="ImgArea0">
                              <img id="contentImg4" class="titleImg0" >
                           </div>
                        </td>
                        <td>
                           <div id="contentImgArea5" class="ImgArea0" style="!important">
                              <img id="contentImg5" class="titleImg0">
                           </div>
                        </td>
                     </tr>
                  </table>
                  
                  <input type="hidden" name="userId" value="<%=m.getUserId() %>">


                  
                  
                  <div class="fileArea" id="fileArea">
                  <input type="file" id="thumbnailImg1"
                        name="thumbnailImg1" accept="image/*" onchange="loadImg(this, 1);" />
                        
                  <input type="file" id="thumbnailImg2"
                        name="thumbnailImg2" accept="image/*" onchange="loadImg(this, 2);" />
                        
                  <input type="file" id="thumbnailImg3"
                        name="thumbnailImg3" accept="image/*" onchange="loadImg(this, 3);" />
                        
                  <input type="file" id="thumbnailImg4"
                        name="thumbnailImg4" accept="image/*" onchange="loadImg(this, 4);" />
                        
                  <input type="file" id="thumbnailImg5"
                        name="thumbnailImg5" accept="image/*" onchange="loadImg(this, 5);" />
                        
                  <input type="file" id="thumbnailImg6"
                        name="thumbnailImg6" accept="image/*" onchange="loadImg(this, 6);" />
               </div>
                  
                  
               </div>      
  
                <div id="userinfo">
                   <div id="userimgbox">

                       <img id="userimg" name="profileimg" src="/6Days/resources/proimgUploadFiles/<%= m.getProimg() %>" onclick="profileModalOpen();" >

                   </div>
                   <div id="userName0">
                       <label id="username" class="profile"><%=m.getUserName() %></label>            
                   </div>
                </div>                      
                      
                                           
               <div id="Infright">
                   <textarea id="Infcomment" name="Infcomment" placeholder="오늘 하루를 기록해 보세요"></textarea>
                   <textarea id="Infhashtag" name="Infhashtag" placeholder="#태그"></textarea>
                   <button id="Infupload" name="Infupload" onclick="return up()">올리기</button>
                </div>
                
                <div>
                    
                    
                </div>
                
            </div>
        </div>
    </form>
</div>
  </header>
</body>
<script>

function search() {
	var result = document.getElementById('searchInput').value;
    location.href="/6Days/usersearch.me?result="+result;
}

$('#Infadd')
.on("dragover", dragOver)
.on("dragleave", dragOver)
.on("drop", uploadFiles);

function dragOver(e){
e.stopPropagation();
e.preventDefault();
}

function uploadFiles(e){
e.stopPropagation();
e.preventDefault();
}

function dragOver(e) {
    e.stopPropagation();
    e.preventDefault();
    if (e.type == "dragover") {
        $(e.target).css({
            "background-color": "black",
            "outline-offset": "-20px"
        });
    } else {
        $(e.target).css({
            "background-color": "gray",
            "outline-offset": "-10px"
        });
    }
}

function uploadFiles(e) {
    e.stopPropagation();
    e.preventDefault();
    dragOver(e); //1
 
    e.dataTransfer = e.originalEvent.dataTransfer; //2
    var files = e.target.files || e.dataTransfer.files;
 
    if (files.length > 1) {
        alert('하나만 올려라.');
        return;
    }
    if (files[0].type.match(/image.*/)) {
        
    }else{
        alert('이미지가 아닙니다.');
        return;
    }

    if (files[0].type.match(/image.*/)) {
        $(e.target).css({
            "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
            "outline": "none",
            "background-size": "100% 100%"
        });
    }else{
      alert('이미지가 아닙니다.');
      return;
    }

}
   function logout(){
      if(confirm("로그아웃 하시겠습니까?")){
         location.href="/6Days/logout.me";
      }
      
      
   }
   
      /* var uploadApp = new Vue({
           el: '#Infleft',
           data:{
               fileList:[]
           }
       })
       $("#uploadFile").change(function(event){
           console.log($(this)[0].files);
           var files=$(this)[0].files;
           uploadApp.fileList =[];

           $.each(files,function(i,item){
               var fileReader = new FileReader();
               fileReader.onload=function(e){
                   var img ={
                       url:e.target.result,
                       name:item.name,
                       // size:item.size
                   };
                   uploadApp.fileList.push(img);
               }
               fileReader.readAsDataURL(item);
           });
       }); */

</script>
<script>
//사진 게시판 미리보기 기능 지원 스크립트
$(function(){
   $('#fileArea').hide();
   
      
   $('#titleImgArea').click(() => {
      $('#thumbnailImg1').click();
      
   });

      
   $('#contentImgArea1').click(() => {
      $('#thumbnailImg2').click();
   });
   
   $('#contentImgArea2').click(() => {
      $('#thumbnailImg3').click();
   });

   $('#contentImgArea3').click(() => {
      $('#thumbnailImg4').click(); 
   });
    
   $('#contentImgArea4').click(() => {
      $('#thumbnailImg5').click();
   });
    
   $('#contentImgArea5').click(() => {
      $('#thumbnailImg6').click();
   });
});

function loadImg(value, num){
   
   if(value.files && value.files[0])  {
      
      var reader = new FileReader();
      
      reader.onload = function(e){
         
         switch(num) {
         case 1 : $('#titleImg').attr('src', e.target.result);
            break;
         case 2 : $('#contentImg1').attr('src', e.target.result);
            break;
         case 3 : $('#contentImg2').attr('src', e.target.result);
            break;
         case 4 : $('#contentImg3').attr('src', e.target.result);
            break;
         case 5 : $('#contentImg4').attr('src', e.target.result);
            break;
         case 6 : $('#contentImg5').attr('src', e.target.result);
            break;
         }
      }
      reader.readAsDataURL(value.files[0]);
   }
}

//메인이미지 첨부 안했을시 alert 창 띄우기

</script>
<script>
function up(){
   console.log(document.getElementById('thumbnailImg1').src);
   
   if(document.getElementById('titleImg').src == ""){
      alert('첫번째 이미지를 넣어주세요 ! ');
      return false;
   }else if(document.getElementById('titleImg').src != ""){
      return true;
   }
}
</script>

<script>
function myPage(){
      

      var userId= document.getElementById('userId').value;
      location.href="/6Days/pbSelect.bo?userId="+ userId;
      
   
}
</script>
</html>