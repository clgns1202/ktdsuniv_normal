<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="/css/fullcalendar.css" rel="stylesheet"/>
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
        $("#calendar").fullCalendar({
              defaultDate : "2016-05-12"
            , editable : true
            , eventLimit : true
            , eventSources : [
                {
                    // 배경색이 빨간색인 이벤트
                    events : [
                        {
                              title : "All Day Event"
                            , start : "2016-05-03"
                        },
                        {
                              title : "Long Event"
                            , start : "2016-05-07"
                            , end : "2016-05-10"
                        }
                    ]
                    , color : "#FF0000"
                    , textColor : "#FFFF00"
                }
                , {
                    // 배경색이 파랑색인 이벤트
                    events : [
                        {
                              title : "All Day Event"
                            , start : "2016-05-27"
                        },
                        {
                              title : "Long Event"
                            , start : "2016-05-17"
                            , end : "2016-05-19"
                        }
                    ]
                    , color : "#0000FF"
                    , textColor : "#FFFFFF"
                }
                , {
                    // 배경색이 초록색인 이벤트
                    events : [
                        {
                              title : "All Day Event"
                            , start : "2016-05-21"
                        },
                        {
                              title : "Long Event"
                            , start : "2016-05-23"
                            , end : "2016-05-26"
                        }
                    ]
                    , color : "#00CC00"
                    , textColor : "#000000"
                }
            ]
        });
    });  
    
    

</script>
</script>
</head>
<body>

	<form id="addModifyForm" method="post" action="<c:url value="/project/doDeleteProject/${projectVO.id}/${projectVO.lecture.id}"/>">
		프로젝트 이름: ${projectVO.projectName}<br/>
		팀명: 팀이름<br/>
		팀장: ${projectVO.teamBoss}<br/>
		기간: ${projectVO.startDate} ~ ${projectVO.endDate} <br/>
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