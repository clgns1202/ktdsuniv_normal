<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>강의명</tr>
		<tr>강의기간</tr>
		<tr>강사</tr>
	</table>
	<c:forEach items="${lectureList.pageList}" var="lecture">
		<tr><a href="<c:url value="/lecture/detail/${lecture.id}"/>">${lecture.lectureName}</a></tr>
		<tr>${lecture.startDate}-${lecture.endDate}</tr>
		<tr>${lecture.instructor.user.userName}</tr>
	</c:forEach>

</body>
</html>