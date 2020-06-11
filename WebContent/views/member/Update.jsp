<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>수정</title>

    
    <link rel="stylesheet" href="/6Days/resources/css/Update.css">
    
    <%@ include file="/views/common/header.jsp" %>
   <%@ include file="/views/common/left-sidebar.jsp" %>
   <%@ include file="/views/common/right-sidebar.jsp" %>
   
   <style>
   #password{
       margin-left: 15%; 
       margin-right: 15%;
      }
    #deletebtn{
	    float:right; 
	    background:rgb(15, 76, 129); 
	    color:white; 
	    border-color:rgb(15, 76, 129);
	    height: 30px;
	    width: 100px;
    }
    #pwdchkbtn{
    	 background:rgb(15, 76, 129); 
	    color:white; 
	    border-color:rgb(15, 76, 129);
	    height: 30px;
	    width: 100px;
    }
   </style>
	
</head>
<body>
           <form action="/6Days/change.me" method="post">
           <input type="hidden" name="userid" value="<%=m.getUserId() %>">
      <div id="updatepage" style="background: white;">
              
         <input type="button" id="deletebtn"  value="회원탈퇴" style="cursor:pointer;">
        <div id="idupdate">
           <h1 style="text-align:center">개인 정보 변경</h1>
            <label>아이디</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" id="idok" class="redata" placeholder="아이디" name=idcheck value=<%=m.getUserId() %> readonly>
            <br><br>
        </div>
       <div id="passwordcheck">
       
       <label style="margin-left:11%">현재 비밀번호</label>&nbsp;&nbsp;&nbsp;
       <input type="password" class="redata" id="pwdchk" name="pwdchk" placeholder="현재 비밀번호를 입력해주세요."  onchange="pwdchk1()" style="width:345px;"> &nbsp;&nbsp;
        <input type="button"id="pwdchkbtn" onSubmit="return false" value="비밀번호 확인" style="cursor:pointer;"><br><br>
       </div>
      <div id="password"> 
         <label>비밀번호</label>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="password" class="redata" id="pwd1" placeholder="비밀번호를 입력해주세요(8~16자)." onchange="pwdCheck();" style="margin-left: -1%;"><br><br>
         <input type="password" class="redata" id="pwd2" name="password" placeholder="비밀번호를 다시 입력해주세요." onchange="change();" style="margin-left: 12%;"/><br><br>
         <label id="pwdresult" style="font-size:xx-small;"></label><br><br>
      </div>
        <div id="email">
            <label>이메일</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" class="redata" id="email1" name="email1" placeholder="이메일을 입력해주세요." onchange="change(); emailCheck();"/><br><br>
        </div>
        <div id="phone">
            <label>전화번호</label>&nbsp;&nbsp;&nbsp;
            <input type="text" id="auth" class="redata" name="phone" placeholder="전화번호" maxlength="13" onchange="change(); phoneCheck();"/><br><br><br><br>

            
        </div>

        <div id="rebtn">
            <button id="updatebtn" onclick="return pwdconfirm();">변경</button>
        </div>

    
    </div>
    </form>
    <div id="bottom"></div>
    <script>

    var phone = document.getElementById('auth');
    var email = document.getElementById('email1');
    var pwd = document.getElementById('pwd2');
    var button = document.getElementById('updatebtn');
    var result = 0;
    
    window.onload = function(){ //초기버튼 누르지않게 함
        
        
        button.disabled = true;
        button.style.opacity = 0.2;
        button.style.cursor = 'not-allowed';
     
     }
    function pwdconfirm(){ //비밀번호 일치여부 확인(현재 > 바꿀)
    	if(result == '1'){
    		alert("회원 정보가 변경되었습니다.");
    		return true;
    	}else if(result == '0'){
    		alert("비밀번호 일치여부를 확인하세요.");
    		return false;
    	}
    }
    
    function pwdchk1(){
    	result='0';
    }
    
    function change(){ //값이 들어가있는지 확인
        
        
        if(phone.value != "" && email.value != "" && pwd.value != "")
        {
           button.disabled = false;
           button.style.opacity = 1;
           button.style.cursor = 'pointer';
     
        }else{
           button.disabled = true;
           button.style.opacity = 0.2;
           button.style.cursor = 'not-allowed';
        }

     
     }
    
    $(function(){ //비밀번호 일치여부
        $('#pwd2').change(function(){
            if($('#pwd1').val() == $(this).val()){
                $('#pwdresult').html("");
            }else{
                $('#pwdresult').html("비밀번호 확인 값이 일치하지 않습니다.").css('color','red');
                $('#pwd2').val('');
                $(this).select();
            }
        });      
    });
    
     
     
     function CheckEmail(str) //이메일 확인
     {                                                 
          var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
          if(!reg_email.test(str)) {
             
               return false;         
          }                            
          else {                       
               return true;         
          }                            

          
     } 
     
     function pwdCheck(){ //패스워드 유효성 검사
         
    	   var passRule = /^[A-Za-z0-9]{8,16}$/;//숫자와 문자 포함 형태의 8~16자리 이내의 암호 정규식
    	   
    	   var pwd = document.getElementById("pwd1");
    	   
    	   if(!passRule.test(pwd.value)) {
    	       //경고
    	       alert("비밀번호를 다시 입력하세요.");
    	       pwd.value="";
    	       pwd.focus();    	       
    	   
    	     }
    	   }
     function emailCheck(){ //이메일 유효성 검사
        var obEmail = document.getElementById("email1"); //이메일 확인
        if (!obEmail.value) {             
           alert("이메일을 입력하세요!");
           obEmail.focus();   
           return false;
        }               

        else   {          
           if(!CheckEmail(obEmail.value))   {
              alert("이메일 형식이 잘못되었습니다");
              obEmail.focus();
              obEmail.value="";
              return false;

           }                

        }  
     }
     
     function pwdCheck(){ //패스워드 유효성 검사
         
          var passRule = /^[A-Za-z0-9]{8,16}$/;//숫자와 문자 포함 형태의 6~12자리 이내의 암호 정규식
          
          var pwd = document.getElementById("pwd1");
          
          if(!passRule.test(pwd.value)) {
              //경고
              alert("비밀번호를 다시 입력하세요.");
              pwd.value="";
              pwd.focus();
          
            }
          }
     
     function phoneCheck(){ //휴대폰 유효성 검사
         
         var rgEx = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

         
         var phone = document.getElementById("auth");
         
         if(!rgEx.test(phone.value)){
            
            alert("휴대폰 번호를 다시 입력하세요.");
            phone.value="";
            phone.focus();
         }
      }

    
    $('#auth').keydown(function(event) { //비밀번호 체크
        var key = event.charCode || event.keyCode || 0;
        $text = $(this);
        if (key !== 8 && key !== 9) {
            if ($text.val().length === 3) {
                $text.val($text.val() + '-');
            }
            if ($text.val().length === 8) {
                $text.val($text.val() + '-');
            }
        }
     
        return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));          
    });
    
    $("#pwdchkbtn").click(function(){ //비밀번호 확인 여부
        
        var pwdchk = $('#pwdchk').val();
        var pwdchk2 = "<%=m.getUserpwd()%>";

        $.ajax({
           url:"/6Days/pwdchk.me",
           type:"post",
           data:{pwdchk: $('#pwdchk').val()},
           success:function(data){

     	  	if(data == pwdchk2){
         		alert("비밀번호가 일치합니다.");
         		result='1';
         		
         		
         	}else{
         		alert('비밀번호를 다시 입력해주세요.');
         		result='0';
         	} 
           },error:function(){
              console.log("Error 입니다.");
           }
        });
     });
    
 $("#deletebtn").click(function(){ //비밀번호 확인
	if(result =='1' && confirm("회원 탈퇴하시겠습니까?")){
	
        $.ajax({
           url:"/6Days/deleteMember.me",
           type:"post",
           data:{userid: $('#idok').val()},
           success:function(data){
			
     		alert("정상적으로 탈퇴되었습니다.");
     		location.href="/6Days/login.jsp";
     		
           },error:function(){
              console.log("Error 입니다.");
           }
        });
	}else if(result =='0'){
		alert("현재 비밀번호를 확인해주세요.")
	}
     });
    </script>
</body>
</html>