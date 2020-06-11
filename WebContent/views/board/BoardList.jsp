<%@page import="com.sixdays.board.model.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sixdays.board.model.vo.*"%>
    
<%
		ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list"); 
		PageInfo pi = (PageInfo)request.getAttribute("pi");
		int listCount = pi.getListCount();
		int currentPage = pi.getCurrentPage();
		int maxPage = pi.getMaxPage();
		int startPage = pi.getStartPage();
		int endPage = pi.getEndPage();
		
		BoardService bs = new BoardService();
		
		String category = (String)request.getAttribute("category");
		String keyword = (String)request.getAttribute("keyword");
    %>
<!DOCTYPE html>
<html>
<head>
  <title>Insert title here</title>
    <script src="<%= request.getContextPath() %>/resources/js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href ="/6Days/resources/css/boardlist.css">


  <style>
    body{
       font-family: 'Nanum Gothic Coding', monospace;

    }
    #g_title{
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

  </style>
</head>
   <body>
   <%@ include file="../common/header.jsp" %> 
   <%@ include file="../common/left-sidebar.jsp" %> 
   <%@ include file="../common/right-sidebar.jsp" %> 

    
<!--    작성자 : 윤석훈
        작성일 : 2020-01-14
        내용 : 게시판 임시 제작 -->
        <div id="boardArea" style="background: white; height:700px;">
        <table class="table table-striped" id="listArea">
         <thead>
          <label id="g-title" onclick="location.href='/6Days/selectList.bo'" style="cursor : pointer;"> 공지사항</label>
            <tr>
            	
                <th style="width:70px;">번호</th>
                <th style="width:430px; text-align: center">제목</th>
                <th style="text-align:center; width:160px;">작성자</th>
                <th style="text-align:center; width:130px;">작성일</th>
                <th style="width:70px;" >조회수</th>
            </tr>
        </thead>
        <tbody>
        <%
        	for(Board b : list) {
        %>
		<tr>
        <input type="hidden" value="<%= b.getBno() %>">
        <td><%= b.getRnum()%></td>
        <td><%= b.getBtitle() %></td>
        <td><%= b.getBwriter() %></td>
        <td><%= b.getBdate() %></td>
        <td><%= b.getBcount() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

		   <hr/>
		
		   <% if(m.getUserId().equals("admin")){ %>
		   <a class="btn btn-default pull-right" 
		       onclick="location.href='/6Days/views/board/BoardInsertForm.jsp'">글쓰기</a>
		   <% } %>
    
	    <%-- 페이지 처리 --%>
			<div class="text-center" align="center">
			<% if (category == null && keyword == null) { %>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=1'"><<</button>
				<% } %>
				
				<%  if(currentPage <= 1){  %>
				<button style="cursor:pointer;" disabled><</button>
				<%  } else if(category == null && keyword == null){ %>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>'"><</button>
				<%  } else{%>
					<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/bSearch.bo?currentPage=<%=currentPage - 1 %>&con=<%=category%>&keyword=<%=keyword%>'"><</button>
				<%}%>
				
				<% for(int p = startPage; p <= endPage; p++){
						if(p == currentPage){	
				%>
					<button style="cursor:pointer;" disabled><%= p %></button>
				<%  }else if(category == null && keyword == null){%>
					<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= p %>'"><%= p %></button>
				<% }else{ %>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/bSearch.bo?currentPage=<%= p %>&con=<%=category%>&keyword=<%=keyword%>'"><%=p %></button>				
				<%      } %>
				<% } %>
					
				<%  if(currentPage >= maxPage){ %>
				<button style="cursor:pointer;" disabled>></button>
				<%  }else if(category == null && keyword == null){%>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage + 1 %>'">></button>
				<%  }else{ %>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/bSearch.bo?currentPage=<%= currentPage + 1 %>&con=<%=category%>&keyword=<%=keyword%>'">></button>
				<%  } %>
				
				<% if (category == null && keyword == null) { %>
				<button style="cursor:pointer;" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= maxPage %>'">>></button>
				<% } %>
	
				
			</div>

			<div class="searchArea" align="center" style="margin-top: 10px;
    padding-left: 75px;">
				<select id="searchCondition" name="category" style="display: inline-block;
    height: 25px;">
					<option value="writer" id="writer">작성자</option>
					<option value="title" id="title">제목</option>
				</select>

    	<% if(keyword != null) {%>
    		<input type="text" id="keyword" name="keyword" value='<%=keyword %>' placeholder="검색할 내용을 입력하세요" style="line-height: 20px; width: 300px; display: inline-block;">
   		<%}else{%>
    	<input type="text" id="keyword" placeholder="검색할 내용을 입력하세요" style="line-height: 20px; width: 300px; display: inline-block;">
   		<%} %>
    	
    	<a class="btn btn-defalut" 
    	onclick="location.href='<%=request.getContextPath()%>/bSearch.bo?con='+$('#searchCondition').val()+'&keyword='+$('#keyword').val()" 
    	style="cursor: pointer; display: inline-block; font-size: 18px; margin: 5px 0 0 5px;">검색 </a>
		</div>

	</div>
	
	<script>  
		$(document).ready(function(){
		
			  $("#title").each(function(){
		
			    if($("#title").val()=="${category}"){
			      $("#title").attr("selected","selected"); 
			    }
			  });
			});
	
	
		$(function(){
			
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"skyblue", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"whitesmoke"});
			}).click(function(){
				/* console.log($(this).parent().find('input').val()); */
				var bno = $(this).parent().find('input').val();
				location.href="<%= request.getContextPath() %>/bSelectOne.bo?bno=" + bno;
			});
		});
				
</script>
</body>
</html>