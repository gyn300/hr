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
        $("#interviewnotice").click(function () {
            $("#educatelist").css("display","none");
            $("#interviewlist").css("display","block");
        })
        $("#educatenotice").click(function () {
            $("#interviewlist").css("display","none");
            $("#educatelist").css("display","block");
        })
    })
</script>
<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
    <td width="772" height="48" valign="top">
		<jsp:include page="directornavigation.jsp"/><br/><br/>
	    <div style="text-align: center"><input id="interviewnotice" type="button" value="面试通知">&nbsp;<input id="educatenotice" type="button" value="培训通知"></div>
	</td>
    <td width="40" rowspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="249" valign="top">
        <div id="interviewlist" style="display: none">
        <table width="100%" border="1" cellpadding="0" cellspacing="0" >

            <tr>
                <td width="50px" style="text-align: center">序号</td>
                <td width="50px" style="text-align: center">应聘者ID</td>


                <td width="50px" style="text-align: center">面试时间</td>
                <td width="50px" style="text-align: center">操作</td>
            </tr>

        <c:forEach items="${interviews}" var="interview">
        <tr>
            <td style="text-align: center">${interview.id}</td>

            <td style="text-align: center">${interview.user_id}</td>
            <td style="text-align: center" ><fmt:formatDate value="${interview.interviewTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="text-align: center" ><a  href="/directorCheckResume.action?user_id=${interview.user_id}">面试</a></td>

        </tr>
        </c:forEach>
        </table></div>

        <div id="educatelist" style="display: none">
            <table width="100%" border="1" cellpadding="0" cellspacing="0" >

                <tr>
                    <td width="50px" style="text-align: center">序号</td>
                    <td width="50px" style="text-align: center">培训名称</td>


                    <td width="50px" style="text-align: center">培训时间</td>

                </tr>

                <c:forEach items="${educates}" var="educate">
                    <tr>
                        <td style="text-align: center">${educate.id}</td>

                        <td style="text-align: center">${educate.educateName}</td>
                        <td style="text-align: center" ><fmt:formatDate value="${educate.educateTime}" pattern="yyyy-MM-dd"/></td>

                    </tr>
                </c:forEach>
            </table></div>
        <div  style="position:absolute;left:980px; top:600px;font-size: 18px;color: red">
            ${data}
        </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
