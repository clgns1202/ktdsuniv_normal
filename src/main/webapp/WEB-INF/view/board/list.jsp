<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
	<h1>학습노트</h1>
	<table>
			<c:forEach items="${studyNotes}" var="studyNote">	
			<tr>
				<td><a href="<c:url value="/studyNote/detail/${studyNote.id}"/>">${studyNote.subject}</a></td>
			</tr>
			</c:forEach>
	</table>
	
	<a href="<c:url value="/studyNote/write"/>">등록</a>

<jsp:include page="../common/footer.jsp"></jsp:include>