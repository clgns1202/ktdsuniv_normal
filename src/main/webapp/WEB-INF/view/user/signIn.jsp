<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<a href="<c:url value="/signUp"/>">회원가입</a>
	
	<form method="post" action="<c:url value="/doSignIn"/>">
		아이디 : <input type="text" name="userId" id="userId" /><br/>
		비밀번호 : <input type="password" name="userPassword" id="userPassword" /><br/>	
		<input type="submit" value="로그인" /><br/>
	</form>
<jsp:include page="../common/footer.jsp"></jsp:include>