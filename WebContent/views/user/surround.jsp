<%@page import="com.sixdays.p_board.model.vo.p_Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sixdays.userMember.model.vo.userMember" %>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사진 게시글 리스트 가져오기
    ArrayList<p_Board> list = (ArrayList<p_Board>)request.getAttribute("list"); 
	p_Board pba = new p_Board();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>둘러보기</title>
	<%@ include file="/views/common/header.jsp" %>
	<%@ include file="/views/common/left-sidebar.jsp" %>
	<%@ include file="/views/common/right-sidebar.jsp" %>
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/6Days/resources/css/sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/Right_sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/main.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Infadd.css">
    <link rel="stylesheet" href = "/6Days/resources/css/MainContact.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Scrollbar.css">
    <link rel="stylesheet" href = "/6Days/resources/css/main-header.css">
            <script src="/6Days/resources/js/Profile.js"></script>
</head>
<body>

	<input type="hidden" id="userid" name="userid" value="<%=m.getUserId()%>">
	<div id="backgroundArea" style="background-color:smokewhite;">
		<div id="contentArea" class="contentArea" style="background:orange; width:60%; margin-left:20%; position:absolute; background-color:white;">
		<table align="center" style="width: 900px;" id="table96">
                <tr>
                <% for(p_Board pb : list) {
                	if(pb.getPhoto1() != null){
                	
                %>
				
				<td style="display: inline-block; float:left; margin-left:2%">		
						<input type="hidden"name="pbno96" value="<%= pb.getPbno()%>">
						<img src="/6Days/resources/pboardUploadFiles/<%=pb.getPhoto1() %>"
						     width="260px" height="260px" style="margin:7px; cursor:pointer;" >
				
				</td>
				
				<% 
                	}
                	} %>
				</tr>
        </table>
		</div>
	</div>
	
<!--         작성자 : 박주완
        작성일 : 2020-02-21
	내용 : 게시물 이미지 클릭시 비동기방식으로 게시물 상세보기 팝업 오픈 -->
<!--********************************************** 게시물 상세보기 팝업  **********************************************-->              
       <script> 
          $(function(){
             $('#table96 td img').click(function(){
                var test = $(this);
                var url = '/6Days/pSelectOne.bo?pbno='+ $(this).parent().find('input[name=pbno96]').val();//document.getElementById("TEST").value;
                
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

</body>
</html>