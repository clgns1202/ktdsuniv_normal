<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	제목 : ${studyNote.subject}
	내용 : ${studyNote.content}
	작성날짜 : 
	<fmt:formatDate value="${studyNote.createdDate}" pattern="yyyy-MM-dd HH:mm:SS"/>
	
<jsp:include page="../common/footer.jsp"></jsp:include>