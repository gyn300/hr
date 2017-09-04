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
		<jsp:include page="navigation.jsp"/>
	
	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">

        <table width="100%" border="1" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="50px" style="text-align: center">员工编号</td>
                <td width="50px" style="text-align: center">异议内容</td>
                <td width="50px" style="text-align: center">异议月份</td>
                <td width="50px" style="text-align: center">操作</td>

            </tr>

      <c:forEach items="${objections}" var="objection" varStatus="vs">

        <tr>
            <td style="text-align: center">${objection.user_id}</td>
            <td style="text-align: center">${objection.content}</td>
            <td style="text-align: center"><fmt:formatDate value="${objection.date}" pattern="yyyy-MM"/></td>
            <td style="text-align: center"><a href="/adminGetSalary.action?user_id=${objection.user_id}&date=<fmt:formatDate value="${objection.date}" pattern="yyyy-MM"/>">查看工资详情</a></td>


        </tr>

      </c:forEach>
        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
