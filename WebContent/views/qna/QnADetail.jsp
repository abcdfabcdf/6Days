<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sixdays.qna.model.vo.*, java.util.*, com.sixdays.qnacomment.model.vo.*" %>
<%
	QnA q = (QnA)request.getAttribute("qna");
	/* QnAComment qc = (QnAComment)request.getAttribute("qnacomment"); */
	ArrayList<QnAComment> clist = (ArrayList<QnAComment>)request.getAttribute("clist");
	System.out.println("Ddddddddddddddddddd!!!!!!!!!!!!!!!! clist : " + clist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href ="/6Days/resources/css/boardWrite.css">
    <style>
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
	<% if(m != null) { %>
	<div id ="boardArea" style="background:white;">
      <label id="board-title">QnA 내용</label>
            <input type="reset" class="board-button" onclick="location.href='selectList.qo'" value="뒤로" >
      <% if(q.getQwriter().equals(m.getUserId())){ %>
            <input type="submit" class="board-button" onclick="location.href='qUpdateView.qo?qno=<%=q.getQno()%>'" value="수정">
            <%} %>
          <div id="board-area">
            <table id="boardWrite"> 
              <tr>
                <td class="board-type">구분</td>
                <td class="board-value" colspan="3" style="float : left; margin-left:15px;"><%= q.getQtype() %>
                </td>
              </tr>
              
              <tr>
                <td class="board-type">제목</td>
                <td class="board-value" colspan="3">
                <%= q.getQtitle() %></td>
              </tr>
              <tr>
                <td class="board-type">작성자</td>
                <td class="board-value" style="width:265px;">
                <%= q.getQwriter() %></td>
                
                <td class="board-type" style="width: 63px;">작성일</td>
                <td class="board-value" style="width:265px;">
               	<%= q.getQdate() %></td>
               	
              </tr>
              <tr>
                <td class="board-type" style="border-bottom: 1px solid whitesmoke;">첨부파일</td>
                
                <td class="board-value" colspan="3" style="border-bottom: 1px solid whitesmoke;">
              <% if(q.getQnafile() != null && q.getQnafile().length() > 0) { %>
                <a href="/6Days/qfdown.qo?path=<%=q.getQnafile() %>"><%=q.getQnafile() %> 
							</a>
              <% } %>
                </td>
              </tr>
            
              <tr style="height: 300px;">
                <td class="board-type" style="margin-left: 10px; border-radius: 10px; font-size : 25px !important">내용</td>
                <td colspan="3" style="float:left; border-style : none; font-size : 16px;">
              	<%= q.getQcontent() %></td>            
              </table><br><br>
              
              <form action="InsertComment.qo" method="post">
              		<input type="hidden" name="cwriter" value="<%=m.getUserId()%>"/>
					<input type="hidden" name="qno" value="<%=q.getQno() %>" />
					<input type="hidden" name="refcno" value="0" />
					<input type="hidden" name="clevel" value="1" />
              		
              <table style="margin-left:3.8%">
              <tr>
              	<td colspan="3" style="float:left">댓글작성</td>
              	
              </tr>
              <tr>
              	<td colspan="3"><textarea name ="ccontent" style="width: 700px; height: 40px; resize:none;" placeholder="댓글 입력란 입니다"></textarea><td>
              	<td width="60px"><button type="submit" style="margin-left: -40%; width:60px; height:46px; margin-bottom: 10%;">작성</button>
              </tr>
              <tr><td colspan="3"><hr></td><tr>
              </table>
              </form>
           <% if(clist != null) { %>
           		<% for(QnAComment qco : clist) {
           			%>
  
 <!-- ************************************************************************************************ -->          			
           <div id="coment00">			
              <table>
              <tr>
	             <td id="pofileimgbox0001" rowspan="2">
	                <div id="profileimg000">
						     <img id="profileimg00" src="/6Days/resources/proimgUploadFiles/<%= qco.getCproimg() %>">
	                </div>
	             </td>
	             
	             <td id="userIdText" ><%=qco.getCwriter() %></td>
	             <td id="comentsInsertDate"><%= qco.getCdate()  %></td>
              </tr>
              
              <tr>
              	<td colspan="2"><textarea id="innerComments" readonly="readonly"><%=qco.getCcontent() %></textarea></td>
              </tr>
              
			  <tr>
				  <td id="btns000">
				  <% if(m.getUserId().equals(qco.getCwriter())) { %>
					<input type="hidden" name ="cno" value="<%=qco.getCno()%>"/>
					<button class="updatebtn" style="float:left;" onclick="updateReply(this);">수정</button>
					<button class="updatedelete" style="float:right;" onclick="deleteReply(this);">삭제</button>
					<button class="updateConfirm" style="float:left; display:none;" onclick="updateConfirm(this);">수정완료</button>
					<button class="updateback" style="float:right; display:none;" onclick="updateback(this);">뒤로</button>
				  <% } %>
				  </td>
			  </tr>
              </table>
           </div>   
			<% } %>	
		<% } %>
<!-- ************************************************************************************************ -->
              
              
          </div>
        </div>
        <script>
        function updateback(obj) {
    		$(obj).parent().parent().prev().find('textarea').attr('readonly');
        	$(obj).css('display', 'none'); // 뒤로 가기 버튼 안보이게
        	$(obj).siblings('.updateConfirm').css('display', 'none'); // 수정완료 버튼 숨기기
        	
        	$(obj).siblings('.updatebtn').css('display', 'inline');
    		$(obj).siblings('.updatedelete').css('display', 'inline');
    		
        }
    	function updateReply(obj) {
    		// 현재 위치와 가장 근접한 textarea 접근하기

    		$(obj).parent().parent().prev().find('textarea').removeAttr('readonly');
    		// 수정 완료 버튼을 화면 보이게 하기
    		$(obj).siblings('.updateConfirm').css('display','inline');
    		$(obj).siblings('.updateback').css('display','inline');
    		
    		// 수정하기 버튼 숨기기
    		$(obj).css('display', 'none');
    		$(obj).siblings('.updatedelete').css('display', 'none');
    	}
    	
    	function updateConfirm(obj) {
    		// 댓글의 내용 가져오기
    		var ccontent
    		  = $(obj).parent().parent().prev().find('textarea').val();
    		
    		// 댓글의 번호 가져오기
    		var cno = $(obj).siblings('input').val();
    		
    		// 게시글 번호 가져오기
    		var qno = '<%=q.getQno()%>';
    		
    		location.href="/6Days/UpdateComment.qo?cno="+cno+"&qno="+qno+"&ccontent="+ccontent;
    	}
    	
    	function deleteReply(obj) {
    		// 댓글의 번호 가져오기
    		var cno = $(obj).siblings('input').val();
    		
    		// 게시글 번호 가져오기
    		var qno = '<%=q.getQno()%>';
    		
    		location.href="/6Days/DeleteComment.qo?cno="+cno+"&qno="+qno;
    	}
    	</script>
    	<% } else {
    		request.setAttribute("msg", "회원만 가능한 서비스 입니다.");
    		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
    	}
    	%>
	</body>
</html>