<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">

	$().ready(function() {
		
		$("#submitBtn").click(function () {
			
			if( $("#content").val() == "" ) {
				alert("내용을 입력해주세요.");
				return;
			}
			else if ( $("#subject").val() == "" ) {
				alert("날짜를 선택해주세요.");
				return;
			}
			
			$("#minForm").attr({
				"method": "post",
				"action": "<c:url value="/dailyReport/doAddDailyReport"/>"
			}).submit();
		});
	});
	
</script>
</head>
<body>

	<form id="minForm" name="minForm">
		<input type="date" id="subject" name="subject" /> <br/>
		<textarea id="content" name="content" placeholder="내용을 입력하세요." ></textarea> <br/>
		<input type="button" id="submitBtn" name="submitBtn" value="등록하기" />
	</form>
	
</body>
</html>