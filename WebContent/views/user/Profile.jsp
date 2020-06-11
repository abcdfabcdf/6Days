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
	// 사진 게시글 리스트 가져오기
    ArrayList<p_Board> list = (ArrayList<p_Board>)request.getAttribute("list"); 
	p_Board pba = new p_Board();
	userMember user = (userMember)request.getAttribute("user");
/* 	// 사진 게시글 리스트 가져오기
    ArrayList<p_Board> pblist = (ArrayList<p_Board>)request.getAttribute("list"); 
 */	
	
%>
<!DOCTYPE html>
<html lang="ko">
    <head> 
        <meta charset="UTF-8">
        <title>profile</title>
   <%@ include file="/views/common/header.jsp" %>
   <%@ include file="/views/common/left-sidebar.jsp" %>
   <%@ include file="/views/common/right-sidebar.jsp" %>
   
   
        <script src="/6Days/resources/js/Profile.js"></script>
        <link rel="stylesheet" href="/6Days/resources/css/profile.css">


    
    <body>

<input type="hidden" id="userid" name="userid" value="<%=m.getUserId()%>">

            
<!--    작성자 : 박주완,이서현
        작성일 : 2020-01-09
        내용 : 유저 프로필 화면
	수정일 : 2020-02-19   
-->
   <div id="container">
       <div id="profile" class="profile">
           <div id="show-profile">
               <img id="profilebackgound" src="/6Days/resources/probackUploadFiles/<%= user.getProback() %>" style="width: 850px; height: 280px;">
               <div id="profileimgbox">
                <img id="profileimg" name="profileimg" src="/6Days/resources/proimgUploadFiles/<%= user.getProimg() %>">
               </div>

                   <div id="profilename">
                       <label id="name" class="profile"><%=user.getUserName() %></label>
                       <hr style="margin-top: -5px; margin-bottom: 5px;">
                       <label id="memo" class="profile"><%=user.getMycomment() %></label>
                   </div>
                   <div id="profileright">
                   <%if(m.getUserId().equals(user.getUserId())){ %>
                       <button id="profileSetbtn" class="profile" onclick="profileModalOpen();" >프로필 편집</button><br>
                       <button id="settingbtn" class="profile" onclick="settingbtn();">설정</button><br><br>
                     <% }else{ %>
                       <button  id="profileSetbtn" class="profile">비공개</button><br>
                       <button  id="settingbtn" class="profile" >비공개</button><br><br>
                      <%} %> 
                       <label id="postCount" class="profile">게시물</label>
                       <span>5</span><span>   </span><br>
                       <label id="followers" class="profile">팔로워</label>
                       <span>2.6k</span><span>   </span><br>
                       <label id="following" class="profile">팔로우</label>
                       <span>104</span><span>   </span><br>    
                   </div>
               </div>
               
               
           </div>
           
           
           
    <hr id="hr1">
        <div id="postlist">

            <table align="center" style="width: 900px;" id="t1">
	            <tr>
	            <% for(p_Board pb : list) {
		               int pbno = pb.getPbno();
		               if(pb.getPhoto1() != null){
		               
		               %>
	        
			        <td style="display: inline-block; float:left; margin-left:2%">   
			              <input id="pbWriter" type="hidden" value="<%=pb.getPbwriter()%>">         
			              <input id="TEST" name="pbno95"  type="hidden" value="<%=pb.getPbno()%>"> 
			              <img  src="/6Days/resources/pboardUploadFiles/<%=pb.getPhoto1() %>" 
			                   width="260px" height="260px" style="margin:7px; cursor:pointer" id="pushdata">
			
			        </td>    
		        <%	}
		           } %>
		        </tr>
           </table>

    	</div>
        
<!--         작성자 : 박주완
        작성일 : 2020-02-21
	내용 : 게시물 이미지 클릭시 비동기방식으로 게시물 상세보기 팝업 오픈 -->
<!--********************************************** 게시물 상세보기 팝업  **********************************************-->              
       <script> 
          $(function(){
             $('#t1 td img').click(function(){
                var test = $(this);
                var url = '/6Days/pSelectOne.bo?pbno='+ $(this).parent().find('input[name=pbno95]').val();//document.getElementById("TEST").value;
                
                  w = 980; //팝업창의 너비
                   h = 630; //팝업창의 높이
                   
                   //중앙위치 구해오기
                   LeftPosition=(screen.width-w)/2;
                   TopPosition=(screen.height-h)/2; 
                    
                               
                   window.open(url,'상세보기',"width="+w+"px,height="+h+"px,top="+TopPosition+",left="+LeftPosition+',status=no,location=no,resizable=no');
                
             });
          });
       
         
             
         function modalclose(){
             $('#modal').css("display","none");
         }
       </script>
<!--********************************************** 게시물 상세보기 팝업  **********************************************-->     		
 

<!--    작성자 : 박주완
        작성일 : 2020-01-14
        내용 : 계정설정 및 보안 신고 메뉴화면 (세팅버튼 클릭시) -->
        <div id="setting">
            <div id="settinglist">
                <div>
                    <p class="settingitem" align="center" onclick="location.href='/6Days/views/member/Update.jsp'">개인정보 변경</p>
                    <hr>
                    <p class="settingitem" align="center" onclick="location.href='/6Days/selectList.qo'">문제 신고</p>
                    <hr>
                    <P class="settingitem" align="center" onclick="logout();">로그아웃</P>
                    <hr>
                    <p class="settingitem" align="center" onclick="settinglistclose();">취소</p>
                </div>
            </div>
        </div>

<!--    작성자 : 박주완
        작성일 : 2020-01-16
        내용 : 공개 범위 및 보안 모달창 메뉴화면-->
        <div id="Public_Scope_Modal">
            <div id="Public_scope">
                <div>
                    <p style="font-size: 24px;">공개 범위 설정</p><hr>
                    <input id="public" type="checkbox" class="checkBox">
                    <label for="public">전체공개</label><hr>
                    <input id="followerss" type="checkbox" class="checkBox">
                    <label for="followerss">팔로워만</label><hr>
                    <input id="private" type="checkbox" class="checkBox">
                    <label for="private">비공개</label><hr>
                    <p onclick="PublicScopeModalclose();">닫기</p>
                </div>
            </div>
        </div>


<!--    작성자 : 박주완
        작성일 : 2020-01-14
        내용 : 프로필 설정화면 -->
        <div id="profileModal">
            <div id="profileSet">
                <p style="font-size: 25px; cursor:default;">프로필 편집</p><hr>
                <p onclick="nameSetopen();" style="cursor:pointer;">닉네임 변경</p><hr>
                <p onclick="comentsetopen();" style="cursor:pointer;">코멘트 변경</p><hr>
                <p onclick="proImgChange();"style="color: royalblue; cursor:pointer;" >프로필 사진 바꾸기</p><hr>
                <p onclick="proBackChange();" style="color: royalblue; cursor:pointer;">프로필 배경 사진 바꾸기</p><hr>
                <form id="proImgDeleteForm" name="proimg" action="/6Days/pimgDelete.me" method="post" enctype="multipart/form-data">
                <p onclick="proImgDelete();" style="color: red; cursor:pointer;">현재 프로필 사진 삭제</p><hr>
                <input type="hidden" id="userid4" name="userid4" value="<%=m.getUserId() %>">
                </form>
                <form id="proBackDeleteForm" name="proback" action="/6Days/pbackDelete.me" method="post" enctype="multipart/form-data">
                <p onclick="proBackDelete();" style="color: red; cursor:pointer;">현재 프로필 배경 사진 삭제</p><hr>
                <input type="hidden" id="userid5" name="userid5" value="<%=m.getUserId() %>">
                </form>
                <p onclick="profileModalClose();" style="cursor:pointer;">닫기</p>
        </div>
        </div>

<!--    작성자 : 박주완
        작성일 : 2020-01-16
        내용 : 코멘트 변경 모달 화면-->
    <form id="commentupdateForm" action="/6Days/coUpdate.me" method="post">
     <input type="hidden" id="userid0" name="userid0" value="<%=m.getUserId() %>">
        <div id="comentSetModal">
            <div id="comentSet">
                <p style="cursor:default;">변경할 코멘트</p><hr>
                <textarea id="comenttextarea" name="mycomment"></textarea><br>
                <P onclick="comentInput();" style="margin: 8px 0px 8px 0px; color: blue; cursor:pointer;">변경</P><hr>
                <p onclick="comentsetclose();" style="cursor:pointer;">닫기</p>
            </div>
        </div>
   </form>
<!--    작성자 : 박주완
        작성일 : 2020-01-16
        내용 : 닉네임 변경 모달 화면-->
    <form id="nameupdateForm" action="/6Days/unUpdate.me" method="post">
     <input type="hidden" id="userid1" name="userid1" value="<%=m.getUserId() %>">
        <div id="nameSetModal">
            <div id="nameSet">
                <p style="cursor:default;">변경할 닉네임</p><hr>
                <input type="text" id="nametextarea" name="userName"><br>
                <P onclick="nameInput();" id="namebtn" style="margin: 8px 0px 8px 0px; color: blue; cursor:pointer;">변경</P><hr>
                <p onclick="nameSetclose();" style="cursor:pointer;">닫기</p>
            </div>
        </div>
    </form>
        
<!--    작성자 : 신지영
        작성일 : 2020-02-13
        내용 : 프로필사진 변경 모달 화면-->
    <form id="proImgupdateForm" action="/6Days/proimage.me" method="post"  enctype="multipart/form-data">
     <input type="hidden" id="userid2"name="userid2" value="<%=m.getUserId() %>">
      <div id="proImgModal">
         <div id="proImgSet">
            <p style="cursor:default;">프로필 사진</p>
            <input type="file" id="proimgarea" name="proimg" style="cursor:pointer;"><br><br>
            <p onclick="proimgInput();" style="margin: 3px 0px 8px 0px; color: blue; cursor:pointer;">변경</p><hr>
            <p onclick="proimgSetclose();" style="cursor:pointer;">닫기</p>
         </div>
      </div>
    </form>
    
  <!--   <!--    작성자 : 신지영
        작성일 : 2020-02-16
        내용 : 프로필사진 변경 모달 화면-->
    <form id="proBackupdateForm" action="/6Days/proback.me" method="post"  enctype="multipart/form-data">
     <input type="hidden" id="userid3" name="userid3" value="<%=m.getUserId() %>">
      <div id="proBackModal">
         <div id="proBackSet">
            <p style="cursor:default;">프로필 사진</p>
            <input type="file" id="probackarea" name="proback" style="cursor:pointer;"><br><br>
            <p onclick="probackInput();" style="margin: 3px 0px 8px 0px; color: blue; cursor:pointer;">변경</p><hr>
            <p onclick="probackSetclose();" style="cursor:pointer;">닫기</p>
         </div>
      </div>
    </form>
    
    </div>
    
    
    <script>
    
    
    
    
 /*    -----------------------------------------------------------------------     */
    
    
    
    var username = document.getElementById('nametextarea');
    var comment = document.getElementById('comenttextarea');
    var proimage = document.getElementById('proimgarea');
    var proback = document.getElementById('probackarea');

    
    function nameInput(){
       if(username.value != ""){
          document.getElementById("nameupdateForm").submit();
       }else{
          alert("닉네임을 입력해주세요.");        
       }
    }
    
    function comentInput(){
       if(comment.value != ""){
       document.getElementById("commentupdateForm").submit();
       }else if(comment.value == ""){
          comment.value = " ";
       document.getElementById("commentupdateForm").submit();
      
          
       } 
    }
    
    function proimgInput(){
       if(proimage.value != ""){
          document.getElementById("proImgupdateForm").submit();
       }else{
          alert("선택된 사진이 없습니다.");
       }
    }
    function probackInput(){
       if(proback.value != ""){
       document.getElementById("proBackupdateForm").submit();
       }else{
          alert("선택된 사진이 없습니다.");
       }
    }
    function proImgDelete(){
       document.getElementById("proImgDeleteForm").submit();
    }
    function proBackDelete(){
       document.getElementById("proBackDeleteForm").submit();
    }
    

    </script>
    
</body>
</html>