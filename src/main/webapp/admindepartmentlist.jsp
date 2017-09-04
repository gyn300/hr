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
            <tr><h3>部门</h3></tr>
            <tr>
                <td width="50%" style="text-align: center">
                     <c:forEach items="${departments}" var="department" varStatus="vs">
                         <a href="/adminGetDepartmentList.action?department_id=${department.id}">${department.departmentName}</a><br/>
                     </c:forEach>
                    <form action="/addDepartment.action" method="post">
                        <input name="departmentName" type="text" />
                        <input type="submit" value="添加"/>
                    </form>
                </td>

                 <td width="50%" style="text-align: center">
                     <c:forEach items="${positions}" var="position" varStatus="vs">
                         ${position.positionName}<br/>
                     </c:forEach>
                     <form action="/addPosition.action" method="post">
                         <input name="positionName" type="text" />
                         <div style="display: none">
                             <input name="department_id" type="text" value="${department_id}"/></div>
                         <input type="submit" value="添加"/>
                     </form>
                 </td></tr>

        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
