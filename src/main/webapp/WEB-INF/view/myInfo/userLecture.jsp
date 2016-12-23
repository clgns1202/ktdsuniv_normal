<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<c:forEach items="${lectures}" var="lecture" >
	<a href="<c:url value="/project/${lecture.id}"/>"> ${lecture.lectureName}</a>
	</c:forEach>
<jsp:include page="../common/footer.jsp"></jsp:include>