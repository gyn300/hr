<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<script type="text/javascript" src="Js/js.js"></script>
<script type="text/javascript">
    $(function () {
        $("#ImgUser").mouseover(function () {
            $("#ImgUser").attr("src","images/NUser_r.GIF");
        })

        $("#ImgUser").mouseout(function () {
            $("#ImgUser").attr("src","images/NUser_b.GIF");
        })


        $("#ImgJob").mouseover(function () {
            $("#ImgJob").attr("src","images/NJob_r.GIF");
        })

        $("#ImgJob").mouseout(function () {
            $("#ImgJob").attr("src","images/NJob_b.GIF");
        })

        $("#ImgEducate").mouseover(function () {
            $("#ImgEducate").attr("src","images/NEducate_r.GIF");
        })

        $("#ImgEducate").mouseout(function () {
            $("#ImgEducate").attr("src","images/NEducate_b.GIF");
        })
        $("#ImgInstitution").mouseover(function () {
            $("#ImgInstitution").attr("src","images/NInstitution_r.GIF");
        })

        $("#ImgInstitution").mouseout(function () {
            $("#ImgInstitution").attr("src","images/NInstitution_b.GIF");
        })
        $("#ImgStipend").mouseover(function () {
            $("#ImgStipend").attr("src","images/NStipend_r.GIF");
        })

        $("#ImgStipend").mouseout(function () {
            $("#ImgStipend").attr("src","images/NStipend_b.GIF");
        })

        $("#ImgExit").mouseover(function () {
            $("#ImgExit").attr("src","images/NExit_r.GIF");
        })

        $("#ImgExit").mouseout(function () {
            $("#ImgExit").attr("src","images/NExit_b.GIF");
        })
    })

</script>
<div style="position:absolute;left:100px; top:20px;height: 20px;font-size: 18px;color: blue" ><span style="color: black">欢迎:</span>${sessionScope.user_name}</div>
	<div style="position:absolute">	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td ><a href="/onjobemployeeadmin.jsp" style="font-weight: bold;font-size: 18px">员工管理&nbsp;/</a><div id="NUser" style="background-color:#F3FFD5; border:#75A102 1px solid; width:200px; position:absolute; display:none; left:1px; top: 34px;">
		
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table></div></td>
        <td ><a href="/getResumeList.action" style="font-weight: bold;font-size: 18px">&nbsp;招聘管理&nbsp;/</a><div id="NJob" style="background-color:#F3FFD5; border:#c6e07f 1px solid; width:230px; position:absolute; left:110px; display:none; top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table>
        </div></td>
          <td ><a href="/adminGetDepartmentList.action" style="font-weight: bold;font-size: 18px">&nbsp;部门职位&nbsp;/</a><div style="background-color:#c5df7f; border:#c5de80 1px solid; width:230px; position:absolute; left:110px; display:none; top: 34px;">
              <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

              </table>
          </div></td>
        <td><a href="/getEaducateList.action" style="font-weight: bold;font-size: 18px">&nbsp;培训管理&nbsp;/</a><div id="NEducate" style="background-color:#F3FFD5; border:#75A102 1px solid; width:240px; position:absolute; display:none;left:222px;  top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table>
        </div></td>
        <td ><a href="/adminbonuspenaltylist.jsp" style="font-weight: bold;font-size: 18px">&nbsp;奖惩管理&nbsp;/</a><div id="NInstitution" style="background-color:#F3FFD5; border:#75A102 1px solid; width:180px; position:absolute; display:none; left:332px;  top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table>
        </div></td>
        <td ><a href="/adminsalarylist.jsp" style="font-weight: bold;font-size: 18px">&nbsp;薪金管理&nbsp;/</a><div id="NStipend" style="background-color:#F3FFD5; border:#75A102 1px solid; width:180px; position:absolute; display:none;left:446px;  top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table>
        </div></td>
          <td ><a href="/getObjectionList.action" style="font-weight: bold;font-size: 18px">&nbsp;工资异议&nbsp;/</a><div  style="background-color:#F3FFD5; border:#75A102 1px solid; width:180px; position:absolute; display:none;left:446px;  top: 34px;">
              <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

              </table>
        </div></td>
        <td><a href="/quit.action"  style="font-weight: bold;font-size: 18px">&nbsp;退出</a></td>

      </tr>
    </table>

</div>	