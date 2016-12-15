<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Study Note</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/ckeditor/ckeditor.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/ckfinder.js"/>"></script>
<script type="text/javascript">

	//CKEDITOR.instances.contents.setData();
</script> 
</head>
<body>
	<h1>학습노트</h1>
	<input type="text" name="subject" id="subject" placeholder=" 제목을 입력하세요" style="width:500px; height:25px;" /><br/><br/>
	<textarea name="contents" id="contents" class="ckeditor" rows="10" cols="80"></textarea><br/>
	<script type="text/javascript">
		CKEDITOR.replace('contents');
	</script>
	<input type="button" name="backBtn" id="backBtn" value="목록으로" style="margin-right:20px;" />
	<input type="submit" name="submitBtn" id="submitBtn" value="등록" style="float:right;" />
</body>
</html>