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
        $("#onjobs").click(function () {
            $("#leavejob").css("display","none");
            $("#onjob").css("display","block");
        })
        $("#leavejobs").click(function () {
            $("#leavejob").css("display","block");
            $("#onjob").css("display","none");
        })
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
            <form action="/updateEmployeeDepartment.action" method="post">
           <table width="100%" border="1" cellpadding="0" cellspacing="0" >
               <tr>
                   <td  align="center"><h3>请选择调动的部门职位</h3></td>

               </tr>
               <tr>
                   <td  align="center">
                       用户id:<input name="user_id" type="text" value="${param.user_id}">
                   </td>
               </tr>
               <tr>
                   <td  align="center">
                       <select id="department" name="department" >

                   </select>&nbsp;
                       <select id="position" name="position" >

                       </select>
                   </td>
               </tr>
               <tr>
                   <td  align="center">
                        <input type="submit" value="确定调动">&nbsp;<input name="Submit3" type="button"  value="返回" onClick="history.back(-1);">
                    </td>

               </tr>
            </table>
            </form>


        <br/><br/>
        <div id="message" style="position:absolute;left:960px; top:600px;font-size: 18px;color: red">
            ${data}
        </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>
<script type="text/javascript">

    window.onload=function () {


            addDepartments();
            department.onchange= addPositions;

    }
    var departments=["请选择","人事部","运营部","策划部"];
    var positions=[
        ["请选择"],
        ["主管","人事专员"],
        ["主管","运营专员"],
        ["主管","策划专员"]

    ];
    var department=document.getElementById("department");
    var position=document.getElementById("position");
    function addDepartments(){

        for(var i in departments){

            //获取下拉列表集合实例
            var op=new Option(departments[i],departments[i]);
            //将下拉列表各元素添加到省份元素中
            department.options.add(op);
        }
    }
    function addPositions(){
        for(var i in positions) {
            //获取下标
            var index = department.selectedIndex;
            //将position下的所有原有option移除
            position.options.length = 0;
            var op = new Option(departments[i], departments[i]);
            //添加对应城市下拉列表
            for (var i in positions[index]) {
                var op = new Option(positions[index][i], positions[index][i]);
                position.options.add(op);
            }
        }
    }
</script>
</body>
</html>
