<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="Js/js.js"></script>
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
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="431" valign="top" bgcolor="#C5DF7E">
<!------->		
		
   <br>
 <div  style="float: left;width:40%"><table  border="0" align="center" cellspacing="1" bordercolor="#FFFFFF" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150" >
   <tr><td height="22" colspan="4" align="center" bgcolor="#97B150" class="word_yellow">培训</td></tr>
   <c:forEach items="${educates}" var="educate">
     <tr><td align="center" width="30%" height="27" bgcolor="#E8FEA9" ><a href="/getEducate.action?id=${educate.id}">${educate.educateName}</a></td></tr>
   </c:forEach>
 </table></div>
          <div  style="float: left; width:50%">
<table   border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150" >
  <tr>
    <td height="22" colspan="4" align="center" bgcolor="#97B150" class="word_yellow">-添加培训计划-</td>
  </tr>
  <form name="educateForm" method="post" action="/insertEducate.action">
  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FEA9" >培训名称：</td>
    <td width="29%" height="22" align="left" bgcolor="#E8FEA9" ><input name="educateName" type="text" class="input"></td>
    </tr>
  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FEA9" >培训时间：</td>
    <td height="22" align="left" bgcolor="#E8FEA9" ><input type="text" name="educateTime" class="input"></td>
    </tr>

  <tr>
    <td width="30%" height="22" align="center" bgcolor="#E8FEA9" >培训部门：</td>
    <td height="22" colspan="3" align="left" bgcolor="#E8FEA9" >
      <select name="educateDepartment">
        <c:forEach items="${departments}" var="department">
          <option>${department.departmentName}</option>
        </c:forEach>
      </select>
    </td>
  </tr>
  <tr>
    <td height="27" colspan="4" align="center" bgcolor="#E8FEA9" ><input name="Submit" type="submit" class="button" value="提交">
      &nbsp;&nbsp;
      <input name="Submit2" type="reset" class="button" value="重置"></td>
  </tr>
  </form>
</table>
          </div>
<!-------------->		</td>
      </tr>
    </table>
      <div id="message" style="position:absolute;left:960px; top:400px;font-size: 18px;color: red">
        ${data}
      </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
