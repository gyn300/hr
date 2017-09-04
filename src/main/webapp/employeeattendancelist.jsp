<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script src="Js/js.js"></script>

<script type="text/javascript">
    $(function () {
        <c:forEach items="${sAttendances}" var="sAttendance" varStatus="vs">
        if($("#checkLateStatus${vs.index}").text()==0){
              $("#checkLateStatus${vs.index}").text("否");
        }else {
            $("#checkLateStatus${vs.index}").css("color","red")
            $("#checkLateStatus${vs.index}").text("迟到");
        }
        if($("#checkLeaveEarlyStatus${vs.index}").text()==0){
            $("#checkLeaveEarlyStatus${vs.index}").text("否");
        }else {
            $("#checkLeaveEarlyStatus${vs.index}").css("color","red");
            $("#checkLeaveEarlyStatus${vs.index}").text("早退");
        }
        </c:forEach>
    })
</script>
<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
    <td width="772" height="48" valign="top">
		<jsp:include page="employeenavigation.jsp"/>
	
	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">
        <form action="/getAttendanceList.action" method="post">
            <div>请输入要查询的日期:<input name="sDate" type="text" /><input type="submit" value="查询"/></div>

        </form>
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="50px" style="text-align: center">上班时间</td>
                <td width="50px" style="text-align: center">下班时间</td>
                <td width="50px" style="text-align: center">是否迟到</td>
                <td width="50px" style="text-align: center">是否早退</td>

            </tr>

      <c:forEach items="${sAttendances}" var="sAttendance" varStatus="vs">

        <tr>
            <td style="text-align: center"><fmt:formatDate value="${sAttendance.workTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="text-align: center"><fmt:formatDate value="${sAttendance.offWorkTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="text-align: center" id="checkLateStatus${vs.index}">${sAttendance.lateStatus}</td>
            <td style="text-align: center" id="checkLeaveEarlyStatus${vs.index}">${sAttendance.leaveEarlyStatus}</td>

        </tr>

      </c:forEach>
        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
