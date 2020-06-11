<%@page import="com.sixdays.maincomment.model.vo.*" %>
<%@page import="com.sixdays.p_board.model.vo.p_Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sixdays.userMember.model.vo.userMember"%>
<%@ page import="com.sixdays.like.model.dao.LikeDao"%>
<%@page import="com.sixdays.like.model.vo.Like"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
  
<%
	ArrayList<p_Board> list = (ArrayList<p_Board>)request.getAttribute("list"); 
	ArrayList<MainComment> mlist = (ArrayList<MainComment>)request.getAttribute("mlist");
	

	int result = 1;
	int report1 = 0;
	boolean like = true;
	int count = 0;
	String pwriter129 = "";
	String reporter = "";

%>
    
<!DOCTYPE html>
<html>
<head>
	<title>Main</title>

	<%@ include file="views/common/header.jsp" %>
	<%@ include file="views/common/left-sidebar.jsp" %>
	<%@ include file="views/common/right-sidebar.jsp" %>
    <link rel="stylesheet" href = "/6Days/resources/css/MainContact.css">
</head>

<body>
<input type="hidden" id="sessionid" name="sessionid" value="<%=m.getUserId()%>">    
<!--    작성자 : 박주완
        작성일 : 2020-01-14
        수정일 : 2020-01-17
        내용 : 메인화면 컨텐츠섹션 수정 -->
        
        <div id="contentArea">  <!--컨텐츠가 출력될 중앙 영역 (길이값 무한대) -->
			<table align="center" id="pnocheck">
				<% for(p_Board pb : list) { %>
					<tr>
						<td>
							<div id="content">  <!--실제 컨텐츠 각각의 영역 -->
								<div id="userNamebar">  <!--컨텐츠 상단의 유저 프로필사진과 닉네임, 신고버튼 표시 부분-->
									<img id="showUserProfileImg" src="/6Days/resources/proimgUploadFiles/<%=pb.getPproimg()%>">  <!--유저 프로필 이미지 불러오기-->
									<input type="hidden" name="pnosi" value="<%=pb.getPbno() %>">
									<input type="hidden" name="userid33" value="<%=pb.getPbwriter()%>">
									<label id="showUserName"><%= pb.getPnickname() %></label>    <!--유저이름, 나중에 쿼리문작성하여 로그인한 계정의 이름 , 프로필사진 불러오기-->
									<p id="contentSettingbtn" onclick="postModalOpen();" >...</p>
								</div>  <!-- userNamebar end -->
								
								<div id="contentMemo" name="comentMent">  <!--컨텐츠 이미지 바로 위 컨텐츠 내용 부분-->
									<%= pb.getPcontent()%>
										<br>
									<%= pb.getHashtag()%>
										<br>
								</div>  <!-- contentMemo end -->
								
								<div id="contentimg" >   <!-- 컨텐츠의 이미지 영역 & css에서 이미지 넣어줌 background-imgage 로  -->
									<div class="slideshow-container" >
										<div class="mySlides fade" style="display: block;">
											<div class="numbertext"></div>
											<input type="hidden" name="pnobar" value="<%=pb.getPbno() %>">
											<img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pb.getPhoto1() %>" style="width:100%;">
										</div>  <!-- mySlides fade end -->
									</div>  <!-- slideshow-container end -->
								</div>  <!-- contentimg end -->
							
								<div id="contentMenu"> <!-- 좋아요버튼, 좋아요수, 글쓴시간 등을 표현할 영역  -->
									
									<img src="/6Days/resources/icon/whitesmile.png" style="width: 50px; height: 50px; float: left; margin: 0; margin-top: -2%; margin-left: -1%;" id="whitesmile" >
									
									<input type="hidden" id="likecheck" value="<%=pb.getPbno() %>">
									<input type="hidden" id="likeid" value="<%=m.getUserId()%>">
									<input type="hidden" id="likeno" value="1">
		
									<div name="username1" style="font-size: 16px; color: gray; float: left; margin: 0; margin-left: 10px;">게시물을  '</div>
									<div name="likecount" id="likecheck2" style="font-size: 16px; color: black; float: left; margin: 0;"></div>
									<div style="font-size: 16px; color: gray; float: left; margin: 0;"> '명이 Like합니다.</div>
									<div name="comentCount" style="font-size: 14px; color: gray; float: right; margin: 0; margin-right: 15px;">댓글</div>
								</div>  <!-- contentMenu end -->
							
								<div id="contentComment">
									<% for(MainComment mc : mlist) { 
										if(mc.getPbno() == pb.getPbno()) { %>
										<div style="background-color: whitesmoke; margin-bottom: 10px; padding: 5px; border-radius: 15px;">
									    <label id="testcheck" style="color:skyblue; font-size:17px;"><%= mc.getMnickname() %></label> : 
									    <label style="font-size:15px;"><%= mc.getMcontent() %></label>
									    <input type="hidden" name="pnosi2" value="<%=mc.getPbno() %>">
									    <input type="hidden" name="userid332" value="<%=mc.getMnickname()%>">
									    <label style="font-size: 12px; float: RIGHT; margin-top: 5px;"><%= mc.getMdate() %></label>
									    </div>
									<% }
										
									
									} %>
									</div>  <!-- contentComment end -->
							
								<hr style="margin: 5px;">
								<input type="hidden" name="mpbno" value="<%= pb.getPbno() %>">
								<input type="hidden" id="mmo" name="mno" value="1">
								<input type="hidden" id="mwriter" name="mwriter" value= "<%= m.getUserId() %>">
								<input type="hidden" id="mnickname" name="mnickname" value= "<%= m.getUserName() %>">
								<input id="sendcomment" name="mcontent" type="text" placeholder="댓글달기..." style="width: 85%; border: none;">
								<input type="button" id="mcommentbtn" style="width: 6%; height: 10%; background-color: white; border: white; font-family: 'Jua', sans-serif; font-size: 15pt; outline:0; cursor:pointer;"  value="확인">
							</div>  <!-- content end -->
							<br><br><br><br><br>
						</td>
					</tr>
				<%
			
				} %>
			</table>
        </div>

<!--    작성자 : 박주완
        작성일 : 2020-02-04
        내용 : 포스트 [...] 버튼 클릭시 모달창 오픈 -->
        <div id="postModal">
            <div id="postModalSet">
                <p style="color: red; cursor:pointer;" id="reportcheck" >부적절한 게시물 신고</p><hr>
                <p style="color: red; cursor:pointer;">팔로우 취소</p><hr>
                <p onclick="postModalClose();" style="cursor:pointer;">닫기</p>
            </div>
        </div>

<!--    작성자 : 박주완
        작성일 : 2020-01-21
        내용 : 5초마다 변하는 우측 사이드 배너광고창 -->
        <div class="advertising" >
            <img class="advertising" src="resources/images/1.JPG">
        </div>



    <script>
 		$('#pnocheck td #mcommentbtn').click(function(){		//확인버튼
 			
 			var test1 = $(this).parent().find('div[id=contentComment]');
 			var test = $(this).parent().find('input[id=sendcomment]');
 			 			
 			if(test.val() != "") {
 			pbno = 	$(this).parent().find('input[name=mpbno]').val();
 			console.log("pbno : " + $(this).parent().find('input[name=mpbno]').val());
 			
	       $.ajax({
	    	   url:"/6Days/InsertComment.mo",
	    	   type: "post",
	    	   data:{ 
	    		   pbno : $(this).parent().find('input[name=mpbno]').val(),
	    		   mno : $('#pnocheck td #mmo').val(),
	    		   mwriter : $(this).parent().find('input[id=mwriter]').val(),
	    		   mcontent : $(this).parent().find('input[id=sendcomment]').val(),
	    		   mnickname : $(this).parent().find('input[name=mnickname]').val()
	    	   },
	    	   success:function(result){

	    		  $('#pnocheck td #sendcomment').val('');
	    		 
	    		  
	    		  location.reload();

	    	   }, 
	    	   error:function(result){
	    		   alert("실패");
	    	   
	    	   }
	       });
 			}
		});
    </script>



	<script>
	//좋아요 기능 구현 중--------------------------------------------------------------

		var like=true;
		
		  $('#pnocheck td img[id=whitesmile]').click(function(){
	
		if(like){
			
        $.ajax({
        	
	    	   url:"/6Days/likecheck.me",
	    	   type: "post",
	    	   async: false,
	    	   data:{ 
	    		   pbno : $(this).parent().find('input[id=likecheck]').val(),
	    		   userid : $(this).parent().find('input[id=likeid]').val(),
	    		   lno : $(this).parent().find('input[id=likeno]').val(),

	    	   },
	    	   success:function(result){
	    		   count = result;
	    			
	    		
				like =false;

	    	   }, 
	    	   error:function(result){
	    		   alert("실패");
	    	   
	    	   }

			
	       });
        $('#pnocheck td div[id=likecheck2]').html(count);
		 //$(this).html('<img src="/6Days/resources/icon/yellowsmile.png" style="width: 50px; height: 50px; float: left; margin: 0; margin-top: -2%; margin-left: -1%;" id="whitesmile1" >')
		  $(this).attr('src','/6Days/resources/icon/yellowsmile.png');
		 	return false;
			}else{
				
			        $.ajax({
				    	   url:"/6Days/likecheckN.me",
				    	   type: "post",
				    	   async: false,
				    	   data:{ 
				    		   pbno : $(this).parent().find('input[id=likecheck]').val(),
				    		   userid : $(this).parent().find('input[id=likeid]').val(),
				    		   lno : $(this).parent().find('input[id=likeno]').val(),

				    	   },
				    	   success:function(result){
				    		   
				    		 count=result;
							like=true;
							
							
							

				    	   }, 
				    	   error:function(result){
				    		   alert("실패");
				    	   
				    	   }
				       });

						//$(this).html('<img src="/6Days/resources/icon/whitesmile.png" style="width: 50px; height: 50px; float: left; margin: 0; margin-top: -2%; margin-left: -1%;" id="whitesmile" >')
					  	$('#pnocheck td div[id=likecheck2]').html(count);
						$(this).attr('src','/6Days/resources/icon/whitesmile.png');
						return false;
					
					
				
				
			}
		
		  });

	
	

		
/* 				
		  $('#pnocheck td img[id=whitesmile]').click(function(){
		if(!like){
        $.ajax({
	    	   url:"/6Days/likecheckN.me",
	    	   type: "post",
	    	   data:{ 
	    		   pbno : $(this).parent().find('input[id=likecheck]').val(),
	    		   userid : $(this).parent().find('input[id=likeid]').val(),
	    		   lno : $(this).parent().find('input[id=likeno]').val(),

	    	   },
	    	   success:function(result){
	    		   
	    		  alert("좋아요 수 : "  + result);
				like=true;

	    	   }, 
	    	   error:function(result){
	    		   alert("실패");
	    	   
	    	   }
	       });

			//$(this).html('<img src="/6Days/resources/icon/whitesmile.png" style="width: 50px; height: 50px; float: left; margin: 0; margin-top: -2%; margin-left: -1%;" id="whitesmile" >')
		  $(this).attr('src','/6Days/resources/icon/whitesmile.png');
			return false;
		
		}
		  
		  }); */
  
// ------------------------------------------------------------------------------------
 
// <!--    작성자 : 박주완
//        	 작성일 : 2020-01-23
//        	  내용 : 광고배너-->
	
            var arr = new Array();
            
            arr[0] ="arr1임"
            arr[1] ="arr2임"
            arr[2] ="arr3임"
            arr[3] = "<a href='http:// 이동할 광고주 사이트'target = _new><class='advertising' src='/6Days/resources/advertising/4.JPG></a>;"
            // arr[4] = "<a href='http:// 이동할 광고주 사이트'target = _new><class='advertising' src='/6Days/resources/advertising/5.JPG></a>;"
            var num = 0; /* 바꿀 화면 넘버 기본값*/

            //window.onload = function(){ /*윈도우 온로드로 시간초 경과 체크*/
            //    setInterval(update(),5000);
           // }

         /*    function update(){
                num++;
                console.log(arr[num]);                
                if(num == arr.length) num=0;
            } */


/*    <!--  작성자 : 박주완
        작성일 : 2020-02-03
        내용 : 사용자 게시물 좌우로 이미지 슬라이드쇼 쿼리문  --> */
      

// <!--    작성자 : 박주완
//         작성일 : 2020-02-04
//         내용 : 포스트 [...]버튼 클릭시 모달창 온오프 코드-->
            function postModalOpen(){
                var ulr = $(this).attr("src");
                $("#postModal").attr("src",ulr);
                $("#postModal").show();
            }

            function postModalClose(){
                $('#postModal').css("display",'none');
            }

        </script>
        
        <!--         작성자 : 박주완
        작성일 : 2020-02-21
	내용 : 게시물 이미지 클릭시 비동기방식으로 게시물 상세보기 팝업 오픈 -->
<!--********************************************** 게시물 상세보기 팝업  **********************************************-->              
       <script> 
          $(function(){
             $('#pnocheck td img[class=contentimgs]').click(function(){
                var test = $(this);
                var url = "imageServlet.me?pbno="+ $(this).parent().find('input[name=pnobar]').val();
                				 
                  w = 630; //팝업창의 너비
                   h = 630; //팝업창의 높이
                   
                   //중앙위치 구해오기
                   LeftPosition=(screen.width-w)/2;
                   TopPosition=(screen.height-h)/2; 
                    
                               
                   window.open(url,'상세보기',"width="+w+"px,height="+h+"px,top="+TopPosition+",left="+LeftPosition+',status=no,location=no');
                
             });
          });
       
         
             
         function modalclose(){
             $('#modal').css("display","none");
         }
         
         $(function(){
             $('#pnocheck td label[id=showUserName]').click(function(){
                var pnocheck = $(this);
                location.href= "/6Days/userprofile.bo?pbno="+ $(this).parent().find('input[name=pnosi]').val() + "&userid="+$(this).parent().find('input[name=userid33]').val() ;
                
                
             });
          });
         
         $(function(){
             $('#pnocheck td label[id=testcheck]').click(function(){
                var pnocheck = $(this);
                location.href= "/6Days/userprofile.bo?pbno="+ $(this).parent().find('input[name=pnosi2]').val() + "&userid="+$(this).parent().find('input[name=userid332]').val() ;
                
                
             });
          });
         
         $(function(){ //게시물 신고
             $('#pnocheck td p[id=contentSettingbtn]').click(function(){
                var test = $(this);
                report1=$(this).parent().find('input[name=pnosi]').val();
                pwriter129=$(this).parent().find('input[name=userid33]').val();
           	  	reporter=$('#sessionid').val();
                
             });
             
             $("#reportcheck").click(function(){
            	
            	 
     	        $.ajax({
     	           url:"/6Days/reportboard.bo",
     	           type:"post",
     	           data:{pbno: report1, pwriter: pwriter129,reporter: reporter},
     	           success:function(data){
     				alert("정상적으로 신고되었습니다.");
     	     		
     	           },error:function(){
					alert("오류 발생.");
     	           }
     	        });
          });
          });



     	
       </script>
<!--********************************************** 게시물 상세보기 팝업  **********************************************-->     	
	

</body>
</html>