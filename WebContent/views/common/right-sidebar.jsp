<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    #chat_send_btn{
    margin-right:-5px;
    margin-top: 1px; 
    height: 31px;
    background-color: red;
    color: #fff;
}
</style>
</head>
	<script src="/6Days/resources/js/sidebar.js"></script>
    <script src="/6Days/resources/js/jquery-3.4.1.min.js"></script>
    <script src="/6Days/resources/js/jquery-ui-1.11.4.custom.min.js"></script>
    <script src="/6Days/resources/js/Right_sidebar.js"></script>
    <script src="/6Days/resources/js/Infadd.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/6Days/resources/css/sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/Right_sidebar.css">
    <link rel="stylesheet" href="/6Days/resources/css/main.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Infadd.css">
    <link rel="stylesheet" href = "/6Days/resources/css/MainContact.css">
    <link rel="stylesheet" href = "/6Days/resources/css/Scrollbar.css">
    
    
	<body onload="InitializeStaticMenu(),Initializerightsidebar();">

<!--    작성자 : 박주완
		작성일 : 2020-01-14 
        내용 : 우측 사용자 채팅용 사이드바 
        수정일 : 2020-02-11 -->
		<aside id="right_sidebar">
            <div id="right_sidebar_content">
                <div id="chatarea">
                    <div id="chatid">
                          박주완
                        <input type="submit" value="X" style="float:right; border-radius: 3px; border: 0px;">
                        </div>
                    <hr>
                    <div id="chatcontent">
                        <label>seokhun_999: 안해</label><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                                            <label>seokhun_999: 안해</label><br><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                                            <label>seokhun_999: 안해</label><br><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                                            <label>seokhun_999: 안해</label><br><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                                            <label>seokhun_999: 안해</label><br><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                                            <label>seokhun_999: 안해</label><br><br>
                        <label style="float:right">juwan_777 : ㅂㅇ</label><br><br>
                    </div>
                    <div id="chatinput">
                        <input type="text" style="margin:1px 0px 0px 0.8px;width:265px;height: 25px; border-radius: 3px;">
                        <input type="submit" id="chat_send_btn" value="전송">
                    </div>
                </div> 

                <div id="chatList">
                    <ul>
                        <br><br><br><br>
                        <li>박주완</li><br><br>
                        <li>윤석훈</li><br><br>
                        <li>신경섭</li><br><br>
                        <li>이서현</li><br><br>
                        <li>신지영</li><br><br>
                    </ul>
                </div>
            </div>
            <button><span id="right_sidebar_btn" style="cursor:pointer;">메신저</span></button>
        </aside>
</body>
</html>