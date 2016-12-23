<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript">
	$().ready(function(){
		$("#confirm").click(function(){
			
			if(confirm("정말로 탈퇴 하시겠습니까?")){
				$.post("<c:url value='/user/userPasswordConfirm'/>" ,{ "userPassword" : $("#userPassword").val()} , function(data){
					if(data==true){
						location.href="<c:url value='/user/doUserWithdrawal'/>"
					}
					else{
						alert("비밀번호가 틀리셨습니다.");
					}
				});
			}
			else{
				
			}
			
		})
	})
</script>

	비밀번호 :<input type="password" id="userPassword" name="userPassowrd" />
	<input type="button" id="confirm"value="확인"/>
	
<jsp:include page="../common/footer.jsp"></jsp:include>