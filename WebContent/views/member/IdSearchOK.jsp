<%@page import="com.sixdays.userMember.model.vo.userMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
    userMember m =(userMember)request.getAttribute("member");
    String id1 = m.getUserId();

	StringBuilder id2 = new StringBuilder(id1);
	id2.setCharAt(2, '*');
	id2.setCharAt(3, '*');

	System.out.println("보호된 유저 ID : "+ id2);
    
		
		
   %>

<!DOCTYPE html>
<html>
<head>
	<title>아이디 찾기 결과</title>

    <script src="/6Days/resources/js/jquery-3.4.1.min.js"></script>
    <script src="/6Days/resources/js/jquery-ui-1.11.4.custom.min.js"></script>
    <script src="/6Days/resources/js/IdPwdSearch.js"></script>
    <link rel="stylesheet" href="/6Days/resources/css/IdPwdSearch.css">

    <style>
        #btnRed{
            background: rgb(15, 76, 129);
            border-color: rgb(15, 76, 129);
        }
    </style>

</head>

   <body onload="InitializeStaticMenu(),Initializerightsidebar();">
<!-- 작성자 : 박주완
   * 작성일 : 2020.01.14
   * 내용 : 아이디 찾기 결과
   * 수정일 : 
-->
        
<!-- 전체 div-->
<div id="idContents" class="center">
    <form action="" method="POST" onsubmit="return validate();">
        <div id="searchWrap">
            <div class="contentsWrap">
                <!-- 아이디 비밀번호 찾기 title tap -->
                <div class="searchTab">
                    <ul>
                        <li class="current"><a href="/6Days/views/member/IdSearch.jsp">아이디 찾기</a></li>
                        <li class><a href="/6Days/views/member/PwdSearch.jsp">비밀번호 찾기</a></li>
                    </ul>
                </div>
            <div class="idsearchWrap">        
            <div class="resultBox">
                <h4>아이디 찾기 결과</h4>
            <ul>
                <li>
                    <!-- 찾은 아이디 결과 보여주기 -->
                    <div class="radioStyle">
                        <!-- 전체확인 리스트를 위한 라디오 버튼 -> 클릭시 전체확인 allResult 보여줌-->
                        <input type="radio" name="idlist" id="radioId" value="">
                        <!-- 찾은 아이디 -->
                        <label for="id"><%=id2%></label>
                    </div>
                    <!-- 가입일 -->
                    <div class="date">가입일 : <%=m.getEnrolldate() %></div>
                </li>
            </ul>
            <span class="notiText">개인정보 보호를 위해 아이디 일부를 **로 표시합니다.</span>
            <!-- 로그인 버튼 -> 클릭시 로그인 화면으로 이동 -->
            <div class="btnArea">
                <button type="button" class="btnRed" id="btnRed" onclick="openerLogin();">로그인</button>
            </div>
        </div>
        </div>
    </div>
    </form>
</div>

<script>
var result = document.getElementById('idsearch').value;


window.open = function(){
	
var change_name = replaceAt(result, 1, '*');
}

</script>
</body>
</html>