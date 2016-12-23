<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" >
	$().ready(function(){
		$("#confirm").click(function(){
			$.post("<c:url value='/user/userPasswordModify'/>",{userPassword:$("#userPassword").val()},function(data){
				if(data==true){
					window.close();
				}
			});
		});
	});
</script>
</head>
<body>
	변경할 비밀번호를 입력하세요</br>
	비밀번호변경 : <input type="password" id="userPassword" name="userPassword"/>
	<input type="button" id="confirm" value="확인" />

</body>
</html>