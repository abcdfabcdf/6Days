<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sixdays.userMember.model.vo.*" isErrorPage="true"%>
<%
	userMember m = (userMember)session.getAttribute("member");
	/*session.setMaxInactiveInterval(1000);*/
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>로그인</title>
    <link rel="stylesheet" href="/6Days/resources/css/login.css">
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
     <script src="/6Days/resources/js/jquery-3.4.1.min.js"></script>
    <script language="javascript" type="text/javascript">  
        // 로그인&비밀번호 찾기 popup띄우기
        var popupX = (window.screen.width / 2) - (500 / 2); 
        var popupY= (window.screen.height / 2) - (600 / 2);    
        function winOpenPwd(url){
            window.open(url, '',
            'width=500, height=600,  left='+ popupX + ', top='+ popupY,
            'menubar=no, status=no, toolbar=no, resizable=no, scrollbars=no, location=no');
        }
    </script>
</head>
<body>
    <div id="all">
      <%if ( m == null ) { %>
      
        <div id = "loginpage">
        <div id="loginimage">
            <img src="/6Days/resources/images/image1.jpg" width="70%" height="350px" style="margin-left: 20%; margin-top: 8%;">
        </div>
        <div id="login" class="login">
         <form id="loginForm" action="/6Days/login.me" method="post">	
            <img src="/6Days/resources/images/main.png" width="30%" height="30px" style="margin-left: 10%; margin-top: 12%;"><br><br>
            <input type="text" id="textbox" name="userId" placeholder="아이디"/><br><br>
            <input type="password" id="textbox" name="password" placeholder="비밀번호" /><br><br><br>
            <button id="loginbtn"onclick='login();'>로그인</button><br><br>
         </form>  
             <table id="tbl">
                <td id="td1"><button id="register" onclick='signup();' >회원가입</button></td>
                <td id="td2"><button id="idfind" class="find" onclick="winOpenPwd('/6Days/views/member/IdSearch.jsp');" style="font-family: 'Jua', sans-serif; font-size: 17px;">아이디/비밀번호 찾기</button>
                </td>       
            </table>
        </div>
    </div>
    
    </div>
	<% }else{ %>

	<%} %>
	<script>
		function login(){
			
			$('#loginForm').submit;
		}
		
		function signup(){
			location.href="/6Days/views/member/agree.jsp";
		}
		
	</script>
	
</body>
</html>          