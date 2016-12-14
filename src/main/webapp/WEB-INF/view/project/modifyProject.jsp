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
수정
<form id="addProjectForm" method="post" action="<c:url value="/project/doModifyProject/${projectVO.id}"/>">
		<input type="text" name="projectName"  value="${projectVO.projectName}"/></br>
		<textarea rows="20px;" cols="20px;" name="projectInfo">${projectVO.projectInfo} </textarea>
		<input type="submit" value="추가하기"/>
	</form>
</body>
</html>