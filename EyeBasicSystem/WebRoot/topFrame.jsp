<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link href="${ctx}/css/frame/style.css" rel="stylesheet" type="text/css" />
<script>
	function exitSys(){
	    if ('${confirmSwitch}' == '1'){
	        if(confirm('你确认退出系统吗？')){
	            parent.window.location.href='loginOut.action';
            }
	    }else{
	        parent.window.location.href='loginOut.action';
	    }
	}
	
	function toReload(){
		window.location.reload(); 
	}
	
	function pswd(){
		if('${person.id}'=='admin'){
			alert('管理员密码不能修改！');
		}else{
		    var   WLeft   =   Math.ceil((window.screen.width-500)   /   2   );   
			var   WTop   =   Math.ceil((window.screen.height-460)   /   2   );  
			window.open('initPswdUpdate.action','','height=400,width=500,top='+WTop+',left='+WLeft+',toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no,status=no');
		}		
	}
	
	function chooseDepartment(){
		if('${person.id}'=='admin'){
			alert('管理员不能切换部门！');
		}else{
		    parent.window.location.href = "initAffirmDepartment.action";
		}
	}

	function gotoIndex(){
		top.mainFrame.location.href="getRightFrame.action";
	}

	function clickFlySheet(){

		if ('${fquartzSwitchPo.fqscdpjd}' == '1'){
			var targeturl='';
			var flag = '';
			if ('${fquartzSwitchPo.fqswzhzstd}' == '1' && '${externalAccountParameterPo.feaexternaladdress}' != ''){
				targeturl='${externalAccountParameterPo.feaexternaladdress}';
				flag = '1';
			}else if ('${fquartzSwitchPo.fqswzhzstd}' == '2' && '${externalAccountParameterPo.feaaccessaddress}' != ''){
				targeturl='${externalAccountParameterPo.feaaccessaddress}';
				flag = '1';
			}else{
				flag = '';
			}

			if (flag == ''){
	            return;
			}
			
			newwin=parent.window.open("","",'scrollbars');
			newwin.moveTo(0,0);
			newwin.resizeTo(screen.width,screen.height);
			newwin.location=targeturl;
			parent.window.opener=null;
			parent.window.open("","_self"); 
			newwin.focus(); 
			parent.window.close();	
	    }

	}

	function changeTable(tabTitle, url, icon){
		parent.window.mainFrame.addTab(tabTitle, url, "");
	}
</script>
</head>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="topFrm" name="topFrm" action="" method="post">
<table id="companyTab" width="100%" height="99" border="0" cellpadding="0" cellspacing="0" style="background: url(${ctx}/${companyNamePo.fcnbackGroundPath});background-repeat:repeat-x; ">
  <tr id="companyTr" style="background-image: url(${ctx}/${companyNamePo.fcnLogoPath});background-repeat:no-repeat" width="700" height="70">
    <td align="left" style="padding-left: ${empty(companyNamePo.fcnleftnum)||companyNamePo.fcnleftnum == '' ? '170':companyNamePo.fcnleftnum}" >
        <span id="fcnName" style="font-family: 微软雅黑;font-size: 28;color: white;font: bold">${companyNamePo.fcnName}</span>
    </td>
  </tr>
  <tr>
    <td ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td id="td1" align="left" valign="middle" class="menuleft" width="300">&nbsp;${person.bdpdepartmentname}：${person.personName}</td>
        <td id="td2" align="left" valign="middle" class="menuleft" width="20" onclick="clickFlySheet();"></td>
        <td id="td3" align="right" valign="middle" class="menuleft" width="auto">&nbsp;</td>
        <td width="58"><img src="${ctx}/img/frame/index_04.jpg" width="58" height="30" /></td>
        <td width="440" align="left" valign="middle" class="menuright"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="left">
            <td width="25"><img src="${ctx}/img/frame/icon/jinhuo.gif" width="18" height="18" /></td>
            <td width="70"><a href="javascript:gotoIndex();">我的主页</a></td>  
            <td width="10" align="left" style="color: #ffffff">|</td>  
            <td width="25"><img src="${ctx}/img/frame/icon/jinhuo.gif" width="18" height="18" /></td>
            <td width="70"><a href="javascript:chooseDepartment();">部门切换</a></td>  
            <td width="10" align="left" style="color: #ffffff">|</td>        
            <td width="25"><img src="${ctx}/img/frame/icon/jinhuo.gif" width="18" height="18" /></td>
            <td width="70"><a href="javascript:pswd();">修改密码</a></td>
            <td width="10" align="left" style="color: #ffffff">|</td>
            <td width="25"><img src="${ctx}/img/frame/pic/about.gif" width="22" height="22" /></td>
            <td width="30"><a href="#" onclick="changeTable('个人设置','initPersonSetOptionSel.action','')">设置</a></td>
            <td width="10" align="left" style="color: #ffffff">|</td>
            <td width="25"><img src="${ctx}/img/frame/pic/help.gif" width="22" height="22" /></td>
            <td width="40"><a href="#">帮助</a></td>
            <td width="10" align="left" style="color: #ffffff">|</td>            
			<td width="25"><img src="${ctx}/img/frame/pic/close.gif" width="18" height="18" /></td>
            <td width="40"><a href="javascript:exitSys();">注销</a></td>
            <td width="15">&nbsp;</td>                        
          </tr>
          </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
