<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
    body {
        margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size: 14px;
    }

    #calendar {
        max-width: 900px;
        margin: 0 auto;
        text-align: center;
    }
    table{
    margin: 0 auto;
    
    }

    .fc-prev-button{
    	width: 100px;
    	height: 20px;
    	 border-top-left-radius: 5em;
    	 border-bottom-left-radius: 5em;
    
    }
    .fc-next-button{
   		 width: 100px;
    	 height: 20px;
    	 border-top-right-radius: 5em;
    	 border-bottom-right-radius: 5em;
    }
    .fc-today-button{
    	width: 200px;
    	height: 20px;
    }
    .fc-day-number{
    	font-size: 20px;
    	margin : 20px;
    }
    .fc-row{
    margin : 0 auto;
    }
    .fc-content-skeleton{
    	text-align: center;
    }
    .fc-other-month{
    	color: #8C8C8C;
    }
    .fc-sun{
    	paddind-left: 200px;
    }

    .fc-day-number.fc-sat.fc-past { color:#0000FF; }
    .fc-day-number.fc-sun.fc-past { color:#FF0000; }
</style>

<!-- <link href="/css/fullcalendar.css" rel="stylesheet"/> -->
<link href=".//fullcalendar.print.css" rel="stylesheet" media="print"/>
<script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/fullcalendar.js"/>" charset="euc-kr"></script>
<%-- 
<link rel="stylesheet" type="text/css" href="/css/fullcalendar.css"/>
<link rel="stylesheet" type="text/css" href="/css/fullcalendar.min.css"/>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css"/>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/fullcalendar.min.js"/>"></script> --%>

<script type="text/javascript">
     $(document).ready(function() {
    	 var startDate = $("#startDate").text();
    	 var endDate = $("#endDate").text();
    	 console.log(startDate);
        $("#calendar").fullCalendar({
              defaultDate : "2016-12-11"
            , editable : true
            , eventLimit : true
            , eventSources : [
                {
                    // 배경색이 빨간색인 이벤트
                    events : [
                        {
                              title : "START▶"
                            , start : startDate
                        }
                    ]
                    , color : "#FF007F"
                    , textColor : "#FF007F"
                }
                , {
                    // 배경색이 파랑색인 이벤트
                    events : [
                        {
                              title : "▶END"
                            , start : endDate
                        }
                    ]
                    , color : "#050099"
                    , textColor : "#0100FF"
                }

            ]
        });
        
        $(".fc-day-top").on("click", function(){
        	alert($(this).attr("data-date"));
        });
    });  
    
    

</script>
</head>
<body>

	<form id="addModifyForm" method="post" action="<c:url value="/project/doDeleteProject/${projectVO.id}/${projectVO.lecture.id}"/>">
		프로젝트 이름: ${projectVO.projectName}<br/>
		팀명: 팀이름<br/>
		팀장: ${projectVO.teamBoss}<br/> 
		<c:set var="startDate"><fmt:formatDate pattern="yyyy-MM-dd"  value="${projectVO.startDate}"/></c:set>
		<c:set var="endDate"><fmt:formatDate pattern="yyyy-MM-dd" value="${projectVO.endDate}"/></c:set>
		기간: <span id="startDate">${startDate}</span>~<span id="endDate">${endDate}</span>  <br/>
		프로젝트 개요: <br/>
		${projectVO.projectInfo}<br/>
	
		<input type="hidden" name="lectureId" value="${projectVO.lecture.id}" />
		<c:if test="${sessionScope._USER_.id eq projectVO.user.id}">
			<input type="submit" value="삭제" />
		</c:if>
	</form>
<c:if test="${sessionScope._USER_.id eq projectVO.user.id}">
	<%-- <input type="button" value="삭제" onclick="location.href='<c:url value='/project/doDeleteProject/${projectVO.id}'/>'"> --%>
	<input type="button" value="수정" onclick="location.href='<c:url value='/project/modifyProject/${projectVO.id}'/>'">
</c:if>
<div id="calendar"> </div>

</body>
</html>