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
        var checkStatus="${resume.checkStatus}";
        var employStatus="${interview.employStatus}";
        if(checkStatus==0){
              $("#checkStatus").text("未查看");
        }else {
            $("#checkStatus").text("已查看");
        }
        if(employStatus=="0"||employStatus==""){
            $("#employStatus").text("未录用");
        }else {
            $("#employStatus").text("已录用");
        }

    })
</script>
<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
    <td width="772" height="48" valign="top">
		<jsp:include page="visitornavigation.jsp"/><br/><br/>
	    <div style="text-align: center;font-size: 17px;font-weight: bold">反馈信息</div>
	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >

            <tr>
                <td width="50px" style="text-align: center">投递时间</td>
                <td width="50px" style="text-align: center">是否查看</td>
                <td width="50px" style="text-align: center">是否面试</td>

                <td width="50px" style="text-align: center">面试时间</td>
                <td width="50px" style="text-align: center">是否录用</td>
            </tr>


        <tr>
            <td style="text-align: center"><fmt:formatDate value="${resume.time}" pattern="yyyy-MM-dd"/></td>
            <td style="text-align: center" id="checkStatus">${resume.checkStatus}</td>
            <td style="text-align: center">按时面试</td>
            <td style="text-align: center" ><fmt:formatDate value="${interview.interviewTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="text-align: center" id="employStatus">${interview.employStatus}</td>


        </tr>

        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
