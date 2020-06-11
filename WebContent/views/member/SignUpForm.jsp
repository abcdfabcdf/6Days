<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/6Days/resources/css/Register.css">
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
</head>
<body>
    <div id="top">
        <img src="/6Days/resources/images/logoletter.png" style="padding-top: 7%; width: 170px; height: 50px;">
    </div>
    <div id="registerpage">
        <div id="idregister">
            <label>아이디</label><br><br>
            <input type="text" id="idok" class="redata" placeholder="아이디"/>
            <button id="idokbtn">중복확인</button>
            <br><br>
        </div>

        
        <div id="pwd">
            <label style="font-family: 'Jua', sans-serif;" >비밀번호</label><br><br>
            <input type="password" class="redata" placeholder="비밀번호(8~16자)"/><br><br>
            <input type="password" class="redata" placeholder="비밀번호 재입력"/><br><br>
        </div>
        <div id="nicname">
            <label>닉네임</label><br><br>
            <input type="text" class="redata" placeholder="닉네임을 입력해주세요."/><br><br>
        </div>
        <div id="email">
            <label>이메일</label><br><br>
            <input type="text" class="redata" placeholder="이메일을 입력해주세요."/><br><br>
        </div>
        <div id="phone">
            <label>전화번호</label><br><br>
            <input type="text" id="auth" class="redata" placeholder="전화번호"/>
            <button id="authbtn">인증번호 받기</button><br><br>
            <input type="text" id="authtext" placeholder="인증번호를 입력하세요.">&nbsp&nbsp<button style="float:none; cursor: pointer; background: rgb(15, 76, 129); 
    color:white; border: 0px; width: 80px; height: 30px;">확인</button>
        </div>
        <div id="gender">
            <br>
            <label>성별</label><br><br>
            <input type="radio" name="radio" id="man"/><label for="man" style="font-size:12px">남자</label>&nbsp;
            <input type="radio" name="radio" id="woman"/><label for="woman" style="font-size:12px">여자</label>
        </div><br><br>
        <div id="introduction">
            <label>소개</label><br><br>
            <input type="text" class="redata" placeholder="소개를 입력해주세요"/><br><br><br>
        </div>
        <div id="rebtn">
            <button id="registerbtn" onclick="location.href='/6Days/login.html'">가입</button>
        </div>
    </div>
    <div id="bottom"></div>
</body>
</html>