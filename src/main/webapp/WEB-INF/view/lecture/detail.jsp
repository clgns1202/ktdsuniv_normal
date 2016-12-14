<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
	$().ready(function() {
		
		$("#applyBtn").click(function () {
			location.href="<c:url value="/lecture/apply/${lecture.id}"/>";
		});
		
		$("#applyCancelBtn").click(function () {
			location.href="<c:url value="/lecture/applyCancel/${lecture.id}"/>";
		});
		
	});
	
</script>
</head>
<body>
	<h1>${lecture.lectureName}</h1>
	<h5>강사: ${lecture.instructor.user.userName}</h5>
	<h5>관리자: ${lecture.admin.user.userName}</h5>
	<h5>호실: ${lecture.room.roomNumber}</h5>
	<h5>기간: ${lecture.startDate} - ${lecture.endDate} </h5>
	<h5>강의시간: ${lecture.startTime} - ${lecture.endTime}</h5>
	<hr/>
	<h4>${lecture.lectureContent}</h4>
	
	
	
	<c:forEach items="${lecture.user}" var="users">	
	
		<c:if test="${users.userName eq sessionScope._USER_.userName}">
			<c:set var="doneLoop" value="true" />
				<c:if test="${users.userName ne sessionScope._USER_.userName}">
				<c:set var="doneLoop" value="false" />
				</c:if>
		</c:if>

	</c:forEach>

	
 	<c:choose>
			<c:when test="${doneLoop eq true}">
					<input type="button" id="applyCancelBtn" name="applyCancelBtn" value="강의 취소" />
			</c:when>
			
			<c:otherwise>
					<input type="button" id="applyBtn" name="applyBtn" value="강의 신청" />
			</c:otherwise>

	</c:choose> 
	
	
</body>
</html>