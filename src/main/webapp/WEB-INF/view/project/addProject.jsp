<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<form id="addProjectForm" method="post" action="<c:url value="/project/doAddProject/${lectureId}"/>">
	<input type="hidden" value="${lectureId}" >
		프로젝트명 : <input type="text" name="projectName" />
		팀 : <select id="teamName" name="teamName">
				<option value="01" selected="selected">팀 을 선택해 주세요</option>
				<option value="01" selected="selected">팀 을 선택해 주세요</option>
				<option value="01" selected="selected">팀 을 선택해 주세요</option>
			</select>
		팀장 : <select id="teamBoss" name="teamBoss">
			<option value="001" selected="selected">팀장 을 선택해 주세요</option>
			<c:forEach items="${lectures.user}" var="lecture">
				<option value="${lecture.userName}">${lecture.userName}</option>
			</c:forEach>
		</select>
		</br>
		
		기간 : <input type="date" name="startDate" /> ~ <input type="date" name="endDate" /><br/>
		개요 : <br/><textarea rows="20px;" cols="100px;" name="projectInfo"></textarea>
		<input type="submit" value="추가하기"/>
	</form>

<jsp:include page="../common/footer.jsp"></jsp:include>