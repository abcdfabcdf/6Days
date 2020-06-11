<%@page import="com.sixdays.board.model.vo.Board"%>
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
    ArrayList<userMember> list = (ArrayList<userMember>)request.getAttribute("list"); 
    userMember ums = new userMember();
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
 <style>
  
  #imgbtnsearch{
            border-radius: 100%;
		    width: 220px;
		    height: 220px;
		    float: left;
		    padding: 5px;
		    text-align: center;
            }

 
 </style>
</head>
<body>

	<input type="hidden" id="userid" name="userid" value="<%=m.getUserId()%>">
	<div id="backgroundArea" style="background-color:smokewhite;">
		<div id="contentArea" class="contentArea" style="background:orange; width:60%; margin-left:20%; position:absolute; background-color:white;">
		<table align="center" id="searchcheck" style="width: 900px; ">
                <tr>
                <% for(userMember um : list) {  %>
				
				<td style="display: inline-block; float:left; margin-left:2%">
				<div>	
						<input type="hidden" name="search" value="<%= um.getUserId() %>">
						<img src="/6Days/resources/proimgUploadFiles/<%= um.getProimg() %>"
						      id="imgbtnsearch"width="260px" height="260px" style="margin:7px; cursor:pointer;" onclick="modalOpen();">
						 <div style="font-size:50px;"><%=um.getUserName() %></div> <br><br><br>
				</div>
				</td>
				
				<% 
                	
                	} %>
				</tr>
        </table>
		</div>
	</div>
	
<script>
$(function(){
    $('#searchcheck td img').click(function(){
       				 
       location.href="/6Days/pbSelect.bo?userId="+ $(this).parent().find('input[name=search]').val();
       
    });
 });


</script>


        

</body>
</html>