<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<TITLE>未标题文档</TITLE>
<link href="css/frame/style.css" type="text/css" rel="stylesheet" />
<script language="JavaScript" type="text/javascript">
function Show(id,i_id){
        var on_img="${ctx}/img/frame/icon_02.jpg";//打开时图片
        var off_img="${ctx}/img/frame/icon_01.jpg";//隐藏时图片
        var obj=document.getElementById('c_'+id);
        if(obj.style.display=='none'){
                obj.style.display="";

        
       var totalShow = ${fn:length(rootModules)};  //自己修改一共有多少个二级分类
       for(i=0;i<totalShow;i++)
	    {
	    	if(id == i) continue;
	    	
	    	var img =  document.getElementById('img' + i);
	    	if(img == null) continue;
	    	
	    	document.getElementById('c_'+i).style.display = 'none';
	      	//$('#c_'+i).hide();
	      	//alert(document.getElementById('img' + i));
	      	//alert('img' + i);
	      	 img.src = off_img;
	    }
	    
        document.getElementById(i_id).src=on_img;
        //将子菜单Id放入Cookies
        
        //将子菜单Id放入Cookies End
        }else{
                obj.style.display="none";
         document.getElementById(i_id).src=off_img;
        
        }

}

function readCookie(name)

{

  var cookieValue = "";

  var search = name + "=";

  if(document.cookie.length > 0)

  {

    offset = document.cookie.indexOf(search);

    if (offset != -1)

    {

      offset += search.length;

      end = document.cookie.indexOf(";", offset);

      if (end == -1) end = document.cookie.length;

      cookieValue = unescape(document.cookie.substring(offset, end))

    }

  }

  return cookieValue;

}

function writeCookie(name, value, hours)

{

  var expire = "";

  if(hours != null)

  {

    expire = new Date((new Date()).getTime() + hours * 3600000);

    expire = "; expires=" + expire.toGMTString();

  }

  document.cookie = name + "=" + escape(value) + expire;

}
Array.prototype.del=function(n) {  //n表示第几项，从0开始算起。
//prototype为对象原型，注意这里为对象增加自定义方法的方法。
  if(n<0)  //如果n<0，则不进行任何操作。
    return this;
  else
    return this.slice(0,n).concat(this.slice(n+1,this.length));
}


/*window.onload = function a()
{
  var on_img="${ctx}/img/frame/icon_02.jpg";//打开时图片
  var off_img="${ctx}/img/frame/icon_01.jpg";//隐藏时图片
  
  var curShow = readCookie('curShow');
  var totalShow = ${fn:length(rootModules)};  //自己修改一共有多少个二级分类
  if(curShow!=''&&curShow!=null)
  {
    for(i=0;i<=totalShow;i++)
    {
      $('#c_'+i).hide();
    }
    var arr_curShow;
    arr_curShow = curShow.split(',');
    for(i=0;i<arr_curShow.length-1;i++)
    {
      if(arr_curShow[i]!=''){
      	$('#c_'+arr_curShow[i]).show();
      	document.getElementById('img' + i).src = off_img;
      }else {
      	document.getElementById('img' + i).src = on_img;
      }
    }

  }
}*/
</script>
</HEAD>
<body scroll="yes" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<table width="210" border="0" align="center" cellpadding="0" cellspacing="0" class="lefttable mt-3">
        <tr>
            <td align="center" valign="middle" class="leftmenutop f12 fb">操作菜单</td>
        </tr>
         <tbody>
        <tr>
            <td class="leftmenu1">
            <a target="mainFrame" style="CURSOR: pointer" onclick="Show(0,'img0')">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	                <tr>
	                  <td width="35" height="28"><div class="image"><img src="${ctx }/img/menu/Symbol_Rights.png" border="0" width="20px"></div></td>
	                  <td class="pt-2"><div class="icon"><img id="img0" align="absMiddle" src="${ctx }/img/frame/icon_01.jpg" /></div>&nbsp;&nbsp;系统设置</td>
	                </tr>
            	</table></a>
            </td>
        </tr>
    </tbody>
    <tbody id="c_0" style="DISPLAY: none">
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initSystemModuleSel.action?moduleID=F0101'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;系统模块维护</li>
            </td>
        </tr>
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initRolePermissionSet.action?moduleID=F0120'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;系统模块选取</li>
            </td>
        </tr>
        <tr> 
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initSystemParameter.action?moduleID=F0103&companyAdmin=companyAdmin'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;系统参数设定</li>
            </td>
        </tr>
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initMacSel.action?moduleID=F0110'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;客户机维护</li>
            </td>
        </tr>
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initInventoryDifferenceSel.action?moduleID=F0111'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;异常数据查询</li>
            </td>
        </tr>
		<tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initExternalAccountParameter.action?moduleID=V0606'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;外账参数设置</li>
            </td>
        </tr>
		<tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initPrintBillTemplateSel.action?moduleID=B0101'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;报表样式维护</li>
            </td>
        </tr>    
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initReportQuartzDataInsert.action?moduleID=F9111'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;定时任务开关维护</li>
            </td>
        </tr> 
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initSqlIndexRecreate.action'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;系统访问速度优化</li>
            </td>
        </tr>              
    </tbody>
        <tbody>
        <tr>
            <td class="leftmenu1">
            <a target="mainFrame" style="CURSOR: pointer" onclick="Show(1,'img1')">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	                <tr>
	                  <td width="35" height="28"><div class="image"><img src="${ctx }/img/menu/server.png" border="0" width="20px"></div></td>
	                  <td class="pt-2"><div class="icon"><img id="img1" align="absMiddle" src="${ctx }/img/frame/icon_01.jpg" /></div>&nbsp;&nbsp;基础信息</td>
	                </tr>
            	</table></a>
            </td>
        </tr>
    </tbody>
    <tbody id="c_1" style="DISPLAY: none">
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initDepartmentSel.action?moduleID=B0103'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;部门维护</li>
            </td> 
        </tr>
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initPersonInfoSel.action?moduleID=B0105'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;人员维护</li>
            </td>
        </tr>
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initRoleList.action?moduleID=B0106'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;角色维护</li>
            </td>
        </tr>
        
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initDepartmentDateSel.action?moduleID=B0103'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;部门期初维护</li>
            </td> 
        </tr>
        
        <tr>
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='initAccountPeriodSet.action?moduleID=F0103'">
            <li class="horizontal_onlyRight">&nbsp;<img src="${ctx }/img/menu/Symbol_Right.png" width="16px"/></li>
            <li class="horizontal_onlyRight">&nbsp;初始化账期</li>
            </td> 
        </tr>
        
    </tbody>
</table>
</body>
</HTML>