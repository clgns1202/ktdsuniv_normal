<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript">

	$().ready(function () {
		
		$("#deleteBtn").click(function () {
			if ( confirm("정말로 삭제하시겠습니까?") ) {
				location.href="<c:url value="/dailyReport/doDelete/${boards.id}" />";
			}
		});
	});
</script>

	<h1>${boards.subject}</h1>
	
	<hr/>
	
	${boards.content}
	${boards.dailyDate}

	<br/>
	<br/>
	
	<input type="button" id="deleteBtn" name="deleteBtn" value="삭제하기" />
	
<jsp:include page="../common/footer.jsp"></jsp:include>