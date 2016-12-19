<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내정보</h1>
	
	<div>
	
		<div>
				<a href="<c:url value="/user/userInfo"/>">
					회원정보 
				</a>
				<a href="<c:url value="/user/userLecture"/>">
					내 강의<br/>
				</a>
					유저성명 : ${user.userName}<br/>
					<br/>
		</div>
		
				
	</div>
	<br/>
	</hr>
	
	
</body>
</html>