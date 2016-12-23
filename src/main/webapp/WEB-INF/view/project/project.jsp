<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<h1>프로젝트 리스트</h1><hr/><hr/>
<table style="width:800px;">
	<tr>
		<th>프로젝트 이름</th>
		<th> 팀 이름</th>
		<th> 팀장</th>
		<th> 글쓴 날짜</th>
		<th> 기간</th>
		<tr><td><hr/></td></tr>
	</tr>
		<tr></tr>
	<c:forEach items="${projects}" var="project">
	<tr>
		<td align=center><a href="<c:url value='/project/detailProject/${project.id}'/>">${project.projectName}</a></td>
		<td align=center> 팀 이름</td>
		<td align=center> ${project.teamBoss}</td>
		<td align=center><fmt:formatDate pattern="yyyy-MM-dd" value="${project.createdDate}"/></td>
		<td align=center><fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate}"/> ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${project.endDate}"/></td>
		<tr><td><hr/></td></tr>
 	</tr>
	</c:forEach>
</table>
<c:if test="${sessionScope._USER_.id ne null}">
	<input type="button" value="프로젝트 추가" onclick="location.href='<c:url value="/project/addProject/${lectureId}"/>'" />
	</c:if>
	
	
	
</body>
</html>