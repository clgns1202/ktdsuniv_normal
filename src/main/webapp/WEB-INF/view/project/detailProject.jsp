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

	<form id="addModifyForm" method="post" action="<c:url value="/project/doDeleteProject/${projectVO.id}/${projectVO.lecture.id}"/>">
		프로젝트 이름: ${projectVO.projectName}<br/>
		팀명: 팀이름<br/>
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
</body>
</html>