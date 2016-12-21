<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	제목 : ${studyNote.subject}
	내용 : ${studyNote.content}
	작성날짜 : 
	<fmt:formatDate value="${studyNote.createdDate}" pattern="yyyy-MM-dd HH:mm:SS"/>
	
</body>
</html>