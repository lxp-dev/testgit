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


	function changeTable(tabTitle, url, icon){
		parent.window.mainFrame.addTab(tabTitle, url, "");
	}
</script>
</HEAD>
<body scroll="yes" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<table width="210" border="0" align="center" cellpadding="0" cellspacing="0" class="lefttable mt-3">
        <tr>
            <td align="center" valign="middle" class="leftmenutop f12 fb">操作菜单</td>
        </tr>
<c:if test="${not empty(rootModules)}">
	<c:forEach items="${rootModules}" var="item" varStatus="index">
	<c:if test="${fn:length(item.childModules) > 0 }">
        <tbody>
        <tr>
            <td class="leftmenu1">
            <a target="mainFrame" style="CURSOR: pointer" onclick="Show(${index.index },'img${index.index }')">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	                
	                <tr>
	                  <td width="35" height="28"><div class="image"><img src="${ctx}${item.moduleicon }" border="0" width="20px"></div></td>
	                  <td class="pt-2"><div class="icon"><img id="img${index.index }" align="absMiddle" src="${ctx}/img/frame/icon_01.jpg" /></div>&nbsp;&nbsp;${item.modulecname}</td>
	                </tr>
	                
            	</table></a>
            </td>
        </tr>
    </tbody>
    <c:if test="${not empty(item.childModules)}">
    <tbody id="c_${index.index }" style="DISPLAY: none">
    <c:forEach items="${item.childModules}" var="childModule" >
        <tr>
        <c:if test="${childModule.moduledirectory == null}">
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="window.parent.mainFrame.location='javaScript:void(0)'">
            <li class="horizontal_onlyRight">
            &nbsp;<img src="${ctx}${childModule.moduleicon }" width="16px"/>
            </li><li class="horizontal_onlyRight">&nbsp;<a href="javaScript:void(0)" target="mainFrame">${childModule.modulecname}</a></li>
            </td>
            </c:if>
            <c:if test="${childModule.moduledirectory != null}">
            <td style="CURSOR: pointer" class="leftmenu2" valign="middle" onclick="changeTable('${childModule.modulecname}','${childModule.moduledirectory}?moduleID=${childModule.moduleid }','${ctx}${childModule.moduleicon }')">
            <li class="horizontal_onlyRight">
            &nbsp;<img src="${ctx}${childModule.moduleicon }" width="16px"/>
            </li><li class="horizontal_onlyRight">&nbsp;${childModule.modulecname}</li>
            </td>
            </c:if>
        </tr>
	</c:forEach>
    </tbody>
    </c:if>
	</c:if>
	</c:forEach>
</c:if>
</table>
</body>
</HTML>	