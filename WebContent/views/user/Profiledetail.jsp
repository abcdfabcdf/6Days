<%@page import="com.sixdays.maincomment.model.vo.MainComment"%>
<%@page import="com.sixdays.p_board.model.service.p_BoardService"%>
<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="com.sixdays.p_board.model.vo.p_Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sixdays.userMember.model.vo.userMember" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

   p_Board pba = (p_Board)request.getAttribute("pb2");
	ArrayList<MainComment> mlist2 = (ArrayList<MainComment>)request.getAttribute("mlist2");

%>

<!DOCTYPE html>
<html lang="ko" >
    <head> 
        <meta charset="UTF-8">
        <title>profile</title>
        
      <%@ include file="/views/common/header.jsp" %>


        <script src="/6Days/resources/js/Profile.js"></script>
        <link rel="stylesheet" href="/6Days/resources/css/profile.css">
      <style type="text/css">
         #top1{
         display: none;
         }
         html{overflow:hidden;}
         
         
      
      </style>

    <body>
<input type="hidden" id="sessionid" name="sessionid" value="<%=m.getUserId()%>">
<!--    작성자 : 박주완
      수정알 : 2020-02-18
      내용 : 게시물 부분 수정 모달 -->
<!--    ***************************** 컨탠츠 클릭시 나타나는 모달창 영역 ****************************** -->
<!--              개 멍청도 코딩 작성자 박주완 -->
             <% 
             int count = 1;
             
             if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
             && pba.getPhoto4()!=null && pba.getPhoto5()!=null && pba.getPhoto6()!=null){ 
                count = 6;
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()!=null && pba.getPhoto5()!=null && pba.getPhoto6()==null){
                count = 5;
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()!=null && pba.getPhoto5()==null && pba.getPhoto6()==null){
                count = 4;
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
                count = 3;
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()==null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
                count = 2;
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()==null && pba.getPhoto3()==null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
                count = 1;
             }


             %>
      
            <div id="modalcontent">
                <button id="closebtn" onclick="modalclose();">X</button>
                <div id="modalpost">
                    <div id="modalimg" class="slideshow-container" >
                        <div class="mySlides fade" style="display: block;">
                            <div class="numbertext">1 / <%=count %></div>
                            <div class="imgbox" >
                            <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto1() %>" >
                            </div>
                        </div>                    

                     <% if(pba.getPhoto2()!=null){ %>
                    <div class="mySlides fade">
                        <div class="numbertext">2 / <%=count %></div>
                        <div class="imgbox" >
                        <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto2() %>" >
                        </div>
                    </div>
                    <% } %> 
                     <% if(pba.getPhoto3()!=null){ %>
                    <div class="mySlides fade">
                        <div class="numbertext">3 / <%=count %></div>
                        <div class="imgbox" >
                        <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto3() %>">
                        </div>
                    </div>
               <% } %>
                <% if(pba.getPhoto4()!=null){ %>
                    <div class="mySlides fade">
                        <div class="numbertext">4 / <%=count %></div>
                        <div class="imgbox" >
                        <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto4() %>" >
                        </div>
                    </div>
                    <% } %>
                    <% if(pba.getPhoto5()!=null){ %>
                    <div class="mySlides fade">
                        <div class="numbertext">5 / <%=count %></div>
                        <div class="imgbox" >
                        <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto5() %>">
                        </div>
                    </div>
                    <% } %>
                    <% if(pba.getPhoto6()!=null){ %>
                    <div class="mySlides fade">
                        <div class="numbertext">6 / <%=count %></div>
                        <div class="imgbox" >
                        <img class="contentimgs" src="/6Days/resources/pboardUploadFiles/<%=pba.getPhoto6() %>">
                        </div>
                    </div>
                    <% } %>
                       
                        <a class="prev" onclick="plusSlides(-1);">&#10094;</a>
                        <a class="next" onclick="plusSlides(1);">&#10095;</a>
                        
                        
                        
                        <div id="dotbox" style="text-align:center">
                       
 
<!-- /*              쌉 멍청도식 코드 2 ㅎㅎ */ -->
           <% 
              if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
             && pba.getPhoto4()!=null && pba.getPhoto5()!=null && pba.getPhoto6()!=null){ 
               %><span class="dot" onclick="currentSlide(1);"></span>
              <span class="dot" onclick="currentSlide(2);"></span>
              <span class="dot" onclick="currentSlide(3);"></span>
              <span class="dot" onclick="currentSlide(4);"></span>
              <span class="dot" onclick="currentSlide(5);"></span>
              <span class="dot" onclick="currentSlide(6);"></span><%
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()!=null && pba.getPhoto5()!=null && pba.getPhoto6()==null){
              %><span class="dot" onclick="currentSlide(1);"></span>
             <span class="dot" onclick="currentSlide(2);"></span>
             <span class="dot" onclick="currentSlide(3);"></span>
             <span class="dot" onclick="currentSlide(4);"></span>
             <span class="dot" onclick="currentSlide(5);"></span><%
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()!=null && pba.getPhoto5()==null && pba.getPhoto6()==null){
              %><span class="dot" onclick="currentSlide(1);"></span>
             <span class="dot" onclick="currentSlide(2);"></span>
             <span class="dot" onclick="currentSlide(3);"></span>
             <span class="dot" onclick="currentSlide(4);"></span><%
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()!=null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
              %><span class="dot" onclick="currentSlide(1);"></span>
             <span class="dot" onclick="currentSlide(2);"></span>
             <span class="dot" onclick="currentSlide(3);"></span><%
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()!=null && pba.getPhoto3()==null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
              %><span class="dot" onclick="currentSlide(1);"></span>
             <span class="dot" onclick="currentSlide(2);"></span><%
             }else if(pba.getPhoto1()!=null && pba.getPhoto2()==null && pba.getPhoto3()==null 
                       && pba.getPhoto4()==null && pba.getPhoto5()==null && pba.getPhoto6()==null){
                   %><span class="dot" onclick="currentSlide(1);"></span><%
             }

          if(count >= 7){
                count = 1;
             }
             %>
             <input type="hidden" id="countDot" name="userid4" value="<%=count%>">          
                        </div>                                                                
                   </div>           
               </div>


                    <div id="coments">
                        <div id="userprofilshow">
                           <div id="profileIMG2">
                             <img id="profileimg2" name="profileimg" src="/6Days/resources/proimgUploadFiles/<%=pba.getPproimg() %>">
                        <label id="name2" class="profile"><%=pba.getPnickname() %></label>
                        <p id="Settingbtn15" onclick="SettingMadalOpen15();">...</p>
                     </div>
                        <div id="innercoment">
	                        <!-- 게시글내용, 해시태그 -->
	                            <%=pba.getPcontent() %><br>
	                            <%=pba.getHashtag() %>
	                        

<!--                  *******************************   여기서부터 댓글 들어갈 자리!!   *******************************  -->
						<div id="contentComment" style="height:390px;">
						<% for(MainComment mc : mlist2) { %>
							
							<div style="background-color: whitesmoke; margin-bottom: 10px; padding: 5px; border-radius: 15px; width:323px; margin-left: -30px;">
						    <label style="color:skyblue; font-size:17px;"><%= mc.getMnickname() %></label> : 
						    <label style="font-size:15px;"><%= mc.getMcontent() %></label>
						    <label style="font-size: 12px; float: RIGHT; margin-top: 5px;"><%= mc.getMdate() %></label>
						    </div>
						<% } %>
						</div>  <!-- contentComment end -->






<!--                  *******************************   여기서까지 댓글   *******************************  -->
                        </div>

                      <div id="toolsbox"> <!-- 좋아요버튼, 좋아요수, 글쓴시간 등을 표현할 영역  -->
                          <img id="whitesmile"  src="/6Days/resources/icon/whitesmile.png" onclick="like();" >
                          <div id="likerUsersName" >좋아요 </div>
                          <div id="likeCount" ><%=pba.getLike_count() %></div>
                          <div id="likeMent" >개</div>
                          <div id="comentsCount" > 댓글 <%=pba.getPbcomment() %></div>
                          <div id="postmakeDate"><%=pba.getPbdate() %></div>
                      </div>

                        <div id="comentarea">
   
							<input type="hidden" id="mmo" name="mno" value="1">
							<input type="hidden" id="mwriter" name="mwriter" value= "<%= m.getUserId() %>">
							<input type="hidden" id="mnickname" name="mnickname" value= "<%= m.getUserName() %>">
                        	<input type="hidden" id="commenttest" value="<%=pba.getPbno() %>">
                        	<input type="hidden" id="pwriter" value="<%=pba.getPbwriter() %>">
                            <input type="text" id="comentinput" placeholder="댓글 달기..." >
                            <button  id="comentsend" style="cursor:pointer;">게시</button>
                        </div>
                    </div>
                    
                </div>
            </div>

         

 <!--    ***************************** 모달창 영역 끝 ****************************** -->    
 
<!--    작성자 : 박주완
        작성일 : 2020-02-21
        내용 : 포스트 [...] 버튼 클릭시 모달창 오픈 
		----- 세션ID와 작성자 ID가 *같을 * 시에  -->

        <div id="SettingMadal15">
            <div id="Setting15">
                 <input id="pbno" name="pbno"  type="hidden" value="<%=pba.getPbno()%>"> 

                <p style="color: red; cursor:pointer" onclick="deletepost(this)">게시글 삭제</p><hr>

					
                <p onclick="SettingMadalClose15();" style="cursor:pointer">닫기</p>
            </div>
        </div>
        
        <!--    작성자 : 박주완
        작성일 : 2020-02-21
        내용 : 포스트 [...] 버튼 클릭시 모달창 오픈  
        ----- 세션ID와 작성자 ID가 * 다를 *시에  -->
        <div id="SettingMadal16">
            <div id="Setting16">
                <p id="reportcheck" style="color: red; cursor:pointer"">부적절한 게시물 신고</p><hr>
                <input id="pbno" name="pbno"  type="hidden" value="<%=pba.getPbno()%>"> 
                <p onclick="SettingMadalClose15();" style="cursor:pointer">닫기</p>
            </div>
        </div>
 		
 
  
   <script >
          /*<!--  작성자 : 박주완
          작성일 : 2020-02-03
          내용 : 사용자 게시물 좌우로 이미지 슬라이드쇼 쿼리문  -->*/
      /*     var plusSlides = 1; */
          var slideIndex = 1;
          var countCk = document.getElementById('countDot').value;

          showSlides(slideIndex);
      
          function plusSlides(n) {
              showSlides(slideIndex += n);
          }
      
          function currentSlide(n) {
              showSlides(slideIndex = n);
          }
      
          function showSlides(n) {
              var i;
              var slides = document.getElementsByClassName("mySlides");
              var dots = document.getElementsByClassName("dot");
              if (n > slides.length) {slideIndex = 1}    
              if (n < 1) {slideIndex = slides.length}
              for (i = 0; i < slides.length; i++) {
                  slides[i].style.display = "none";  
              }
              for (i = 0; i < countCk; i++) {
                  dots[i].className = dots[i].className.replace(" active", "");
              }
              slides[slideIndex-1].style.display = "block";  
              dots[slideIndex-1].className += " active";
          }
          
          
          
// <!--    작성자 : 박주완
//        작성일 : 2020-02-21
//        내용 : 게시물 ... 클릭시 나오는 삭제&신고 메뉴 모달 오픈 로직-->

/*         var userId = "";
			var pwriter = "";
			var madalId = "";
			
       	   if(userId = pwriter){
       		   madalId = "#SettingMadal15";
       	   }else{
       		   madalId = "#SettingMadal16";
       	   } */
       	   
       	   
       		var userId = '<%=m.getUserId()%>'
       	   var writer = '<%=pba.getPbwriter() %>'
        	   
           function SettingMadalOpen15(){


        	   if(userId != writer){
        		  
        		   var madalId = "#SettingMadal16";
        	   }else{
        		  
        		   var madalId = "#SettingMadal15";
        	   }
        	   
               var ulr = $(this).attr("src");
               $(madalId).attr("src",ulr);
               $(madalId).show();
           }

           function SettingMadalClose15(){
        	   if(userId != writer){
         		   
        		   var madalId = "#SettingMadal16";
        	   }else{
        		  
        		   var madalId = "#SettingMadal15";
        	   }
        	   
               $(madalId).css("display",'none');
           } 
           
           
           
    /* 게시물 삭제 로직 */
           
            function deletepost(obj) {
    		// 게시물 번호 가져오기
    		var pbno = '<%=pba.getPbno()%>';
    		
    		location.href="/6Days//pdelete.bo?pbno="+pbno;
    		
    		opener.parent.location.reload();
    		opener.parent.location.reload();
 
    		window.close();
    		
    		
    	}
    

            $(function(){ //게시물 신고

                
            	  $('#reportcheck').click(function(){
                      
                      var report=$('#pbno').val();
                      var pwriter=$('#pwriter').val();
                 	  var reporter=$('#sessionid').val();
         				
             	        $.ajax({
           	           url:"/6Days/reportboard.bo",
           	           type:"post",
           	           data:{pbno: report, pwriter: pwriter, reporter: reporter},
           	           success:function(data){
           				alert("정상적으로 신고되었습니다.");
           	     		
           	           },error:function(){
      					alert("오류 발생.");
           	           }
        	        });
             });
             });
            



          

    </script>
    
        <script>
 		$('#comentsend').click(function(){		//확인버튼
 			var test = $('#comentinput');
 			 			
 			if(test.val() != "") {
 			pbno = 	$('#commenttest').val();
 			
	       $.ajax({
	    	   url:"/6Days/InsertComment.mo",
	    	   type: "post",
	    	   data:{ 
	    		   pbno : $('#commenttest').val(),
	    		   mno : $('#mmo').val(),
	    		   mwriter : $('#mwriter').val(),
	    		   mcontent : test.val(),
	    		   mnickname : $('#mnickname').val()
	    	   },
	    	   success:function(result){
	    		  $('#comentinput').val('');
	    		  window.location.reload();
	    		  
	    		  

	    	   }, 
	    	   error:function(result){
	    		   alert("실패");
	    	   
	    	   }
	       });
 			}
		});
    </script>
</body>
</html>