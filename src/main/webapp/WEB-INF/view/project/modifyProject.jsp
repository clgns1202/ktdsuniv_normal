<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>	
	<form id="addModifyForm" method="post" action="<c:url value="/project/doModifyProject/${projectVO.lecture.id}"/>">
	<input type="hidden" value="${lectureId}" >
		<input type="hidden" name="id" value="${projectVO.id}">
		프로젝트명 : <input type="text" name="projectName" value="${projectVO.projectName}"/>
		팀 : <select id="teamName" name="teamName">
				<option value="01" selected="selected">팀 을 선택해 주세요</option>
				<option value="02">dd</option>
				<option value="03">vv</option>
			</select>
		팀장 : <select id="teamBoss" name="teamBoss">
				<option value="${projectVO.teamBoss}" selected="selected">${projectVO.teamBoss}</option>
				<c:forEach items="${projectVO.lecture.user}" var="lecture">
					<option value="${lecture.userName}">${lecture.userName}</option>
			</c:forEach>
		</select>
		</br>
		기간 : <input type="date" name="startDate" /> ~ <input type="date" name="endDate" /><br/>
		개요 : <br/><textarea rows="20px;" cols="100px;" name="projectInfo">${projectVO.projectInfo}</textarea>
		<input type="submit" value="추가하기"/>
	</form>
<jsp:include page="../common/footer.jsp"></jsp:include>