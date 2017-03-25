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
         //document.getElementById(i_id).src=off_img;
        
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
<body  scroll="yes" onLoad="Show(18,'img18')">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<table width="240" border="0" align="center" cellpadding="0" cellspacing="0" style="border:1px #42426F solid;" >
    <tbody id="c_18" style="DISPLAY: none">
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initExportFile.action?moduleID=${requestScope.moduleID}" target="mainFrame9">商品信息导出</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initImportFile.action?moduleID=${requestScope.moduleID}" target="mainFrame9">商品库存信息导入</a>
            </td>
        </tr>
         <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initExportAmountFile.action?moduleID=${requestScope.moduleID}" target="mainFrame9">物流商品期初信息导出</a>
            </td>
        </tr>
          <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initImportAmountFile.action?moduleID=${requestScope.moduleID}" target="mainFrame9">物流商品期初信息导入</a>
            </td>
        </tr>
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initSystemClear.action?moduleID=${requestScope.moduleID}" target="mainFrame9">数据清理</a>
            </td>
        </tr>         
        <tr>
            <td class="leftmenu2" valign="middle">&nbsp;<img src="${ctx}/img/menu/Symbol_Right.png" width="16px"/>
            
            	&nbsp;<a href="initDefaultAverageCostSet.action?moduleID=${requestScope.moduleID}" target="mainFrame9">默认加权平均成本设置</a>
            </td>
        </tr>        
    </tbody>
</table>
</body>
</HTML>