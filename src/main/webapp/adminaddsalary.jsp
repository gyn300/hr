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
    <td  width="772" height="48" valign="top">
		<jsp:include page="navigation.jsp"/>

	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">
        <form action="/getSalaryAtt.action" method="post">

            <div>请输入日期:<input name="date" type="text" />&nbsp;;员工id:<input name="user_id" type="text" value="${param.user_id}"><input type="submit" value="查询"/></div>

        </form>
        <form action="/insertSalary.action" method="post">
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >
            <tr>

                <td width="50px" style="text-align: center">员工id</td>

                <td width="50px" style="text-align: center">基本工资</td>
                <td width="50px" style="text-align: center">绩效工资</td>
                <td width="50px" style="text-align: center">加班工资</td>
                <td width="50px" style="text-align: center">奖惩工资</td>
                <td width="50px" style="text-align: center">社保</td>
                <td width="50px" style="text-align: center">时间</td>
            </tr>



        <tr>

            <td style="text-align: center"><input style="width: 90px" name="user_id" type="text" value="${user_id}"></td>
            <td style="text-align: center"><input style="width: 90px"  name="baseSalary" type="text"></td>
            <td style="text-align: center"><input style="width: 90px"  name="performanceSalary" type="text" value="${performance1.money}"></td>
            <td style="text-align: center"><input style="width: 90px"  name="overtimeSalary" type="text"></td>
            <td style="text-align: center"><input style="width: 90px"  name="bonuspenaltySalary" type="text" value="${bonuspenaltyMoney}"></td>
            <td style="text-align: center"><input style="width: 90px"  name="socialSecurity" type="text"></td>
            <td style="text-align: center"><input style="width: 90px"  name="date" type="text" value="<fmt:formatDate value="${performance1.date}" pattern="yyyy-MM"/>"></td>
        </tr>

            <tr><td><div style="display: none"><input name="totalSalary" type="text" value="0"></div></td></tr>

        </table>
            <div align="center"><input type="submit" value="添加工资"> <input name="Submit3" type="button"  value="返回" onClick="history.back(-1);"></div>
        </form><br/><br/>
        <div id="message" style="position:absolute;left:940px; top:400px;font-size: 18px;color: red">
            ${data}
        </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
