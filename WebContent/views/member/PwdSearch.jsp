<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>비밀번호 찾기</title>
    
    <script src="/6Days/resources/js/IdPwdSearch.js"></script>
    <link rel="stylesheet" href="/6Days/resources/css/IdPwdSearch.css">
    
    <style>
        #idPhoneSearch, #idEmailSearch{
            background: rgb(15, 76, 129);
            border-color: rgb(15, 76, 129);
        }
    </style>
</head>


<!-- 작성자 : 박주완
   * 작성일 : 2020.01.14
   * 내용 : 비밀번호 찾기
   * 수정일 : 2020.02.10
-->
        
<!-- 비밀번호 찾기 전제 div-->

<div id="idContents" class="center">
	<form action="/6Days/PwdSearch.me" method="post">
        <div id="searchWrap">
            <div class="contentsWrap">
                <!-- 아이디 비밀번호 찾기 title tap -->
                <div class="searchTab">
                    <ul>
                        <li class><a href="/6Days/views/member/IdSearch.jsp">아이디 찾기</a></li>
                        <li class="current"><a href="#">비밀번호 찾기</a></li>
                    </ul>
                </div>
            <div class="idsearchWrap">        
            <div class="notiArea">
                <span>아이디를 확인 후 비밀번호를 찾아주세요.</span>
            </div>
            <div class="searchType">
                <ul>
                    <!-- 등록된 비밀번호 찾기 -->
                    <li class="typeList">
                        <div class="title" id="titleID">등록된 아이디, Email로 비밀번호 찾기</div>
                        <!-- 등록된 에미일 찾기 입력  -->
                        <div class="inputEnter" id="divPhone">
                            <div class="inputBox">
                                <div class="styleInut">
                                    <!-- 아이디,이메일 입력 받기 inputBox -->
                                    <input id="inputId" name="inputId" type="text" class="iInput"
                                           placeholder="아이디 입력">
                                           <br>
                                    <input id="inputEmail" name="inputEmail" type="text" class="iInput"
                                           placeholder="Email 입력">
                                </div>
                            </div>
                            <!-- 이메일로 임시 비밀번호 발급 버튼 -->
                            <div class="btnArea">												
                                <button type="submit" id="idemailSearch" class="btnRed" onclick="location.href='PwdSearch.me'">확인</button>
                            </div>
                        </div>
                    </li>
                    <!-- 등록된 이메일로 찾기 -->
                    <li class="typeList">

                        </li>   
                    </ul>
                </div>
            </div>
        </div>
        </div>
    </form>
</div>
</body>
</html>