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
	
	<form id="addModifyForm" method="post" action="<c:url value="/project/doModifyProject/${projectVO.lecture.id}"/>">
	<input type="hidden" value="${lectureId}" >
		<input type="hidden" name="id" value="${projectVO.id}">
		프로젝트명 : <input type="text" name="projectName" value="${projectVO.projectName}"/>
		팀 : <select id="teamName" name="teamName">
				<option value="01" selected="selected">팀 을 선택해 주세요</option>
				<option value="02">dd</option>
				<option value="03">vv</option>
			</select>
		</br>
		기간 : <input type="date" name="startDate" /> ~ <input type="date" name="endDate" /><br/>
		개요 : <br/><textarea rows="20px;" cols="100px;" name="projectInfo">${projectVO.projectInfo}</textarea>
		<input type="submit" value="추가하기"/>
	</form>

</body>
</html>