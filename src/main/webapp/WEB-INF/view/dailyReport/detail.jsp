<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/> "></script>
<script type="text/javascript">

	$().ready(function () {
		
		$("#deleteBtn").click(function () {
			if ( confirm("정말로 삭제하시겠습니까?") ) {
				location.href="<c:url value="/dailyReport/doDelete/${boards.id}" />";
			}
		});
	});
</script>
</head>
<body>

	<h1>${boards.subject}</h1>
	
	<hr/>
	
	${boards.content}
	${boards.dailyDate}

	<br/>
	<br/>
	
	<input type="button" id="deleteBtn" name="deleteBtn" value="삭제하기" />
	
</body>
</html>