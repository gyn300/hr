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
        var user_id="${salary.user_id}";
        $("#objection").click(function () {
            $("#objectiondiv").css("display","block");
        })
        if(user_id==""){
            $("#objection").css("display","none")
        }else {
            $("#objection").css("display","inline")
        }
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
        <form action="/getSalary.action" method="post">

            <div>请输入要查询的日期:<input name="date" type="text" /><input type="submit" value="查询"/></div>

        </form>
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="50px" style="text-align: center">编号</td>
                <td width="50px" style="text-align: center">员工id</td>
                <td width="50px" style="text-align: center">总工资</td>
                <td width="50px" style="text-align: center">基本工资</td>
                <td width="50px" style="text-align: center">绩效工资</td>
                <td width="50px" style="text-align: center">加班工资</td>
                <td width="50px" style="text-align: center">奖惩工资</td>
                <td width="50px" style="text-align: center">社保</td>
                <td width="50px" style="text-align: center">时间</td>
                <td width="50px" style="text-align: center">是否异议</td>
            </tr>



        <tr>
            <td style="text-align: center">${salary.id}</td>
            <td style="text-align: center">${salary.user_id}</td>
            <td style="text-align: center">${salary.totalSalary}</td>
            <td style="text-align: center">${salary.baseSalary}</td>
            <td style="text-align: center">${salary.performanceSalary}</td>
            <td style="text-align: center">${salary.overtimeSalary}</td>
            <td style="text-align: center">${salary.bonuspenaltySalary}</td>
            <td style="text-align: center">${salary.socialSecurity}</td>
            <td style="text-align: center"><fmt:formatDate value="${salary.date}" pattern="yyyy-MM"/></td>
            <td width="50px" style="text-align: center" align="center"><input id="objection" type="button" value="异议"></td>
        </tr>
        </table>
        <form action="/insertObjection.action" method="post">
            <div id="objectiondiv" style="display: none">
                <table>


                <tr><td><div style="display: none"><input name="user_id" type="text" value="${salary.user_id}"><input type="text" name="date" value="<fmt:formatDate value="${salary.date}" pattern="yyyy-MM"/>"></div>
                请输入异议内容:</td><td rowspan="8"><textarea name="content" cols="50" rows="6" class="input"></textarea></td><td><input type="submit" value="提交"></td></tr>
                </table></div></form>

        <br/><br/>
        <div style="position:absolute;left:980px; top:600px;font-size: 18px;color: red">
            ${data}
        </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
