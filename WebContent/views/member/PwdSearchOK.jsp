<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>비밀번호 찾기 결과</title>

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
<!-- 작성자 : 국영미
   * 작성일 : 2020.01.14
   * 내용 : 비밀번호 찾기 결과
   * 수정일 : 
-->
        
<!-- 비밀번호 찾기 성공 전체 div-->
<div id="idContents" class="center">
    <form action="" method="POST" onsubmit="return validate();">
        <div id="searchWrap">
            <div class="contentsWrap">
                <!-- 아이디 비밀번호 찾기 title tap -->
                <div class="searchTab">
                    <ul>
                        <li class><a href="/6Days/views/member/IdSearch.jsp">아이디 찾기</a></li>
                        <li class="current"><a href="/6Days/views/member/PwdSearch.jsp">비밀번호 찾기</a></li>
                    </ul>
                </div>
            <div class="idsearchWrap">        
            <div class="resultBox">
                <h4>  비밀번호 찾기 결과</h4>
          
            <ul>
                <li>
                    <!-- 찾은 비밀번호 결과 보여주기 -->
                    <div class="radioStyle">
                        <!-- 전체확인 리스트를 위한 라디오 버튼 -> 클릭시 전체확인 allResult 보여줌-->
                        <input type="radio" name="idlist" id="radioId" value="">
                        <!-- 찾은 비밀번호 -->
                        <label for="id">인증하신 메일로</label><br>
                        <label for="id"> 임시비밀번호가 발송되었습니다.</label>
                    </div>
                    <!-- 가입일 -->
                    <div class="date">가입일 : 2020-01-14</div>
                </li>                
            </ul>
                   
            <span class="notiText">  로그인 후 반드시 비밀번호를 변경해주시기 바랍니다.</span>
            <!-- 로그인 버튼 -> 클릭시 로그인 화면으로 이동 -->
            <div class="btnArea">
                <button type="button" class="btnRed" id="btnRed" onclick="openerLogin();">로그인</button>
            </div>
        </div>   
         <hr>     

            </div>
        </div>
    </div>
    </form>
</div>
</body>
</html>