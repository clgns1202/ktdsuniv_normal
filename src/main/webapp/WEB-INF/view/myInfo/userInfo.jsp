<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>내정보</h1>
	
	<div>
	
		<div>
				<h3>회원정보<br/></h3>
					유저성명 : ${user.userName}<br/>
					휴대전화	: ${user.phoneNumber}<br/>
					주소 : ${user.address}<br/>
					가입일 : ${user.createdDate}<br/>
					수강중 강의목록<br/>
						<c:forEach items="${lectures}" var="lecture">
					 <a href="<c:url value="/user/myLectureInfo/${lecture.id}"/>" >${lecture.lectureName}</a> <br/>
						</c:forEach>
					
					<br/>
					<input type="button" value="수정" onclick="location.href='<c:url value="/user/userInfo/viewUserModifyPage"/>'"">
		</div>
	
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>