<%@page import="com.sixdays.userMember.model.vo.userMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
    userMember ms = (userMember)session.getAttribute("member");
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

   
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
          
   
   

</head>
<body onload="InitializeStaticMenu(),Initializerightsidebar();">
<!--    작성자 : 윤석훈, 박주완
      작성일 : 2020-01-14
      내용 : 좌측 메뉴바 -->
        <aside class="sidebar" style="line-height:15px;">
            <div class="sidebar-content">
                <p id="btn1" onclick="location.href='/6Days/selectList.bo'" style="cursor: pointer;">공지사항</p>
                <br>
                <p onclick="location.href='/6Days/selectList.qo'" style="cursor: pointer;">Q & A</p>
                <br>
                <p onclick="location.href='/6Days/psurround.bo'" style="cursor: pointer;">둘러보기</p>
                <br>
                <p onclick="location.href='/6Days/pbSelect.bo?userId=<%=ms.getUserId() %>'" style="cursor: pointer;">내 프로필</p>

                <span>
                <input id="menusearch1" type="text" list="menusearch"  placeholder="검색 내용을 입력하세요." readonly>

                </span>


                <span id="footer" style="font-size:12px; text-align:left;">
               CopyRight Six Days Company<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;박주완    윤석훈    신경섭<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이서현    신지영<br>
   &nbsp;&nbsp;&nbsp;&nbsp;Tel : 010-1234-5678 <br>
               Email : Team6Days@gmail.com
                </span>
                <%if(ms.getUserId().equals("admin")) {%>
                <p id="adminMenuBtn" onclick="location.href='aManage.ad'" style="cursor: pointer;">관리자 화면</p>
                <%} %>
            </div>
            <button><span class="sidebar-btn" style="cursor:pointer;">메뉴</span></button>
        </aside>

</body>
</html>