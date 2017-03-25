<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<TITLE>未标题文档</TITLE>
<link href="${ctx}/css/frame/style.css" type="text/css" rel="stylesheet" />
<script language="javascript" src="${ctx}/css/button/script/jquery-1.3.2.min.js"></script>
<script language="JavaScript" type="text/javascript">
function Show(id,i_id){
        var on_img="${ctx}/img/frame/icon_02.jpg";//打开时图片
        var off_img="${ctx}/img/frame/icon_01.jpg";//隐藏时图片
        var obj=document.getElementById('c_'+id);
        if(obj.style.display=="none"){
                obj.style.display="";

        
       var totalShow = 24;  //自己修改一共有多少个二级分类
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
	    
        //document.getElementById(i_id).src=on_img;
        //将子菜单Id放入Cookies
        
        //将子菜单Id放入Cookies End
        }else{
            obj.style.display="none";
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
  var totalShow = 24;  //自己修改一共有多少个二级分类
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
<body style="overflow-x: hidden;overflow-y: auto; " onLoad="Show(18,'img18')">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<table height="100%" width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="border:1px #42426F solid;" >
    <tbody id="c_18" style="DISPLAY: none">
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="initTeachnologyTypeList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">工艺类型维护</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="initSpecialRequirementsList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">特殊加工要求维护</a>
            </td>
        </tr>
         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initNonconformingProductSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">不合格品现象维护</a>
            </td>
        </tr>
          <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="selMemberManagement.action?moduleID=${requestScope.moduleID}" target="mainFrame7">会员卡类别维护</a>
            </td>
        </tr>
                 <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initSearchRegisteredCategory.action?moduleID=${requestScope.moduleID}" target="mainFrame7">挂号类别维护</a>
            </td>
        </tr>
                 <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initAdditionalCostsList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">附加费用维护</a>
            </td>
        </tr>
        <%--<tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initCustomerSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">客户维护</a>
            </td>
        </tr>--%>
		
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="selUnit.action?moduleID=${requestScope.moduleID}" target="mainFrame7">计量单位维护</a>
            </td>
        </tr> 
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="selColor.action?moduleID=${requestScope.moduleID}" target="mainFrame7">商品颜色维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="selWarehouseConfiguration.action?moduleID=${requestScope.moduleID}" target="mainFrame7">门店仓位配置</a>
            </td>
        </tr>         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initRegionalConfigurationSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">门店所属加工区域配置</a>
            </td>
        </tr>         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initCustomerSatisfactionSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">回访满意度维护</a>
            </td>
        </tr>         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initRefractiveSetSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">折射率维护</a>
            </td>
        </tr>         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initDelayWarning.action?moduleID=${requestScope.moduleID}" target="mainFrame7">预误期提醒设定</a>
            </td>
        </tr>

		<tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initBrankCardList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">公司存款银行卡维护</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initSelectBankList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">顾客非现金结款类型维护</a>
            </td>
        </tr>
		
		<tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initWorkTypeList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">职业维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initSelectPersonType.action?moduleID=${requestScope.moduleID}" target="mainFrame7">人群分类</a>
            </td>
        </tr>
		
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="initComplaintsTypeSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">投诉类型维护</a>
            </td>
        </tr>
		
		<tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initForeignRecipelSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">外来处方维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initInterestList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">兴趣爱好维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="selectMemberOrigin.action?moduleID=${requestScope.moduleID}" target="mainFrame7">会员来源维护</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            	&nbsp;<a href="selectCustomerAgeGroup.action?moduleID=${requestScope.moduleID}" target="mainFrame7">顾客年龄区间维护</a>
            </td>
        </tr>
         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initFrameMaterialList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">镜架材质维护</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initFittingTemplateTypeSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">打印单据配置</a>
            </td>
        </tr>        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="selectSalesArea.action?moduleID=${requestScope.moduleID}" target="mainFrame7">价格区间维护</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initNoticeTypeSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">公告类型维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initRepairsCostSetSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">维修项维护</a>
            </td>
        </tr>
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initGetMachineValue.action?moduleID=${requestScope.moduleID}" target="mainFrame7">焦度计取值维护</a>
            </td>
        </tr>

        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initSalesRecipeNumView.action?moduleID=${requestScope.moduleID}" target="mainFrame7">显示处方数量维护</a>
            </td>
        </tr>

        
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="selMailingList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">邮寄单维护</a>
            </td>
        </tr>
                


        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initOptionParamSel.action?moduleID=${requestScope.moduleID}" target="mainFrame7">下拉数据维护</a>
            </td>
        </tr>  
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initGoodsLevelList.action?moduleID=${requestScope.moduleID}" target="mainFrame7">商品级别维护</a>
            </td>
        </tr>  
        
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>            
            	&nbsp;<a href="initDoubleEyeFunMend.action?moduleID=${requestScope.moduleID}" target="mainFrame7">双眼视功能模块必填项设置</a>
            </td>
        </tr>             

    </tbody>
</table>
</body>
</HTML>