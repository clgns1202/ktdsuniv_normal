<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"></jsp:include>
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
		
		<br/>
		<a href="<c:url value="/signOut"/>">로그아웃</a>
				
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>