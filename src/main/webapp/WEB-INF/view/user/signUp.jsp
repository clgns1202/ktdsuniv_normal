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
	<form method="post" action="<c:url value="/doSignUp"/>" style="width:400px;border:1px solid black;">
		아이디 : <input type="text" name="userId"/><br/>
		비밀번호 : <input type="password" name="userPassword"/><br/>
		이름 : <input type="text" name="userName" style="width: 100px;"/><br/>
		주민번호 : <input type="text" name="birthday" style="width: 80px;"/> - <input type="text" name="gender" id="gender" style="width: 15px;"/>******<br/>
		핸드폰 : <input type="text" name="phoneNumber"/><br/>		
		주소 : <input type="text" name="address" style="width: 300px;"/><br/>		
		<input type="submit" value="가입" /><br/>
	</form>
</body>
</html>