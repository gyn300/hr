<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      var sex="${resume.sex}";
      if(sex=="女"){
         $("#female").attr("checked", true);
      }


       $("#interview").click(function () {
           $("#interviewtime").css('display','block');
       })

  })
</script>
<body>
<div style="position:absolute;left:100px; top:20px;height: 20px;font-size: 18px;color: blue" ><span style="color: black">欢迎:</span>${sessionScope.user_name}</div>
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
<table width="94%"  border="0" align="center" cellpadding="0" cellspacing="1" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150" >
  <tr>
    <td height="22" colspan="4" align="center" ><strong class="word_yellow">-添加应聘信息-</strong></td>
  </tr>

  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FFA7" >姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
    <td width="29%" height="22" align="left" bgcolor="#E8FFA7" ><input name="name" type="text" class="input" value="${resume.name}"></td>
    <td width="18%" bgcolor="#E8FFA7" >性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    <td width="23%" align="left" bgcolor="#E8FFA7" ><input id="male" name="sex" type="radio" value="1" checked>
男
  <input id="female" name="sex" type="radio" value="0">
女</td>
  </tr>
  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FFA7" >年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="age" type="text" class="input" value="${resume.age}"></td>
    <td height="22" bgcolor="#E8FFA7" >部门职位：

    </td>
    <td height="22" align="left" bgcolor="#E8FFA7" >
      <select id="department" name="department" >

      </select>&nbsp;
      <select id="position" name="position" >

      </select></td>
  </tr>
  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FFA7" >所学专业：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="specialty" type="text" class="input" value="${resume.specialty}"></td>
    <td height="22" bgcolor="#E8FFA7" >工作经验：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="experience" type="text" class="input" value="${resume.experience}"></td>
  </tr>
  <tr align="center">
    <td width="30%" height="27" bgcolor="#E8FFA7" >学&nbsp;&nbsp;&nbsp;&nbsp;历：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="education" type="text" class="input" value="${resume.education}"></td>
    <td height="22" bgcolor="#E8FFA7" >毕业学校：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="graduateInstitutions" type="text" class="input" value="${resume.graduateInstitutions}"></td>
  </tr>
  <tr>
    <td width="30%" height="27" align="center" bgcolor="#E8FFA7" >电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="tel" type="text" class="input" value="${resume.tel}"></td>
    <td height="22" align="center" bgcolor="#E8FFA7" >Email：</td>
    <td height="22" align="left" bgcolor="#E8FFA7" ><input name="email" type="text" class="input" value="${resume.email}"></td>
  </tr>
  <tr>
    <td width="30%" height="22" align="center" bgcolor="#E8FFA7" >详细经历：</td>
    <td height="22" colspan="3" align="left" bgcolor="#E8FFA7" ><textarea name="detailExperience" cols="50" rows="6" class="input">${resume.detailExperience}</textarea></td>
  </tr>
    <tr>
      <td style="display: none"><input name="user_name" type="text" value="${sessionScope.user_name}"></td>
    </tr>
  <tr>
    <td height="30" colspan="4" align="center" bgcolor="#E8FFA7" ><input id="interview" type="button" value="面试" />
      &nbsp;&nbsp;
      <input name="Submit2" type="reset" class="button" value="返回" onClick="history.back(-1);"><br/><br/>
      <div id="interviewtime" style="display: none">
        <form action="/insertInterview.action" method="post">

          请输入面试时间:<input name="interviewTime" type="text"/><input style="display: none" name="user_id"type="text" value="${resume.user_id}"/>
          <input type="submit" value="确定"/>

        </form></div>
    </td>
  </tr>


</table>
      <!-------------->		</td>
      </tr>
    </table>

      <div  style="position:absolute;left:980px; top:600px;font-size: 18px;color: red">
        ${data}
      </div>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

<script type="text/javascript">

    window.onload=function () {
        var department1="${resume.department}";
        var positon1="${resume.position}";
        if(department1==""){
        addDepartments();
        department.onchange= addPositions;

        }else {
            $("#jobForm").attr("action","/updateResume.action")
            var op1=new Option(department1,department1);
            var op2=new Option(positon1,positon1);
            department.options.add(op1);
            position.options.add(op2);
        }

    }
    var departments=["请选择"<c:forEach items="${departments}" var="department">
        ,"${department.departmentName}"
        </c:forEach>];
    var positions=[["请选择"]<c:forEach items="${departments}" var="department">
        ,[<c:forEach items="${department.positions}" var="position">
            "${position.positionName}",
            </c:forEach>]
        </c:forEach>];
    var department=document.getElementById("department");
    var position=document.getElementById("position");
    function addDepartments(){

        for(var i in departments){

            //获取下拉列表集合实例
            var op=new Option(departments[i],departments[i]);
            //将下拉列表各元素添加到元素中
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
            //添加对应下拉列表
            for (var i in positions[index]) {
                var op = new Option(positions[index][i], positions[index][i]);
                position.options.add(op);
            }
        }
    }
</script>
</body>
</html>
