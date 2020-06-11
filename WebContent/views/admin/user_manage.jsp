<%@page import="com.sixdays.admin.model.service.adminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sixdays.admin.model.vo.*,com.sixdays.board.model.vo.*"%>
    
<%
		ArrayList<userManage> list = (ArrayList<userManage>)request.getAttribute("list"); 
		PageInfo pi = (PageInfo)request.getAttribute("pi");
		int listCount = pi.getListCount();
		int currentPage = pi.getCurrentPage();
		int maxPage = pi.getMaxPage();
		int startPage = pi.getStartPage();
		int endPage = pi.getEndPage();
		
		adminService as = new adminService();
		int Rnumber = as.getListCount();
		
		
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
    <title>사용자 관리</title>
    <script src="<%= request.getContextPath() %>/resources/js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="/6Days/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/6Days/resources/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            <a class="navbar-brand"  onclick="location.href='/6Days/main.me'" style="cursor:pointer">6Days</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <!-- <ul class="nav navbar-nav navbar-right">
              <li><a href="#">Dashboard</a></li>
              <li><a href="#">Settings</a></li>
              <li><a href="#">Profile</a></li>
              <li><a href="#">Help</a></li>
            </ul> -->
            <!-- <form class="navbar-form navbar-right">
              <input type="text" class="form-control" placeholder="Search...">
            </form> -->
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
              <li><a href="#"onclick="location.href='aManage.ad'" id="color_change" style="background: rgb(78, 75, 75); color: white;">사용자관리 </a></li>
              <li><a href="#"onclick="location.href='report.ad'" id="color_change">신고사항</a></li>
              <li><a href="#"onmouseover="over(this)" onclick="location.href='/6Days/views/admin/Advertising.jsp'"  id="color_change">광고관리</a></li>
              <li><a href="#" onmouseover="over(this)" id="color_change">설정</a></li>
            </ul>
            <!-- <ul class="nav nav-sidebar">
              <li><a href="">Nav item</a></li>
              <li><a href="">Nav item again</a></li>
              <li><a href="">One more nav</a></li>
              <li><a href="">Another nav item</a></li>
              <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
              <li><a href="">Nav item again</a></li>
              <li><a href="">One more nav</a></li>
              <li><a href="">Another nav item</a></li>
            </ul> -->
          </div>

          <h2 class="sub-header" style="margin-left: 19%; font-size: 35px;">사용자관리
           
          </h2>
          <div id ="checkAll" class="table-responsive" style="margin-left: -2%; margin-top: -2%;">
            <table class="table table-striped" id="mangelistArea" style="text-align: center; width: 70%; margin-left: 23%; margin-top: 4%;">
                <thead>
                  <tr style="font-size: 13pt;">
                     
                      <th style="width: 7%; text-align: center;">NO</th>
                      <th style="width: 20%; text-align: center;">ID</th>
                      <th style="width: 20%; text-align: center;">닉네임</th>        
                      <th style="width: 10%; text-align: center;">게시물수</th>
                      <th style="width: 20%; text-align: center;">가입일</th>
                      <th style="width: 8%; text-align: center;">사용여부</th>
                  </tr>
              </thead>
              <tbody>
              <%
                int num = 0;
        		for(userManage u : list) {
        			num++;
        	  %>
                <tr style="cursor: pointer;">
                	<input type="hidden" value="<%= u.getUserId() %>">
                    <td><%=num%></td>                
                    <td><%= u.getUserId() %></td>
                    <td ><%= u.getUserName()%></td>
                    <td ><%= u.getpCount()%></td>
                    <td ><%= u.getEnrolldate()%></td>
                    <td ><%= u.getDelflag()%></td>
               
                </tr>        
                 <% } %>   
              </tbody>
            </table>
          </div>
        </div>
    </div>
  

    <!-- <div class="text-center" style="margin-right: -10%;">
        <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
      </ul>
    </div> -->
    
    <%-- 페이지 처리 --%>
		<div class="text-center" style="margin-right: -10%;">
			<button onclick="location.href='<%= request.getContextPath() %>/aManage.ad?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/aManage.ad?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/aManage.ad?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/aManage.ad?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/aManage.ad?currentPage=<%= maxPage %>'">>></button>
			
		</div>
   
     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- <script src="../../dist/js/bootstrap.min.js"></script> -->
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <!-- <script src="../../assets/js/vendor/holder.js"></script> -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <!-- <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->

    <script>        
      //메뉴바 선택하기 
      $(function(){
            //이벤트 연결(바인딩)
            $('#color_change').bind('mouseenter',function(){
                $(this).css({
                'background': rgb(15, 76, 129),
                'color':'white'
                });
            }).bind('mouseleave',function(){
                $(this).css({
                    'background': rgb(15, 76, 129),
                    'color':'white'
                });
            });

            //이벤트 제거
            $('#color_change').bind('click',function(){
                $(this).unbind('mouseenter').unbind('mouseleave').css({
                    'background': rgb(15, 76, 129),
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
      $("#mangelistArea td").click(function(){
    	  
    	 var userId = $(this).parent().find('input').val();
    	 
    	 console.log(userId);
    	 
       location.href="<%= request.getContextPath() %>/mSelectOne.ad?userId=" + userId;
      });

    </script>
</body>
</html>