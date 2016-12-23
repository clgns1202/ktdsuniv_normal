<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript">

	$().ready(function() {
		
		$("#dailyDate").val(new Date);
		
		$("#dailyDate").on("change", function(){
			alert($(this).val());
		});
		$.post(,,)
		
		$("#submitBtn").click(function () {
			
			if( $("#content").val() == "" ) {
				alert("내용을 입력해주세요.");
				return;
			}
			else if ( $("#dailyDate").val() == "" ) {
				alert("날짜를 선택해주세요.");
				return;
			}
			else if ( $("#subject").val() == "" ) {
				alert("제목을 입력해주세요.");
				return;
			}
			
			$("#minForm").attr({
				"method": "post",
				"action": "<c:url value="/dailyReport/doAddDailyReport"/>"
			}).submit();
		});
	});
	
</script>
	
	<h1>학습일지 작성</h1>
	<hr/>
	<form id="minForm" name="minForm">
		<input type="date" id="dailyDate" name="dailyDate" /> <br/><br/>
		제목: <input type="text" id="subject" name="subject" /> <br/>
		<textarea style="width: 350px; height: 500px;" id="content" name="content" placeholder="내용을 입력하세요." ></textarea> <br/>
		<input type="button" id="submitBtn" name="submitBtn" value="등록하기" />
	</form>
<jsp:include page="../common/footer.jsp"></jsp:include>