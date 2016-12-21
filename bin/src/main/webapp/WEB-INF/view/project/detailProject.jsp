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

프로젝트 이름: ${projectVO.projectName}<br>
프로젝트 내용: <br/>
${projectVO.projectInfo}<br/>
<c:if test="${sessionScope._USER_.id eq projectVO.user.id}">
	<input type="button" value="삭제" onclick="location.href='<c:url value='/project/doDeleteProject/${projectVO.id}'/>'">
	<input type="button" value="수정" onclick="location.href='<c:url value='/project/modifyProject/${projectVO.id}'/>'">
</c:if>
</body>
</html>