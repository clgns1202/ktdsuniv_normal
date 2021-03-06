<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>${lecture.lectureName}</h1>
	<h5>강사: ${lecture.instructor.user.userName}</h5>
	<h5>관리자: ${lecture.admin.user.userName}</h5>
	<h5>호실: ${lecture.room.roomNumber}</h5>
	<h5>기간: ${lecture.startDate} - ${lecture.endDate} </h5>
	<h5>강의시간: ${lecture.startTime} - ${lecture.endTime}</h5>
	<hr/>
	<h5>시험성적 :</h5>
	<c:forEach items="${user.tests}" var="test">
		<c:if test="${lecture.id eq test.lectureId}">
		시험명: ${test.testName}
		시험점수: ${test.score}
		<br/>
		</c:if>
	</c:forEach>
	
