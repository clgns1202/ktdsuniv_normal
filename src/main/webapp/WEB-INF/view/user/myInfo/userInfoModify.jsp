<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" >
	$().ready(function(){
		$("#userPassword").hide();
		$("#passwordConfirm").hide();
		

		$("#modifyPassword").click(function() {
		            $("#userPassword").show();
		            $("#passwordConfirm").show();
		            
		            $("#passwordConfirm").click(function(){
		                    
		                $.post("<c:url value='/user/userPasswordConfirm'/>", {"userPassword" : $("#userPassword").val()} ,function(data){
		                    if(data == true){
		                    	win();
		                    }
		                    else{
		                        alert("비밀번호가 틀렸습니다.")
		                    }
		                });
		            });
		 });
		
	});
	
	function win(){
		window.open("<c:url value="/user/userPassword"/>", "", "width=400, height=300, status=1 ,scrollbars=1");
	}

</script>
</head>
	<h1>내정보</h1>
	
	<div>
	
		<div style="display:inline-block;">
				<h3>회원정보<br/></h3>
					<form method="post" action="<c:url value="/user/doUserInfoModify"/>">
						<input type="hidden" name="id" value="${user.id}">
						이름:<input type="text" name="userName"value="${user.userName}"><br/>
						전화번호:<input type="text" name="phoneNumber"value="${user.phoneNumber}"><br/>
						주소:<input type="text" name="address" value="${user.address}"><br/>
						<input type="submit" value="수정하기">
					</form>
					<input type="button" value="회원탈퇴" onclick="location.href='<c:url value="/user/withDrawal"/>'">
		</div>	
		<input type="button" id="modifyPassword"value="비밀번호변경">
		<input type="password" id="userPassword" placeholder="비밀번호를 입력하세요"/>
		<input type="button" id="passwordConfirm" value="확인" />
		<div style="display:inline-block;">
			<a href="<c:url value="/user/userHistory"/>">
					<h3>회원기록<br/></h3>
				</a>
		</div>		
				
	</div>
	<br/>
	</hr>
</html>