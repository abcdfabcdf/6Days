<%@page import="com.sixdays.admin.model.service.adminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sixdays.admin.model.vo.*,com.sixdays.board.model.vo.*"%>
    
<%
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list"); 
	
	/* 페이지 영역  */
	//PageInfo pi = (PageInfo)request.getAttribute("pi");
	/* int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	adminService as = new adminService();
	int Rnumber = as.getListCount(); */
		
%>
<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>신고사항 관리</title>
 <script src="<%= request.getContextPath() %>/resources/js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap core CSS 
    -->
    <link href="/6Days/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/6Days/resources/css/dashboard.css" rel="stylesheet">

   
  </head>
<body style="overflow-x: hidden">
	<%@ include file="../common/header.jsp" %> 
   	<%@ include file="../common/left-sidebar.jsp" %> 
  	<%@ include file="../common/right-sidebar.jsp" %> 
    <!-- 헤더 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" onclick="location.href='/6Days/main.me'"href="#">6Days</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
          </div>
        </div>
      </nav>
  
      <!-- 왼쪽 메뉴바 -->
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-3 col-md-2 sidebar" style="position: fixed;
													    top: 51px;
													    bottom: 0;
													    left: -5px;
													    z-index: 1000;
													    display: block;
													    padding: 20px;
													    overflow-x: hidden;
													    overflow-y: auto;
													    background-color: #f5f5f5;
													    border-right: 1px solid #eee;
													    margin-top: 2px;
													    width: 250px;">
            <ul class="nav nav-sidebar">
              <li><a href="#"onclick="location.href='aManage.ad'"  id="color_change">사용자관리 </a></li>
              <li><a href="#"onclick="location.href='report.ad'" id="color_change" style="background-color: rgb(78, 75, 75); color: white;">신고사항</a></li>
              <li><a href="#"onmouseover="over(this)" id="color_change">페이지관리</a></li>
              <li><a href="#" onmouseover="over(this)" id="color_change">설정</a></li>
            </ul>
            
         
          </div>

          
          <h2 class="sub-header" style="margin-left: 19%; font-size: 35px;">신고된 게시글
            <button style="margin-left: 70%; width: 100px; height: 30px; font-size: 19px; font-weight: lighter; 
            background: white; border: 1px solid gray; border-radius: 5px; color: black;">삭제</button>
          </h2>
          <div id ="checkAll" class="table-responsive" style="margin-left: -2%; margin-top: -2%;">
            <table class="table table-striped" id="reportlistArea" style="text-align: center; width: 70%; margin-left: 23%; margin-top: 4%;">
                <thead>
                  <tr style="font-size: 13pt;">
                      <th style="width: 7.5%; text-align: center;"><input type="checkbox" class="checkAll"></th>
                      <th style="width: 7.5%; text-align: center;">NO</th>
                      <th style="width: 20%; text-align: center;">ID</th>
                      <th style="width: 20%; text-align: center;">닉네임</th>
                     <th style="width: 15%; text-align: center;">삭제여부</th>
                      <th style="width: 15%; text-align: center;">정지유무</th>
                      <th style="width: 15%; text-align: center;">신고유무</th>
                      
                  </tr>
              </thead>
              <tbody>
              <%
                
        		for(Report r : list) {
        			
        	  %>
                <tr style="cursor: pointer;">
                <input type="hidden" value="<%= r.getUserId() %>">
                    <td><input type="checkbox" class="chkbox"></td>
                    <td><%=r.getRownum()%></td>                
                    <td><%= r.getUserId() %></td>
                    <td ><%= r.getUserName()%></td>
                    <td ><%= r.getStatus()%></td>
                    <td ><%= r.getBlockflag()%></td>
                    <td ><%= r.getReport_yn()%></td>
               </tr>        
                 <% } %>   
            </table>
          </div>
     
        </div>
    </div>
    
    
    
    <%-- 페이지 처리 --%>


  <%--   <div class="text-center" style="margin-right: -10%;">
			<button onclick="location.href='<%= request.getContextPath() %>/report.ad?currentPage=1'">&#10094;&#10094;</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/report.ad?currentPage=<%=currentPage - 1 %>'">&#10094;</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/report.ad?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/report.ad?currentPage=<%=currentPage + 1 %>'">&#10095;</button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/report.ad?currentPage=<%= maxPage %>'">&#10095;&#10095;</button>
			
		</div>
 --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   
    <script>        

    //메뉴바 선택하기 
    $(function(){
          //이벤트 연결(바인딩)
          $('#color_change').bind('mouseenter',function(){
              $(this).css({
              'background': 'rgb(15, 76, 129)', 
              'color':'white'
              });
          }).bind('mouseleave',function(){
              $(this).css({
                  'background': 'rgb(15, 76, 129)', 
                  'color':'white'
              });
          });

          //이벤트 제거
          $('#color_change').bind('click',function(){
              $(this).unbind('mouseenter').unbind('mouseleave').css({
/*                   'background': rgb(15, 76, 129), */
                  'color':'white'
              });
          });
      });

     // 전체 체크 / 체크 하나 풀렸을 때 전체 체크 해제
     window.onload = function() {
    var checkAll = document.getElementById('checkAll');
    var check = checkAll.getElementsByTagName('input');
    checkAll.addEventListener('click',function(e) {
        var target = e.target,
        checkNum = 0;
        if(target === check[0]) {
            if(target.checked) {
                for(var i=1; i<check.length; i++) {
                    check[i].checked = true;
                };
            } else {
                for(var i=1; i<check.length; i++) {
                    check[i].checked = false;
                };
             };
        } else {
            for(var i=1; i<check.length; i++) {
                if(check[i].checked) {
                    checkNum++;
                };
            };
            if(checkNum >= check.length - 1) {
                check[0].checked = true;
            } else {
                check[0].checked = false;
            };
        };
      });
    };

     // td(class=next) 클릭시 페이지 이동
     $("#reportlistArea td").click(function(){
  	  
  	 var userId = $(this).parent().find('input').val();
  	 
  	 console.log("선택한 유저 ID : "+userId);
  	 
     location.href="<%= request.getContextPath() %>/sone.rp?userId=" + userId;
    }); 
               
	</script>
</body>
</html>