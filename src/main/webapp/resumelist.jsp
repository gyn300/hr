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
        <c:forEach items="${resumes}" var="resume" varStatus="vs">
        if($("#checkStatus${vs.index}").text()==0||$("#checkStatus${vs.index}").text()==""){
              $("#checkStatus${vs.index}").text("未查看");
        }else {
            $("#checkStatus${vs.index}").text("已查看");
        }
        if($("#interviewStatus${vs.index}").text()==0||$("#interviewStatus${vs.index}").text()==""){
            $("#interviewStatus${vs.index}").text("未面试");
        }else {
            $("#interviewStatus${vs.index}").text("已面试");
        }
        </c:forEach>
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
                <td width="50px" style="text-align: center">序号</td>
                <td width="50px" style="text-align: center">应聘者</td>
                <td width="50px" style="text-align: center">投递时间</td>
                <td width="50px" style="text-align: center">查看状态</td>
                <td width="50px" style="text-align: center">面试状态</td>
                <td width="50px" style="text-align: center">操作</td>
            </tr>
      <c:forEach items="${resumes}" var="resume" varStatus="vs">

        <tr>
            <td style="text-align: center">${resume.id}</td>
            <td style="text-align: center">${resume.name}</td>
            <td style="text-align: center"><fmt:formatDate value="${resume.time}" pattern="yyyy-MM-dd"/></td>
            <td style="text-align: center" id="checkStatus${vs.index}">${resume.checkStatus}</td>
            <td style="text-align: center" id="interviewStatus${vs.index}">${resume.interviewStatus}</td>
            <td style="text-align: center"><a href="/checkResume.action?user_id=${resume.user_id}">查看</a>|<a href="/delResume.action?user_id=${resume.user_id}">删除</a></td>

        </tr>

      </c:forEach>
        </table><br/><br/>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
