<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/fullcalendar.css"/>
<link rel="stylesheet" type="text/css" href="/css/fullcalendar.min.css"/>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css"/>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/fullcalendar.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript">
	$(function(){
		calendarEvent();
	});
	function calendarEvent(eventData){
		$("calendar").html("");
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYea();
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: "",
				center: "title",
				//right: "month,basicWeek,basicDay"
				right: "today prev, next"
			},
			editable: true,
			titleFormat: {
				month: "yyyy년 MMMM",
				week: "[yyyy] MMMM dd일{[yyyy] MMM dd일}",
				day: "yyyy년 MMM d일 dddd"
			},
			allDayDefault: false,
			defaultView: "month",
			editable: false,
			monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
			monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
			dayNames: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
			dayNamesShort: ["일","월","화","수","목","금","토"],
			buttonText: {
				today: "오늘",
				month: "월별",
				week: "주별",
				day : "일별",
			},
			events : eventData,
			timeFormat : "HH:mm",
		});
	}
</script>
</head>
<body>

	<form id="addModifyForm" method="post" action="<c:url value="/project/doDeleteProject/${projectVO.id}/${projectVO.lecture.id}"/>">
		프로젝트 이름: ${projectVO.projectName}<br/>
		팀명: 팀이름<br/>
		팀장: ${projectVO.teamBoss}<br/>
		기간: ${projectVO.startDate} ~ ${projectVO.endDate} <br/>
		프로젝트 개요: <br/>
		${projectVO.projectInfo}<br/>
	
		<input type="hidden" name="lectureId" value="${projectVO.lecture.id}" />
		<c:if test="${sessionScope._USER_.id eq projectVO.user.id}">
			<input type="submit" value="삭제" />
		</c:if>
	</form>
<c:if test="${sessionScope._USER_.id eq projectVO.user.id}">
	<%-- <input type="button" value="삭제" onclick="location.href='<c:url value='/project/doDeleteProject/${projectVO.id}'/>'"> --%>
	<input type="button" value="수정" onclick="location.href='<c:url value='/project/modifyProject/${projectVO.id}'/>'">
</c:if>
<div id="calendar"> </div>

</body>
</html>