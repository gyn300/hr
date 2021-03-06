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
        <form action="/employeeGetBonuspenaltyList.action" method="post">

            <div>请输入要查询的日期:<input name="sTime" type="text" /><input type="submit" value="查询"/></div>

        </form>
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="50px" style="text-align: center">序号</td>

                <td width="50px" style="text-align: center">奖惩缘由</td>
                <td width="50px" style="text-align: center">奖惩时间</td>
                <td width="50px" style="text-align: center">奖惩金额</td>
                <td width="50px" style="text-align: center">奖惩类型</td>
            </tr>

      <c:forEach items="${sBonuspenaltys}" var="sBonuspenalty" varStatus="vs">

        <tr>
            <td style="text-align: center">${sBonuspenalty.id}</td>

            <td style="text-align: center">${sBonuspenalty.explains}</td>
            <td style="text-align: center"><fmt:formatDate value="${sBonuspenalty.time}" pattern="yyyy-MM-dd"/></td>
            <td style="text-align: center">${sBonuspenalty.money}</td>
            <td style="text-align: center">${sBonuspenalty.name}</td>

        </tr>

      </c:forEach>
        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
