<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
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

        <form name="usersForm" method="post" action="/insertUser.action">
		  <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0">

        <tr>
          <td width="230" height="30" align="center">用户名：<input name="user_name" type="text" class="input"></td>
          <td width="215" height="31" >密&nbsp;码：
            <input name="user_pwd" type="password" class="input" ></td>
          <td width="97" align="center" ><input type="submit" class="link-red" value="注册"/></td>
          <td width="76" ><a href="#" onClick="usersForm.reset();" class="link-red">[重写]</a> <br/>
              <a href="/login.jsp"  class="link-red">[登录]</a>
          </td>
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
