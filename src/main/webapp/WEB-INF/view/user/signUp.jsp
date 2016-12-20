<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	if("${param.errorCode}" == 1){
		alert("아이디가 중복됩니다");
	}
</script>
</head>

<body>
	<a href="<c:url value="/signIn"/>">로그인페이지로</a>
	
	<form method="post" action="<c:url value="/doSignUp"/>">
		아이디 : <input type="text" name="userId" id="userId" /><br/>
		비밀번호 : <input type="password" name="userPassword" id="userPassword" /><br/>
		이름 : <input type="text" name="userName" id="userName" style="width: 100px;"/><br/>
		주민번호 : <input type="text" name="birthday" id="birthday" style="width: 80px;"/> - <input type="text" name="gender" id="gender" style="width: 15px;"/>* * * * * *<br/>
		핸드폰 : <input type="text" name="phoneNumber" id="phoneNumber" /><br/>		
		주소 : <input type="text" name="address" id="address" style="width: 500px;"/><br/>		
		<input type="submit" value="가입" />
		<input type="reset" value="다시 작성" />
	</form>
</body>
</html>