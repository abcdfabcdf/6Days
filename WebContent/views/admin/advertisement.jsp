<%@page import="com.sixdays.p_board.model.vo.p_Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sixdays.admin.model.vo.userManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  userManage u = (userManage)request.getAttribute("userManage");
  ArrayList<userManage> list = (ArrayList<userManage>)request.getAttribute("list"); 
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

    <!-- Bootstrap core CSS -->
    <link href="/6Days/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/6Days/resources/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
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
          <a class="navbar-brand" onclick="location.href='/6Days/main.me'" style="cursor:pointer">6Days</a>
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
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="#"onclick="location.href='aManage.ad'" id="color_change" style="background: rgb(78, 75, 75); color: white;">사용자관리 </a></li>
            <li><a href="#"onclick="location.href='report.ad'" id="color_change">신고사항</a></li>
            <li><a href="#"onclick="location.href='aminsert.ad'" id="color_change">광고 변경</a></li>
            <li><a href="#" onmouseover="over(this)" id="color_change">설정</a></li>
          </ul>
          <!-- <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href=" nm                                                                                                                                                                                                                                                                         ">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul> -->
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
 	
          <h1 class="page-header">광고 변경
  		<button style="float:right; width: 100px; height: 30px; font-size: 19px; font-weight: lighter; 
            background: white; border: 1px solid gray; border-radius: 5px; color: black;" onclick="change();">변경</button>
            </h1>   
        
          
 
          <div class="row placeholders" style="width: 90%;">
            <div class="advertisement" style="display: inline-block; float: left;">
            <div id="preview" style="margin-left:180px; margin-top: 50px; width: 300px; height: 500px; border:1px solid black; overflow: hidden;"></div>
             
            
              
              <span class="text-muted"></span>
            </div>
            <div class="advertisement" style="text-align: left; padding-right: 20px; margin-left: 120px; display: inline-block; " >
                <br><br><br>
                 <!--  <form id="advertisementForm" action="/6Days/aminsert.ad" method="post"  enctype="multipart/form-data"> -->
                <label style="font-size: 20px; font-weight: bold; padding-right: 10%;">광고이미지</label><br><br>
              <div class="filebox"> 
              <input class="upload-name" value="파일선택" disabled="disabled">
			<label for="ex_filename" id="companyimg">업로드</label> <input type="file" id="ex_filename" class="upload-hidden"> </div>
				<!-- </form> -->
                
            </div>
            <div class="col-xs-6 col-sm-3 placeholder1"  style="text-align: left; width: 30%;">
         
            </div>
          </div>

          
          </div>
          
        </div>
      
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    <style>
    .filebox input[type="file"] { 
	    position: absolute; 
	    width: 1px; 
	    height: 1px; 
	    padding: 0; 
	    margin: -1px; 
	    overflow: hidden; 
	    clip:rect(0,0,0,0); 
	    border: 0; } 
    
    .filebox label { 
	    display: inline-block; 
	    padding: .5em .75em; 
	    color: #999; 
	    font-size: inherit; 
	    line-height: normal; 
	    vertical-align: middle; 
	    background-color: #fdfdfd; 
	    cursor: pointer; 
	    border: 1px solid #ebebeb; 
	    border-bottom-color: #e2e2e2; 
	    border-radius: .25em; 
    }  
    .filebox .upload-name { 
	    display: inline-block; 
	    padding: .5em .75em;  
	    font-size: inherit; 
	    font-family: inherit; 
	    line-height: normal; 
	    vertical-align: middle; 
	    background-color: #f5f5f5; 
	    border: 1px solid #ebebeb; 
	    border-bottom-color: #e2e2e2; 
	    border-radius: .25em; 
	    -webkit-appearance: none; 
	    -moz-appearance: none; 
	    appearance: none; 
    }


    </style>
    <script>
    
   


    $(document).ready(function(){ 
    	var fileTarget = $('.filebox .upload-hidden'); 
    	fileTarget.on('change', function(){ 
    		if(window.FileReader){
    			var filename = $(this)[0].files[0].name; 
    			} else { 
    				var filename = $(this).val().split('/').pop().split('\\').pop();
    				} 
	 $(this).siblings('.upload-name').val(filename); 
	 	}); 
    });


    

    	
    
    function readInputFile(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').html("<img src="+ e.target.result +">");
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#ex_filename").on('change', function(){
        readInputFile(this);
    });
     
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
   

      //이벤트 제거
      $('#color_change').bind('click',function(){
          $(this).unbind('mouseenter').unbind('mouseleave').css({
              'background': rgb(15, 76, 129),
              'color':'white'
   		       });
      		});
  });
  		
    
    </script>
  </body>
</html>
