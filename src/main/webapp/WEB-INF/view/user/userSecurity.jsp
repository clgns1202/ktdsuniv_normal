<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<c:url value="/user/userSecurity"/>">
		현재 아이디	: <input type="text" value="${userId}" readonly="readonly">
		현재 비밀번호 확인 :<input type="text" name="userPassword" />	
		<input type="submit" value="확인">
	</form>
	
</body>
</html>