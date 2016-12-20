<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>List</h1>
  <hr>
  
  <table>
  	<tr>
  		<td>날짜</td>
  		<td>제목</td>
  	</tr>
  </table>
  
  <table>
 	 <c:forEach items="${boards}" var="board">
	  	<tr>
	  		<td>${board.dailyDate}</td>
	  		<td><a href="<c:url value="/dailyReport/detail/${board.id}"/> ">${board.subject}</a></td>
	  	
	  	</tr>
	  </c:forEach>
  </table>
</body>
</html>