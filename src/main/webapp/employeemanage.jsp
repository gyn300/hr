<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="Js/js.js"></script>
    <script type="text/javascript">
        $(function () {

        })
    </script>
</head>

<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
    <td style="padding-top: 10px" width="772" height="35" valign="top">

		<jsp:include page="employeenavigation.jsp"/>

	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">
	<!---->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="431" background="images/bg_main.JPG">&nbsp;</td>
      </tr>
    </table>

	<!---->
        <div id="message" style="position:absolute;left:960px; top:400px;font-size: 18px;color: red">
         ${data}
        </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>
</body>


</html>
