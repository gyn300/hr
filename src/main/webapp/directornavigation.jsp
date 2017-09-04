<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>

<script type="text/javascript" src="Js/js.js"></script>
<script type="text/javascript">
    $(function () {


    })

</script>
<div style="position:absolute;left:100px; top:20px;height: 20px;font-size: 18px;color: blue" ><span style="color: black">欢迎:</span>${sessionScope.user_name}</div>
	<div style="position:absolute">

        <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr >
        <td ><a id="feedback" href="/directorNotice.action" style="font-weight: bold;font-size: 18px">通知管理&nbsp;</a><div id="NUser" style="background-color:#F3FFD5; border:#75A102 1px solid; width:200px; position:absolute; display:none; left:1px; top: 34px;">
		
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table></div></td>
          <td ><span style="font-weight: bold;font-size: 18px">/</span><a id="checkcv" href="/getDirectorEmployeeList.action" style="font-weight: bold;font-size: 18px">&nbsp;绩效管理&nbsp;</a><div id="NJob" style="background-color:#F3FFD5; border:#75A102 1px solid; width:230px; position:absolute; left:110px; display:none; top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table>
        </div></td>


        <td ><span style="font-weight: bold;font-size: 18px">/</span><a id="exit" href="/quit.action" style="font-weight: bold;font-size: 18px">&nbsp;退出</a><div id="NStipend" style="background-color:#F3FFD5; border:#75A102 1px solid; width:180px; position:absolute; display:none;left:446px;  top: 34px;">
          <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">

</table></div>
        </td>

      </tr>
    </table>

</div>	