<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href ="/6Days/resources/css/boardWrite.css">
    <script src="/6Days/resources/js/ckeditor/ckeditor.js"></script>
    <script src="/6Days/resources/js/ckeditor/config.js"></script>
    <style>

    body{
       font-family: 'Jua', sans-serif;
    }
    
    #boardArea {
    width: 918px;
    height: 100%;
    margin-left: 1.8%;
    align-content: center;
    padding: 15px;
    padding-top: 100px;
    text-align: center;
    margin: 0px auto;
}
	.cke_chrome {
		margin-left : 13px !important;
	}
    </style>

</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/left-sidebar.jsp" %>
<%@ include file="../common/right-sidebar.jsp" %>

<form action = "<%= request.getContextPath() %>/bInsert.bo" method="post" enctype="multipart/form-data">
	<div id ="boardArea" style="background:white;">
	      <label id="board-title">게시물 작성</label>
            <input type="reset" class="board-button" onclick="location.href='/6Days/selectList.bo'" value="취소" >
            <input type="submit" class="board-button" onclick="location.href='selectList.bo'" value="작성">
          <div id="board-area">
            <table id="boardWrite"> 
              <tr>
                <td class="board-type">구분</td>
                <td class="board-value" colspan="3" style="float: left; margin-left:15px;">
                <label>공지</label>
                </td>
              </tr>
              
              <tr>
                <td class="board-type">제목</td>
                <td class="board-value" colspan="3">
                <input type="text" id="board-subject" name="title" ></td>
              </tr>
              
              <tr>
                <td class="board-type">작성자</td>
                <td class="board-value" style="width:265px;" >
                <input name="writer" style="float: left;
   				 margin-left: 13px; height: 20px;" value="<%=m.getUserId() %>" readonly/></td>
                
                <td class="board-type" style="width:121px; visibility: hidden;">작성일</td>
                <td class="board-value" style="width:265px; border-style: none;height: 20px;">
                <input type="hidden" name="date"></td>
                
              </tr>
              <tr>
                <td class="board-type">첨부파일</td>
                <td class="board-value" colspan="3" >
                <input type="file" name="boardfile" id="boardfile" style="float:left; margin-left:13px; ">
                </td>

              </tr>
              <tr id="boardcontent">
                <td style="border-radius: 10px;">내용</td>
                <td colspan="3" style="background : white;">
                <textarea id="ckeditor" name="content" style="float:left;"></TEXTAREA></td>
              </tr>
            </table>
          </div>
        </div>
        </form>
        
        <script>
        CKEDITOR.replace('ckeditor'
                , {height: 300
        		
                 });

        </script>
	</body>
</html>