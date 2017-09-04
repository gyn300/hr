<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style2 {color: #BD1700}
-->
</style>
</head>
<body >
<table width="100%" height="615" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" height="100%"><table width="635" height="236" border="0" cellpadding="0" cellspacing="0" class="textB">
        <tr align="center">
          <td height="282" colspan="2" background="images/login_top.jpg" >&nbsp;</td>
        </tr>
        <tr align="center">
          <td width="18" height="120" background="images/login_left.jpg" class="tableBorder_lb" >&nbsp;</td>
          <td width="607" height="120" bgcolor="#FFFFFF" class="tableBorder_br">
		  	    <form name="usersForm" method="post" action="logon.do?action=logon">
		  
		  <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="31" colspan="4" align="center" >${data}</td>
            <td><input type="button" value="返回" onClick="history.back(-1);"></td>
          </tr>
        <tr>

        </tr>
          </table>
		  	    </form>
		  
		  </td>
        </tr>
    </table>
      </td>
  </tr>
</table>
</body>
</html>