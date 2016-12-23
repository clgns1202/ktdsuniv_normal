<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
					<input type="button" value="수정" onclick="location.href='<c:url value="/user/viewUserModifyPage"/>'"">
		</div>
	
	</div>
	<br/>
	</hr>
</html>