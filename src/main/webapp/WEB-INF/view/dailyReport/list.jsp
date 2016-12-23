<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>  
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
	  		<td><a href="<c:url value="/dailyReport/detail/${board.id}"/>">${board.subject}</a></td>
	  	
	  	</tr>
	  </c:forEach>
  </table>
  
 
<a href="<c:url value=" /dailyReport/addDailyReport"/> ">등록</a>