<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sixdays.board.model.vo.*, java.util.*" %>
<%
   Board b = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href ="/6Days/resources/css/boardWrite.css">
    <script src="/6Days/resources/js/ckeditor/ckeditor.js"></script>
    <script src="/6Days/resources/js/ckeditor/readonly.js"></script>
    <style>
    #cke_1_bottom {
    display:none;
    }
    
    #cke_1_top{
    display:none;
    
    }
    body{
       font-family: 'Jua', sans-serif;

    }
    
    .board-type {
    width: 63px !important;
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
    </style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/left-sidebar.jsp" %>
<%@ include file="../common/right-sidebar.jsp" %>

   <div id ="boardArea" style="background:white;">
      <label id="board-title">공지사항 내용</label>
            <input type="reset" class="board-button" onclick="location.href='selectList.bo'" value="뒤로" >
      <% if(m.getUserId().equals("admin")) {%>
            <input type="submit" class="board-button" onclick="location.href='bUpdateView.bo?bno=<%=b.getBno()%>'" value="수정">
      <%} %>   
          <div id="board-area">
            <table id="boardWrite"> 
              <tr>
                <td class="board-type">구분</td>
                <td class="board-value" colspan="3" style="float:left; margin-left:15px;">공지
                </td>
              </tr>
              
              <tr>
                <td class="board-type">제목</td>
                <td class="board-value" colspan="3">
                <%= b.getBtitle() %></td>
              </tr>
              <tr>
                <td class="board-type">작성자</td>
                <td class="board-value" style="width:265px;">
                admin</td>
                
                <td class="board-type" style="width: 63px;">작성일</td>
                <td class="board-value" style="width:265px;">
                  <%= b.getBdate() %></td>
                  
              </tr>
              <tr>
                <td class="board-type" style="border-bottom: 1px solid whitesmoke;">첨부파일</td>
                
                <td class="board-value" colspan="3" style="border-bottom: 1px solid whitesmoke;">
              <% if(b.getBoardfile() != null && b.getBoardfile().length() > 0) { %>
                <a href="/6Days/bfdown.bo?path=<%=b.getBoardfile() %>"><%=b.getBoardfile() %> 
                     </a>
              <% } %>
                </td>
              </tr>
             
              <tr style="height: 300px;">
                <td class="board-type" style="margin-left: 10px; border-radius: 10px; font-size : 25px !important">내용</td>
          <td colspan='3'>
             <textarea id="ckeditor" name="content" style="float:left;"><%= b.getBcontent() %></textarea>
             <%-- <div style="overflow-y:auto;  height:300px; width:663px"><%= b.getBcontent() %></div> --%>
          </td>
          </div>
        </div>
        
         <script>
           CKEDITOR.replace('ckeditor'
                , {height: 300,
                readOnly:true
                

                
                 }
                );

        </script>
   </body>
</html>