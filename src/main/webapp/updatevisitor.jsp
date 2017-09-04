<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script src="Js/js.js"></script>
<
<script type="text/javascript">
  $(function () {
    /*当鼠标离开重复密码文本框时，提示文本及样式*/
      $("#repassword").blur(flagRepwd=function (){
          var $repwd=$("#repassword");
          var $pwd=$("#password");
          var $repwdId=$("#message");
          if($repwd[0].value==""){
              $repwdId[0].innerHTML="重复密码不能为空，请重复输入密码";
              return false;
          }
          if($repwd[0].value!=$pwd[0].value){

              $repwdId[0].innerHTML="两次输入的密码不一致，请重新输入";
              return false;
          }

          $repwdId[0].innerHTML="两次密码输入正确";
          return true;
      });
    /*提交修改信息*/
      $("input:submit").click(function () {
          if(flagRepwd()){
              return true
           }else{
              return false;
          }



      });
  })
</script>
<body>
<div style="position:absolute;left:100px; top:20px;height: 20px;font-size: 18px;color: blue" ><span style="color: black">欢迎:</span>${sessionScope.user_name}</div>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
    <td width="772" height="48" valign="top">
		<jsp:include page="visitornavigation.jsp"/>
	
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
    <td height="22" colspan="4" align="center" class="word_yellow" >-修改密码-</td>
  </tr>
  <form id="userForm" name="userForm" method="post" action="/updateVisitorPwd.action">
    <input style="display: none" name="user_name" value="${sessionScope.user_name}">

  <tr id="pwd" >

    <td width="28%" height="22" align="left" bgcolor="#E8FFA7" >原密码：
      <input name="password_old" type="password" class="input" value=""></td>
    <td width="29%" align="left" bgcolor="#E8FFA7" >新密码：
      <input id="password" name="password" type="password" class="input" value=""></td>
    <td width="31%" align="left" bgcolor="#E8FFA7" >确认新密码：
      <input id="repassword" name="password_new" type="password" class="input" value="">
	<input type="hidden"  name="hpassword_old" value="">
	</td>
    </tr>


  <tr>
    <td height="22" colspan="4" align="center" bgcolor="#E8FFA7" ><input name="Submit" type="submit" class="button" value="提交">
      &nbsp;&nbsp;
      <input name="Submit2" type="reset" class="button" value="重置">
      &nbsp;&nbsp;
      <input name="Submit3" type="button" class="button" value="返回" onClick="history.back(-1);"></td>
  </tr>
  </form>
</table>
          <div id="message" style="position:absolute;left:960px; top:400px;font-size: 18px;color: red">
            ${data}
          </div>
<!-------------->		</td>
      </tr>
    </table>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>
</body>
</html>
